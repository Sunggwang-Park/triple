package com.sunggwang.triple.domain.review.service;

import com.sunggwang.triple.domain.place.dao.PlaceRepository;
import com.sunggwang.triple.domain.place.entity.Place;
import com.sunggwang.triple.domain.review.dao.ReviewRepository;
import com.sunggwang.triple.domain.review.dto.ReviewEventRequestDto;
import com.sunggwang.triple.domain.review.dto.ReviewEventResponseDto;
import com.sunggwang.triple.domain.review.entity.Review;
import com.sunggwang.triple.domain.user.dao.UserRepository;
import com.sunggwang.triple.domain.user.entity.User;
import com.sunggwang.triple.exception.CustomException;
import com.sunggwang.triple.exception.ErrorCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;

    @Transactional
    public ReviewEventResponseDto getPoints(ReviewEventRequestDto dto) {
        System.out.println("dto = " + dto);
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_USER, "존재하지 않는 userId : " + dto.getUserId());
                });
        Place place = placeRepository.findById(dto.getPlaceId())
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_PLACE, "존재하지 않는 placeId : " + dto.getPlaceId());
                });

        Review review;


        if (dto.getAction().equals("ADD")) {
            review = dto.toEntity(dto, user, place);
            review.update();

            place.checkFirstReview(user,review);
            reviewRepository.save(review);

        } else {    //"MOD"
            review = reviewRepository.findById(dto.getReviewId())
                    .orElseThrow(() -> {
                        throw new CustomException(ErrorCode.NOT_FOUND_REVIEW, "존재하지 않는 reviewId :" + dto.getReviewId());
                    });

            //review 업데이트
            review.update(user, dto.getContent(), dto.getAttachedPhotoIds());

        }

        return ReviewEventResponseDto.toDto(review, user, place);

    }

    @Transactional
    public ReviewEventResponseDto lostPoints(ReviewEventRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_USER, "존재하지 않는 userId : " + dto.getUserId());
                });
        Place place = placeRepository.findById(dto.getPlaceId())
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_PLACE, "존재하지 않는 placeId : " + dto.getPlaceId());
                });
        Review review = reviewRepository.findById(dto.getReviewId())
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_REVIEW, "존재하지 않는 reviewId :" + dto.getReviewId());
                });

        //review 업데이트
        review.delete(user,place);

        reviewRepository.deleteById(review.getId());

        return ReviewEventResponseDto.toDto(review, user, place);

    }
}
