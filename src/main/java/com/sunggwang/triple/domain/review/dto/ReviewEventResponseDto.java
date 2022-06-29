package com.sunggwang.triple.domain.review.dto;

import com.sunggwang.triple.domain.place.dto.PlaceResponseDto;
import com.sunggwang.triple.domain.place.entity.Place;
import com.sunggwang.triple.domain.review.entity.Review;
import com.sunggwang.triple.domain.user.dto.UserResponseDto;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ReviewEventResponseDto {

//    private String action; //  "ADD", /* "MOD", "DELETE" */
    private UUID reviewId; // ": "240a0658-dc5f-4878-9381-ebb7b2667772",
    private String content; //": " !",
    private List<UUID> attachedPhotoIds;//": ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-
    //851d-4a50-bb07-9cc15cbdc332"],
    private UserResponseDto user; //: "3ede0ef2-92b7-4817-a5f3-0c575361f745",
    private PlaceResponseDto place; //: "2e4baf1c-5acb-4efb-a1af-eddada31b00f"

    public static ReviewEventResponseDto toDto(Review review, User user, Place place) {
        return ReviewEventResponseDto.builder()
                .reviewId(review.getId())
                .content(review.getContent())
                .attachedPhotoIds(review.getPhotos())
                .user(UserResponseDto.toDto(user))
                .place(PlaceResponseDto.toDto(place))
                .build();
    }
}
