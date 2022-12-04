/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.maweiming.appium.xxqg.service.xpathlites;

import com.maweiming.appium.xxqg.common.utils.AdbUtils;
import com.maweiming.appium.xxqg.service.xpathlites.core.BaseXpathLites;
import com.maweiming.appium.xxqg.service.xpathlites.core.IXpathLites;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * adb命令
 *
 * @author CoderMa
 * @version AdbXpathLite.java, v 0.1 2020-11-24 3:09 下午 CoderMa
 */
@Slf4j
@Service
public class AdbXpathLite extends BaseXpathLites implements IXpathLites {

    @Override
    public void run() {
        log.info("adb脚本开始执行,{}", model.getRemark());
        for (int i = 0; i < getValueInteger(); i++) {
            AdbUtils.execute(model.getName());
            sleep();
        }
        log.info("adb脚本执行结束,{}", model.getRemark());
    }

}