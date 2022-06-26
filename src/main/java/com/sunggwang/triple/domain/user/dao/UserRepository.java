package com.sunggwang.triple.domain.user.dao;

import com.sunggwang.triple.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
