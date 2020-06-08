package pers.wk.ayanami.business.exception;

import lombok.Getter;

/**
 * 登录授权失败，失效错误
 *
 * @author wangxiaosong
 * @date 2020/3/26
 */
@Getter
public class AuthorizationException extends RuntimeException {
    private String errMsg;

    public AuthorizationException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }
}
