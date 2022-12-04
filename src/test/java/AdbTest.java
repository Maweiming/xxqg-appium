/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.RuntimeUtil;
import org.junit.Test;

/**
 * @author CoderMa
 * @version AdbTest.java, v 0.1 2020-11-20 5:57 下午 CoderMa
 */
public class AdbTest {

    public static void execute(String cmd) {
        RuntimeUtil.execForStr(String.format("adb %s", cmd));
    }

    @Test
    public void test() throws Exception {

        for (int i = 0; i < 100; i++) {
            execute("shell input swipe 430 430 430 430 600");
            execute("shell input tap 500 350");
            execute("shell input tap 800 1300");
            Thread.sleep(RandomUtil.randomInt(500, 600));
        }

    }

}