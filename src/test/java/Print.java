/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author CoderMa
 * @version Print.java, v 0.1 2020-12-04 4:48 下午 CoderMa
 */
public class Print {
    public static void main(String[] args) {
        String[] contents = {"A", "B", "C", "D"};
        AtomicInteger index = new AtomicInteger(0);

        for (String content : contents) {
            new Thread(new Printer(index, contents, content)).start();
        }
    }
}

class Printer implements Runnable {
    private String[] content = null;
    private AtomicInteger index;
    private String printText;

    public Printer(AtomicInteger index, String[] content, String printText) {
        this.content = content;
        this.index = index;
        this.printText = printText;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (content) {
                while (!printText.equals(content[index.intValue()])) {
                    try {
                        content.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(printText);
                index.set(index.intValue() + 1);
                if (index.intValue() >= content.length) {
                    index.set(0);
                }
                content.notifyAll();
            }
        }
    }

}
