package com.sunggwang.triple.domain.pointHistory.dto;


import com.sunggwang.triple.domain.place.entity.Place;
import com.sunggwang.triple.domain.pointHistory.entity.PointHistory;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Getter
@Builder
public class PointHistoryResponseDto {

    Long pointHistoryId;

    String history;

    UUID reviewId;

    UUID userId;

    UUID placeId;

    LocalDateTime createdAt;



    public static PointHistoryResponseDto toDto(PointHistory pointHistory) {
        return PointHistoryResponseDto.builder()
                .pointHistoryId(pointHistory.getId())
                .history(pointHistory.getHistory())
                .reviewId(pointHistory.getReviewId())
                .userId(pointHistory.getUser().getId())
                .placeId(pointHistory.getPlace().getId())
                .createdAt(pointHistory.getCreatedDateTime())
                .build();

    }
}
