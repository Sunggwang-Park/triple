package com.sunggwang.triple.domain.review.service;

import com.sunggwang.triple.domain.review.dao.ReviewRepository;
import com.sunggwang.triple.domain.review.dto.ReviewEventRequestDto;
import com.sunggwang.triple.domain.user.dao.UserRepository;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public void getPoints(ReviewEventRequestDto dto) {
        User user = userRepository.getReferenceById(dto.getUserId());


    }

    public void lostPoints(ReviewEventRequestDto dto) {

    }
}
