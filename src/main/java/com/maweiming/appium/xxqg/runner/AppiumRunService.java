/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author CoderMa
 * @version AppiumRunService.java, v 0.1 2020-11-24 2:57 下午 CoderMa
 */
@Order(value = 1)
@Slf4j
@Service
public class AppiumRunService implements ApplicationRunner {

    public static Process exec;

    public static void startAppium() {
        try {
            InputStream in = exec.getInputStream();
            InputStreamReader inReader = new InputStreamReader(in, "utf-8");
            BufferedReader bufReader = new BufferedReader(inReader);
            String line = null;
            while ((line = bufReader.readLine()) != null) {
                System.out.println(line);
            }
            bufReader.close();
            inReader.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        exec = RuntimeUtil.exec("ping 127.0.0.1");
//        new Thread(AppiumRunService::startAppium).start();
    }

    public void destroy() {
        exec.destroy();
    }

    public Process getExec() {
        return exec;
    }
}