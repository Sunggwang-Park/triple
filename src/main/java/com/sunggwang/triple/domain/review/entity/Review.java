package com.sunggwang.triple.domain.review.entity;

import com.sunggwang.triple.config.BaseTimeEnity;
import com.sunggwang.triple.domain.place.entity.Place;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseTimeEnity {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Place place;

    @ElementCollection(targetClass = UUID.class)
    private List<UUID> photos;

    private Boolean isFirstReview;


    public void update(User user, String content, List<UUID> photoIds) {
        if (content.length() == 0) {
            if (this.content.length() >= 1) {
                user.lostTextPoint();
            }
        } else if (content.length() >= 1) {

            if (this.content.length() == 0) {
                user.earnTextPoint();
            }
        }
        if (photoIds.size() == 0) {
            if (this.photos.size() >= 1) {
                user.lostPhotoPoint();
            }
        } else if (photoIds.size() >= 1) {
            if (this.photos.size() == 0) {
                user.earnPhotoPoint();
            }
        }
        this.content = content;
        this.photos = photoIds;
    }

    public void delete(User user, Place place) {
        if (this.content.length() >= 1) {
            user.lostTextPoint();
        }
        if (this.photos.size() >= 1) {
            user.lostPhotoPoint();
        }
        if (this.isFirstReview) {
            user.lostFirstReviewPoint();
        }
        place.getReviews().remove(this);


    }

    public void firstReview() {
        this.isFirstReview = true;
    }

}
