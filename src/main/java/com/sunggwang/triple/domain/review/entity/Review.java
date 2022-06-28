package com.sunggwang.triple.domain.review.entity;

import com.sunggwang.triple.config.BaseTimeEnity;
import com.sunggwang.triple.domain.place.entity.Place;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseTimeEnity {

    @Id
    private UUID id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Place place;

    private List<UUID> photos;


}
