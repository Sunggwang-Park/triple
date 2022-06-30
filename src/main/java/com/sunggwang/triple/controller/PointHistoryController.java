package com.sunggwang.triple.controller;


import com.sunggwang.triple.domain.pointHistory.dto.MyPointHistoryRequestDto;
import com.sunggwang.triple.domain.pointHistory.dto.PointHistoryResponseDto;
import com.sunggwang.triple.domain.pointHistory.dto.MyPointHistoryResponseDto;
import com.sunggwang.triple.domain.pointHistory.entity.PointHistory;
import com.sunggwang.triple.domain.pointHistory.service.PointHistoryService;
import com.sunggwang.triple.domain.user.entity.User;
import com.sunggwang.triple.exception.CustomException;
import com.sunggwang.triple.exception.ErrorCode;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@RequestMapping("/points")
public class PointHistoryController {

    private final PointHistoryService pointHistoryService;


    @GetMapping("")
    @ResponseBody
    public Stream<PointHistoryResponseDto> allHistory() {
        List<PointHistory> all = pointHistoryService.getAll();

        return all.stream().map(PointHistoryResponseDto::toDto);
    }


    @GetMapping("my")
    @ResponseBody
    public MyPointHistoryResponseDto myHistory(@RequestBody MyPointHistoryRequestDto dto) {
        return pointHistoryService.getMyHistory(dto);


    }


}
