package com.sunggwang.triple.config;

import com.sunggwang.triple.domain.pointHistory.entity.PointHistory;
import com.sunggwang.triple.domain.pointHistory.repository.PointHistoryRepository;
import com.sunggwang.triple.domain.review.entity.Review;

import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class PointHistoryListener {
    @PreUpdate
    @PreRemove
    public void prePersistAndPreUpdate(Object o) {
        PointHistoryRepository pointHistoryRepository = BeanUtil.getBean(PointHistoryRepository.class);

        Review review = (Review) o;

        PointHistory pointHistory = PointHistory.builder()
                .history(review.getHistory())
                .reviewId(review.getId())
                .user(review.getUser())
                .place(review.getPlace())
                .build();

        pointHistoryRepository.save(pointHistory);
    }
}