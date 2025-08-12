package com.kfreemarket.reemarket_server.global.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.kfreemarket.reemarket_server.global.enums.ApiResponseStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @Getter(AccessLevel.NONE)         // Lombok이 게터 안 만들게
    private final boolean success;    // 내부 필드명은 success로

    private final int code;

    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T result;

    @JsonProperty("isSuccess")        // 외부엔 isSuccess로만 노출
    public boolean isSuccess() {
        return success;
    }

    /* ---------- 성공 ---------- */
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(true, ApiResponseStatus.SUCCESS.getCode(), ApiResponseStatus.SUCCESS.getMessage(), null);
    }

    public static <T> ApiResponse<T> success(T result) {
        return new ApiResponse<>(true, ApiResponseStatus.SUCCESS.getCode(), ApiResponseStatus.SUCCESS.getMessage(), result);
    }

    public static <T> ApiResponse<T> success(ApiResponseStatus status, T result) {
        // 필요 시 SUCCESS 계열 커스텀 메시지/코드 사용
        return new ApiResponse<>(true, status.getCode(), status.getMessage(), result);
    }

    /* ---------- 실패 ---------- */
    public static <T> ApiResponse<T> error(ApiResponseStatus status) {
        return new ApiResponse<>(false, status.getCode(), status.getMessage(), null);
    }

    public static <T> ApiResponse<T> error(ApiResponseStatus status, T result) {
        return new ApiResponse<>(false, status.getCode(), status.getMessage(), result);
    }

}
