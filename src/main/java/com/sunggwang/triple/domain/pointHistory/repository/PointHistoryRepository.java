package com.sunggwang.triple.domain.pointHistory.repository;

import com.sunggwang.triple.domain.pointHistory.entity.PointHistory;
import com.sunggwang.triple.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PointHistoryRepository extends JpaRepository<PointHistory, Long> {
    List<PointHistory> findAllByUser(User user);
}
