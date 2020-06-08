package pers.wk.ayanami.business.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author wangxiaosong
 * @date 2020/4/20
 */
public interface UserMapperEx {
    List<Map<String, Object>> getUserInfo(String name, int currIndex, int pageSize);
}
