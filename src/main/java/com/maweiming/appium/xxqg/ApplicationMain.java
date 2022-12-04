/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author CoderMa
 * @version ApplicationMain.java, v 0.1 2020-11-24 2:55 下午 CoderMa
 */
@SpringBootApplication
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ApplicationMain.class);
        builder.headless(false).run(args);
    }

}