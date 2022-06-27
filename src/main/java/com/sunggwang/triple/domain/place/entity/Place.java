package com.sunggwang.triple.domain.place.entity;

import com.sunggwang.triple.config.BaseTimeEnity;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place extends BaseTimeEnity {

    @Id
    private UUID id;

    private Boolean isFirstReview;

    public void checkFirstReview(User user) {
        if (this.isFirstReview) {
            user.earnFirstReviewPoint();
        }
    }
}
