import cn.hutool.core.util.RuntimeUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RuntimeUtilTest {

    public static Process exec;

    private static Map<String, Thread> threadMap = new HashMap<>();

    public static void main(String[] args) {

        String threadId = execCmd("ding -config=/Users/coderma/coders/github/pierced/bin/ding.cfg -subdomain=coder-ma-ad 55556");

        new Thread(() -> {
            try {
                System.out.println("sleep 5s");
                Thread.sleep(1000 * 5);
                System.out.println("sleep close");
                threadMap.get(threadId).interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static String execCmd(String cmd) {
        Process exec = RuntimeUtil.exec(cmd);
        Thread thread = new Thread(() -> {
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
        });
        String threadId = UUID.randomUUID().toString().replace("-", "");
        threadMap.put(threadId, thread);
        thread.start();
        return threadId;
    }

    public static void startAppium() {

    }

    public static void main11(String[] args) {

        Process process = RuntimeUtil.exec("node  /Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js  --port 4723");
        InputStream in = process.getInputStream();
        try {
            InputStreamReader inReader = new InputStreamReader(in, "utf-8");
            BufferedReader bufReader = new BufferedReader(inReader);
            String line = null;
            int i = 0;
            while ((line = bufReader.readLine()) != null) {
                System.out.println(line);
                i++;
                if (i == 5) {
                    bufReader.close();
                    inReader.close();
                    in.close();
                    process.destroy();
                }
            }
            bufReader.close();
            inReader.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
        exec.destroy();
    }

    public Process getExec() {
        return exec;
    }

}
