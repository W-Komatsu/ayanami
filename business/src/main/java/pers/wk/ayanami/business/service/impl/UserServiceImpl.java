package pers.wk.ayanami.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.wk.ayanami.business.domain.CreateUserReq;
import pers.wk.ayanami.business.mapper.UserMapperEx;
import pers.wk.ayanami.business.service.UserService;
import pers.wk.ayanami.orm.mapper.UserMapper;
import pers.wk.ayanami.orm.model.User;
import utils.DateUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author wangxiaosong
 * @date 2020/4/16
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapperEx userMapperEx;
    @Override
    public List<Map<String, Object>> getUserInfo(String name, int currPage, int pageSize) {
        return userMapperEx.getUserInfo(name, (currPage-1)*pageSize, pageSize);
    }

    @Override
    public Long addUser(CreateUserReq req) {
        String now = DateUtil.formatDate(LocalDateTime.now(), DateUtil.FMT_sdf17);
        return userMapper.addUser(new User(null, req.getName(), req.getAge(), req.getAddress(), now, now));
    }
}
