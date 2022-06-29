package com.sunggwang.triple.domain.place.dto;

import com.sunggwang.triple.domain.place.entity.Place;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class PlaceResponseDto {

    private UUID placeId;


    public static PlaceResponseDto toDto(Place place) {
        return PlaceResponseDto.builder()
                .placeId(place.getId())
                .build();
    }


}
