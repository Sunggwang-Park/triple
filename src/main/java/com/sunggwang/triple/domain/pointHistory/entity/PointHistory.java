package com.sunggwang.triple.domain.pointHistory.entity;

import com.sunggwang.triple.config.BaseTimeEntity;
import com.sunggwang.triple.domain.place.entity.Place;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PointHistory extends BaseTimeEntity {

    @Id @GeneratedValue
    Long id;

    String history;

    UUID reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    Place place;

}
