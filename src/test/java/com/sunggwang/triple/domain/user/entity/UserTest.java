package com.sunggwang.triple.domain.user.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void UUID_테스트() throws Exception {
        //given
        String uid = "240a0658-dc5f-4878-9381-ebb7b2667772";
        UUID userId = UUID.fromString(uid);
        //when
        User user = User.builder()
                .id(userId)
                .build();

        //then
        Assertions.assertThat(user.getId()).isEqualTo(UUID.fromString(uid));
    }

}