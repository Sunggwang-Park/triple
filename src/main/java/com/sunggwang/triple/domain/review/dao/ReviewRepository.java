package com.sunggwang.triple.domain.review.dao;

import com.sunggwang.triple.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {

}
