package com.sunggwang.triple.domain.user.dao;

import com.sunggwang.triple.domain.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUserTest() throws Exception {
        //given
        User user = User.createUser(0L);
        userRepository.save(user);

        //when
        User user2 = userRepository.findById(user.getId()).get();

        //then
        Assertions.assertThat(user).isEqualTo(user2);
    }



}