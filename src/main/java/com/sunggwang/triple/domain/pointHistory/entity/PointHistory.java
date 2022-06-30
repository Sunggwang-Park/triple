package com.sunggwang.triple.domain.pointHistory.entity;

import com.sunggwang.triple.config.BaseTimeEnity;
import com.sunggwang.triple.domain.place.entity.Place;
import com.sunggwang.triple.domain.review.entity.Review;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;
import javax.security.auth.callback.LanguageCallback;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PointHistory extends BaseTimeEnity {

    @Id @GeneratedValue
    Long id;

    String history;

    UUID reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    Place place;

}
