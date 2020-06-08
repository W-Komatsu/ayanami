package pers.wk.ayanami.business.exception;

import domain.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

/**
 * @author wangxiaosong
 * @date 2020/3/26
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {
    /**
     * 处理登录授权异常
     * @param e 登录授权异常
     * @return 错误响应
     */
    @ExceptionHandler({AuthorizationException .class})
    public ResponseEntity<CommonResponse> handleAuthorizationException(AuthorizationException e) {
        log.error("[handleBizServiceException] : {}", e);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new CommonResponse(null, new HashMap<>(1) {{
            put("message", e.getErrMsg());
        }})) ;
    }

    /**
     * 处理业务异常
     * @param e 业务异常
     * @return 错误响应
     */
    @ExceptionHandler({BizServiceException.class})
    public ResponseEntity handleBizServiceException(BizServiceException e) {
        log.error("[handleBizServiceException] : {}", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(null, new HashMap<>(1) {{
            put("message", e.getErrMsg());
        }}));
    }

    /**
     * 处理请求参数异常
     * @param e 请求参数异常
     * @return 错误响应
     */
    @ExceptionHandler({ServletRequestBindingException.class})
    public ResponseEntity<CommonResponse> handleServletRequestBindingException(ServletRequestBindingException e) {
        return ResponseEntity.badRequest().body(new CommonResponse(null, new HashMap<>(1) {{
            put("message", e.getMessage());
        }}));
    }

    /**
     * 处理参数校验异常
     * @param e 参数校验异常
     * @return 错误响应
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CommonResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errorMessage.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(";");
        }
        return ResponseEntity.badRequest().body(new CommonResponse(null, new HashMap<>(1) {{
            put("message", errorMessage);
        }}));
    }

    /**
     * 处理其他异常
     * @param e 异常
     * @return 错误响应体
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(Exception e) {
        log.error("[handleException] : ", e);
        return new ResponseEntity<>(new CommonResponse(null, new HashMap<>(1) {{
            put("message", e.getMessage());
        }}), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
