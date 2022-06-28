package com.sunggwang.triple.domain.user.dto;

import com.sunggwang.triple.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class UserResponseDto {

    private UUID userId;
    private Long points;

    public static UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .userId(user.getId())
                .points(user.getPoint())
                .build();

    }
}
