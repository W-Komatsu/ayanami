package pers.wk.ayanami.business.service;

import pers.wk.ayanami.business.domain.CreateUserReq;

import java.util.List;
import java.util.Map;

/**
 * @author wangxiaosong
 * @date 2020/4/16
 */
public interface UserService {
    List<Map<String, Object>> getUserInfo(String name, int currPage, int pageSize);

    Long addUser(CreateUserReq req);
}
