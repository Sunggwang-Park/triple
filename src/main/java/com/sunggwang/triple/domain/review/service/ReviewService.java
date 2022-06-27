package com.sunggwang.triple.domain.review.service;

import com.sunggwang.triple.domain.review.dao.ReviewRepository;
import com.sunggwang.triple.domain.review.dto.ReviewEventRequestDto;
import com.sunggwang.triple.domain.review.entity.Review;
import com.sunggwang.triple.domain.user.dao.UserRepository;
import com.sunggwang.triple.domain.user.entity.User;
import com.sunggwang.triple.exception.CustomException;
import com.sunggwang.triple.exception.ErrorCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public void getPoints(ReviewEventRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_USER, "존재하지 않는 userId :" + dto.getUserId());
                });

        if (dto.getType().equals("ADD")) {
            if (dto.getContent().length() >= 1) {
                user.earnTextPoint();
            }
            if (dto.getAttachedPhotoIds().size() >= 1) {
                user.earnPhotoPoint();
            }
        } else {    //"MOD"
            Review review = reviewRepository.findById(dto.getReviewId())
                    .orElseThrow(() -> {
                        throw new CustomException(ErrorCode.NOT_FOUND_REVIEW, "존재하지 않는 reviewId :" + dto.getReviewId());
                    });
            if (dto.getContent() == null) {
                if (review.getContent().length() >= 1) {
                    user.lostPoint();
                }
            }
            if (dto.getAttachedPhotoIds() == null) {
                if (review.getPhotos().size() >= 1) {
                    user.lostPoint();
                }
            }


        }


    }

    public void lostPoints(ReviewEventRequestDto dto) {

    }
}
