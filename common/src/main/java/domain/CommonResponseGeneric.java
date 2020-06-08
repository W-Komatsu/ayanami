package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * 公共返回体泛型版
 *
 * @author wangxiaosong
 * @date 2020/3/26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CommonResponseGeneric<T> {
    T data;
    Map<String, Object> meta;
}
