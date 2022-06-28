package com.sunggwang.triple.domain.place.dao;

import com.sunggwang.triple.domain.place.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaceRepository extends JpaRepository<Place, UUID> {
}
