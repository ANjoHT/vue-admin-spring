package com.example.vueadmin.responseEntity;

import com.example.vueadmin.responseEntity.ResultEnum;
import io.micrometer.common.lang.Nullable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ServerResponse {
    private Boolean success;
    private Integer code;
    private String message;
    private Object records;

    public static ServerResponse ok(Object params) {
        return new ServerResponse(
                ResultEnum.OK.getSuccess(),
                ResultEnum.OK.getCode(),
                ResultEnum.OK.getMessage(),
                params
        );
    }
    public static ServerResponse unauthorized(Object params) {
        return new ServerResponse(
                ResultEnum.UNAUTHORIZED.getSuccess(),
                ResultEnum.UNAUTHORIZED.getCode(),
                ResultEnum.UNAUTHORIZED.getMessage(),
                params
        );
    }

    public static ServerResponse badRequest(@Nullable String message) {
        return new ServerResponse(
                ResultEnum.BAD_REQUEST.getSuccess(),
                ResultEnum.BAD_REQUEST.getCode(),
                message != null ? message : ResultEnum.BAD_REQUEST.getMessage(),
                null
        );
    }
}
