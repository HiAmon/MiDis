package com.amon.wfx.selfmedia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.amon.wfx.selfmedia.*.dao")
public class WfxSelfmediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WfxSelfmediaApplication.class, args);
    }

}
