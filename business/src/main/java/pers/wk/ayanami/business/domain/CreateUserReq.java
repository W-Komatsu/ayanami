package pers.wk.ayanami.business.domain;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wangxiaosong
 * @date 2020/4/17
 */
@Getter
public class CreateUserReq {
    @NotBlank
    private String name;
    @NotNull
    private Integer age;
    private String address;
}
