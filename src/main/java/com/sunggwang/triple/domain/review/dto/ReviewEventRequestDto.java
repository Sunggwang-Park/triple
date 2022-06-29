package com.sunggwang.triple.domain.review.dto;


import com.sunggwang.triple.domain.place.entity.Place;
import com.sunggwang.triple.domain.review.entity.Review;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Builder
@AllArgsConstructor
public class ReviewEventRequestDto {

    private String type;
    private String action; //  "ADD", /* "MOD", "DELETE" */
    private UUID reviewId; // ": "240a0658-dc5f-4878-9381-ebb7b2667772",
    private String content; //": " !",
    private List<UUID> attachedPhotoIds;//": ["e4d1a64e-a531-46de-88d0-ff0ed70c0bb8", "afb0cef2-
    //851d-4a50-bb07-9cc15cbdc332"],
    private UUID userId; //: "3ede0ef2-92b7-4817-a5f3-0c575361f745",
    private UUID placeId; //: "2e4baf1c-5acb-4efb-a1af-eddada31b00f"

    public Review toEntity(ReviewEventRequestDto dto, User user, Place place) {
        return Review.builder()
                .id(dto.reviewId)
                .content(dto.content)
                .user(user)
                .place(place)
                .photos(dto.attachedPhotoIds)
                .build();
    }

}
