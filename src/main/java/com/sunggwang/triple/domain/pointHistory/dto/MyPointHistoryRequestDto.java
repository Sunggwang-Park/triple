package com.sunggwang.triple.domain.pointHistory.dto;


import lombok.Data;
import lombok.Getter;

import java.util.UUID;


@Getter
@Data
public class MyPointHistoryRequestDto {
    UUID userId;
}
