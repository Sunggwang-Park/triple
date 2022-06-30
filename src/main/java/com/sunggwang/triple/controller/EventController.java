package com.sunggwang.triple.controller;

import com.sunggwang.triple.domain.review.dto.ReviewEventRequestDto;
import com.sunggwang.triple.domain.review.dto.ReviewEventResponseDto;
import com.sunggwang.triple.domain.review.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final ReviewService reviewService;

    @PostMapping("")
    @ResponseBody
    public ReviewEventResponseDto event(@RequestBody ReviewEventRequestDto dto) {
        System.out.println("dto = " + dto);
        if (dto.getType().equals("REVIEW")) {
            if (dto.getAction().equals("DELETE")) {
                return reviewService.lostPoints(dto);
            } else {
                return reviewService.getPoints(dto);
            }
        }
        return null;
    }


}
