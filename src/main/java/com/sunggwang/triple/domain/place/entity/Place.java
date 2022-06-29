package com.sunggwang.triple.domain.place.entity;

import com.sunggwang.triple.config.BaseTimeEnity;
import com.sunggwang.triple.domain.review.entity.Review;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place extends BaseTimeEnity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Review> reviews;

    private Boolean noReview;

    public void checkFirstReview(User user,Review review) {
        if (reviews.size() == 0) {
            user.earnFirstReviewPoint(review);
        }
        reviews.add(review);
    }
    

    public static Place createPlace(UUID id) {
        return Place.builder()
                .id(id)
                .reviews(new ArrayList<>())
                .build();
    }


}
