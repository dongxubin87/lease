package com.dong.lease.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.dong.lease.web.*.mapper")
public class MybatisPlusConfiguration {

}
