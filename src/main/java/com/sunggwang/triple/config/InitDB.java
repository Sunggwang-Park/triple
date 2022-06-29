package com.sunggwang.triple.config;

import com.sunggwang.triple.domain.place.entity.Place;
import com.sunggwang.triple.domain.user.dao.UserRepository;
import com.sunggwang.triple.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InitDB {

    @Component
    @RequiredArgsConstructor
    public static class InitDb {

        private final InitService initService;


        @PostConstruct
        public void init() {
            UUID userId = UUID.fromString("3ede0ef2-92b7-4817-a5f3-0c575361f745");
            UUID placeId = UUID.fromString("2e4baf1c-5acb-4efb-a1af-eddada31b00f");

            User user = User.createUser(userId);
//            userRepository.save(user);

            Place place = Place.createPlace(placeId);
//            placeRepository.save(place);


            initService.dbInit(user,place);

        }

        @Component
        @Transactional
        @RequiredArgsConstructor
        static class InitService {
            private final EntityManager em;

            public void dbInit(User user, Place place) {
                em.persist(user);
                em.persist(place);
            }


        }

    }

}
