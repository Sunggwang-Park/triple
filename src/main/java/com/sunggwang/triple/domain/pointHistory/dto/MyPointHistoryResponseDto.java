package com.sunggwang.triple.domain.pointHistory.dto;

import com.sunggwang.triple.domain.pointHistory.entity.PointHistory;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;


@Builder
@Data
@Getter
public class MyPointHistoryResponseDto {

    User user;

    Stream<PointHistoryResponseDto> history;

    public static MyPointHistoryResponseDto toDto(User user, List<PointHistory> history) {
        return MyPointHistoryResponseDto.builder()
                .user(user)
                .history(history.stream().map(PointHistoryResponseDto::toDto))
                .build();
    }

}
