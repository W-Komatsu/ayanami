package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @author wangxiaosong
 * @date 2020/3/26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonResponse {
    Object data;
    Map<String, Object> meta;
}
