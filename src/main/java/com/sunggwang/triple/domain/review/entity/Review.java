package com.sunggwang.triple.domain.review.entity;

import com.sunggwang.triple.config.BaseTimeEntity;
import com.sunggwang.triple.config.PointHistoryListener;
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
@EntityListeners(value = PointHistoryListener.class)
public class Review extends BaseTimeEntity {

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

    private String history;

    // "ADD"
    public void update() {
        if (this.content.length() >= 1) {
            user.earnTextPoint();
            this.history += "1자 이상 텍스트 작성 : +1 점\n";
        }
        if (this.photos.size() >= 1) {
            user.earnPhotoPoint();
            this.history += "1장 이상 사진 첨부 : +1 점\n";
        }
    }

    // "MOD"
    public void update(User user, String content, List<UUID> photoIds) {
        this.history = "";
        if (content.length() == 0) {
            if (this.content.length() >= 1) {
                user.lostTextPoint();
                this.history += "텍스트 포인트 회수 : -1 점\n";
            }
        } else if (content.length() >= 1) {
            if (this.content.length() == 0) {
                user.earnTextPoint();
                this.history += "1자 이상 텍스트 작성 : +1 점\n";
            }
        }
        if (photoIds.size() == 0) {
            if (this.photos.size() >= 1) {
                user.lostPhotoPoint();
                this.history += "사진 포인트 회수 : -1 점\n";
            }
        } else if (photoIds.size() >= 1) {
            if (this.photos.size() == 0) {
                user.earnPhotoPoint();
                this.history += "1장 이상 사진 첨부 : +1 점\n";
            }
        }
        this.content = content;
        this.photos = photoIds;
    }

    public void delete(User user, Place place) {
        this.history = "";
        if (this.content.length() >= 1) {
            user.lostTextPoint();
            this.history += "텍스트 포인트 회수 : -1 점\n";
        }
        if (this.photos.size() >= 1) {
            user.lostPhotoPoint();
            this.history += "사진 포인트 회수 : -1 점\n";
        }
        if (this.isFirstReview) {
            user.lostFirstReviewPoint();
            this.history += "첫 리뷰 포인트 회수 : -1 점\n";
        }
        place.getReviews().remove(this);


    }

    public void firstReview() {
        this.isFirstReview = true;
        this.history += "첫 리뷰 포인트 : +1 점\n";
    }

}
