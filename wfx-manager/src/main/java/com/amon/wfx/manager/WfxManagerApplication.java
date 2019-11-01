package com.amon.wfx.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.amon.wfx.manager.*.dao")
public class WfxManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WfxManagerApplication.class, args);
    }

}
