package com.sunggwang.triple.domain.review.controller;


import com.sunggwang.triple.domain.review.dto.ReviewEventRequestDto;
import com.sunggwang.triple.domain.review.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping ("events")
    public void reviewEvent(ReviewEventRequestDto dto) {

        if (dto.getType().equals("DELETE") == false) {
            reviewService.getPoints(dto);
        } else {
            reviewService.lostPoints(dto);
        }





    }
}
