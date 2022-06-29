package com.sunggwang.triple.domain.review.service;

import com.sunggwang.triple.domain.place.dao.PlaceRepository;
import com.sunggwang.triple.domain.place.entity.Place;
import com.sunggwang.triple.domain.review.dto.ReviewEventRequestDto;
import com.sunggwang.triple.domain.user.dao.UserRepository;
import com.sunggwang.triple.domain.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaceRepository placeRepository;


    @Test
    public void 포인트_획득() throws Exception {
        //given
        UUID userId = UUID.fromString("3ede0ef2-92b7-4817-a5f3-0c575361f745");
        UUID placeId = UUID.fromString("2e4baf1c-5acb-4efb-a1af-eddada31b00f");

        User user = User.createUser(userId);
        userRepository.save(user);

        Place place = Place.createPlace(placeId);
        placeRepository.save(place);


        UUID reviewId = UUID.fromString("240a0658-dc5f-4878-9381-ebb7b2667772");

        ReviewEventRequestDto dto = ReviewEventRequestDto.builder()
                .type("REVIEW")
                .action("ADD")
                .reviewId(reviewId)
                .content("좋아요")
                .userId(userId)
                .placeId(placeId)
                .build();
        
        //when
        reviewService.getPoints(dto);
        
        //then
        Assertions.assertThat(user.getPoint()).isEqualTo(1L);
    }

}