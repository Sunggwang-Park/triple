package com.sunggwang.triple.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 공통 예외
    BAD_REQUEST_PARAM(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    BAD_REQUEST_VALIDATION(HttpStatus.BAD_REQUEST, "검증에 실패하였습니다."),

    // User 예외
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "해당 유저를 찾을 수 없습니다."),
    EXIST_USER(HttpStatus.BAD_REQUEST, "이미 등록된 유저입니다."),

    //REVIEW 예외
    NOT_FOUND_REVIEW(HttpStatus.NOT_FOUND, "해당 리뷰를 찾을 수 없습니다"),
    DIARY_ACCESS_DENY(HttpStatus.FORBIDDEN, "다른 유저는 접근할 수 없습니다"),

    //Place 예외
    NOT_FOUND_PLACE(HttpStatus.NOT_FOUND, "해당 장소를 찾을 수 없습니다");
//    DIARY_ACCESS_DENY(HttpStatus.FORBIDDEN, "다른 유저는 접근할 수 없습니다");










    private final HttpStatus httpStatus;
    private final String detail;
}

