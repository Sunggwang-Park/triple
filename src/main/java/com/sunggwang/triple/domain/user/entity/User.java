package com.sunggwang.triple.domain.user.entity;

import com.sunggwang.triple.config.BaseTimeEntity;
import com.sunggwang.triple.domain.review.entity.Review;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="\"User\"") //MySQL 예약어 : USER
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "userId", columnDefinition = "BINARY(16)")
    private UUID id;

    private Long point;


    public void earnFirstReviewPoint(Review review) {
        System.out.println("User.earnFirstReviewPoint");
        this.point += 1;
        review.firstReview();
    }

    public void earnTextPoint() {
        System.out.println("User.earnTextPoint");
        this.point += 1;
    }

    public void earnPhotoPoint() {
        System.out.println("User.earnPhotoPoint");
        this.point += 1;
    }

    public void lostFirstReviewPoint() {
        System.out.println("User.lostFirstReviewPoint");
        this.point -= 1;
    }
    public void lostTextPoint() {
        System.out.println("User.lostTextPoint");
        this.point -= 1;
    }
    public void lostPhotoPoint() {
        System.out.println("User.lostPhotoPoint");
        this.point -= 1;
    }

    public static User createUser(UUID id) {
        return User.builder()
                .id(id)
                .point(0L)
                .build();
    }



}
