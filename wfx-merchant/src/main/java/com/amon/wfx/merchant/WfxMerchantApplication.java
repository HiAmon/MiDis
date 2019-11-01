package com.amon.wfx.merchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.amon.wfx.merchant.*.dao")
public class WfxMerchantApplication {

    public static void main(String[] args) {
        SpringApplication.run(WfxMerchantApplication.class, args);
    }

}
