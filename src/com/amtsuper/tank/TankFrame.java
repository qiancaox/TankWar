package com.amtsuper.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    public TankFrame() {
        setSize(800, 900); // 窗口大小
        setResizable(false); // 不能改变大小
        setTitle("坦克大战"); // 设置窗口标题
        addWindowListener(new WindowAdapter() { // 窗口监听器
            @Override
            public void windowClosing(WindowEvent e) { // 点击关闭按钮，退出系统
                System.exit(0);
            }
        });
    }

    // 窗口需要重新绘制时调用
    // 每次绘制会将之前的清空，然后重新绘制
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(200, 200, 50, 60); // 填充一个矩形
    }
}
