package com.sunggwang.triple.domain.user.entity;

import com.sunggwang.triple.config.BaseTimeEnity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="\"User\"") //MySQL 예약어 : USER
public class User extends BaseTimeEnity {

    @Id
    @Column(name = "userId")
    private UUID id;

    private Long point;
    

}
