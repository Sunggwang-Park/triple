package com.sunggwang.triple.domain.pointHistory.service;


import com.sunggwang.triple.config.BeanUtil;
import com.sunggwang.triple.domain.pointHistory.dto.MyPointHistoryRequestDto;
import com.sunggwang.triple.domain.pointHistory.dto.MyPointHistoryResponseDto;
import com.sunggwang.triple.domain.pointHistory.entity.PointHistory;
import com.sunggwang.triple.domain.pointHistory.repository.PointHistoryRepository;
import com.sunggwang.triple.domain.user.dao.UserRepository;
import com.sunggwang.triple.domain.user.entity.User;
import com.sunggwang.triple.exception.CustomException;
import com.sunggwang.triple.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointHistoryService {

    private final UserRepository userRepository;

    public List<PointHistory> getAll() {
        PointHistoryRepository pointHistoryRepository = BeanUtil.getBean(PointHistoryRepository.class);
        return pointHistoryRepository.findAll();

    }

    public MyPointHistoryResponseDto getMyHistory(MyPointHistoryRequestDto dto) {
        PointHistoryRepository pointHistoryRepository = BeanUtil.getBean(PointHistoryRepository.class);
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_USER, "존재하지 않는 userId : " + dto.getUserId());
                });

        return MyPointHistoryResponseDto.toDto(user,
                pointHistoryRepository.findAllByUser(user));

    }
}
