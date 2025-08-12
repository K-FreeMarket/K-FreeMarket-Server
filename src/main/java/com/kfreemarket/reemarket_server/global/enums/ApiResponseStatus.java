package com.kfreemarket.reemarket_server.global.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiResponseStatus {

    /* 2xx: 성공 계열 (앱 코드 예시) */
    SUCCESS(true, 2000, "Success"),

    /* 4xx: 클라이언트 오류 */
    BAD_REQUEST(false, 4000, "잘못된 요청입니다."),
    BAD_ID(false, 4001, "존재하지 않는 ID입니다."),
    ARGUMENT_NOT_VALID(false, 4002, "유효성 검증에 실패하였습니다."),
    ACCOUNT_NAME_DUPLICATED(false, 4003, "AccountName이 중복되었습니다."),
    JWT_NOT_VALID(false, 4004, "토큰 검증에 실패하였습니다."),
    ACCESS_KEY_DUPLICATED(false, 4005, "Access Key가 중복되었습니다."),

    /* 5xx: 서버 오류 */
    NOT_IMPLEMENTED(false, 5000, "해당 기능을 지원하지 않습니다."),
    EMPTY_RESOURCE(false, 5001, "값이 비어있습니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;
}
