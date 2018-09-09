package com.xyl.personalincometax.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 结果类
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Result {
    /**
     * 状态码
     */
    private int code;
    /**
     * 状态信息
     */
    private String message;
    /**
     * 结果集
     */
    private Object data;
}
