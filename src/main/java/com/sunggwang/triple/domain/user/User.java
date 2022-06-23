package com.sunggwang.triple.domain.user;

import com.sunggwang.triple.config.BaseTimeEnity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="\"User\"") //MySQL 예약어 : USER
public class User extends BaseTimeEnity {

    @Id
    @Column(name = "userId")
    private Long id;

    private Long point;
    

}
