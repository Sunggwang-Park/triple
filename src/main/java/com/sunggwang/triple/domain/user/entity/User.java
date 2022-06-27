package com.sunggwang.triple.domain.user.entity;

import com.sunggwang.triple.config.BaseTimeEnity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="\"User\"") //MySQL 예약어 : USER
public class User extends BaseTimeEnity {

    @Id @GeneratedValue(generator = "uuid2")
    @Column(name = "userId", columnDefinition = "BINARY(16)")
    private UUID id;

    private Long point;


    public void earnFirstReviewPoint() {
        this.point += 1;
    }

    public void earnTextPoint() {
        this.point += 1;
    }

    public void earnPhotoPoint() {
        this.point += 1;
    }

    public void lostPoint() {
        this.point -= 1;
    }

    public static User createUser(Long point) {
        return User.builder()
                .point(point)
                .build();
    }



}
