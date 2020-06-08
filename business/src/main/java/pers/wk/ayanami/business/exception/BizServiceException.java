package pers.wk.ayanami.business.exception;

import lombok.Getter;

/**
 * 自定义异常类
 *
 * @author wangxiaosong
 * @date 2020/3/26
 */
@Getter
public class BizServiceException extends RuntimeException {
    private String errMsg;

    public BizServiceException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }
}
