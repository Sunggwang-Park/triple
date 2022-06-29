package com.sunggwang.triple.controller;

import com.sunggwang.triple.domain.review.dto.ReviewEventRequestDto;
import com.sunggwang.triple.domain.review.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final ReviewService reviewService;

    @PostMapping("")
    public void event(@RequestBody ReviewEventRequestDto dto) {
        System.out.println("dto = " + dto);
        if (dto.getType().equals("REVIEW")) {
            if (dto.getAction().equals("DELETE")) {
                reviewService.lostPoints(dto);
            } else {
                reviewService.getPoints(dto);
            }
        }
    }


}
