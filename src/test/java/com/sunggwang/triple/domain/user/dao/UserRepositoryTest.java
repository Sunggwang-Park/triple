package com.sunggwang.triple.domain.user.dao;

import com.sunggwang.triple.domain.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUserTest() throws Exception {
        //given
        UUID uid = UUID.fromString("3ede0ef2-92b7-4817-a5f3-0c575361f745");
        User user = User.createUser(uid, 0L);
        userRepository.save(user);

        //when
        User referenceById = userRepository.getReferenceById(uid);


        //then
        Assertions.assertThat(user).isEqualTo(referenceById);
    }



}