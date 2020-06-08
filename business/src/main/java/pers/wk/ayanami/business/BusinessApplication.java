package pers.wk.ayanami.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangxiaosong
 * @date 2020/3/25
 */
@SpringBootApplication
@MapperScan({"pers.wk.ayanami.orm.mapper","pers.wk.ayanami.business.mapper"})
public class BusinessApplication {
    public static void main(String[] args){
        SpringApplication.run(BusinessApplication.class, args);
    }
}
