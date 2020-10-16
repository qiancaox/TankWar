package com.amtsuper.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    // 键盘监听对象，由于只用TankFrame使用，这里定义为内部类比较合适
    private class TFKeyboardAdapter extends KeyAdapter {

        TFKeyboardAdapter() {
        }

        // 按键点下
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    myTank.moveTo(Direction.UP); break;
                case KeyEvent.VK_DOWN:
                    myTank.moveTo(Direction.DOWN); break;
                case KeyEvent.VK_LEFT:
                    myTank.moveTo(Direction.LEFT); break;
                case KeyEvent.VK_RIGHT:
                    myTank.moveTo(Direction.RIGHT); break;
                case KeyEvent.VK_SPACE:
                    myTank.fire(); break;
                default:
                    myTank.moveTo(Direction.NONE); break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            myTank.moveTo(Direction.NONE);
        }
    }

    private final TFKeyboardAdapter M_KEY_ADAPTOR = new TFKeyboardAdapter();
    private Tank myTank = new Tank(
            new Position(Definitions.FRAME_WIDTH / 2 - Definitions.TANK_SIZE,
                    Definitions.FRAME_HEIGHT - Definitions.TANK_SIZE,
                    new TankDirSetStrategy())
    );
    private Bullet myBullet = new Bullet(
            new Position(50, 0, new BulletDirSetStrategy()),
            Direction.DOWN
    );

    public TankFrame() {
        setSize(Definitions.FRAME_WIDTH, Definitions.FRAME_HEIGHT); // 窗口大小
        setResizable(false); // 不能改变大小
        setTitle("坦克大战"); // 设置窗口标题
        // 窗口监听器
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 点击关闭按钮，退出系统
                System.exit(0);
            }
        });
        addKeyListener(M_KEY_ADAPTOR); // 监听键盘
    }

    // 窗口需要重新绘制时调用
    // 每次绘制会将之前的清空，然后重新绘制
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        myTank.paint(g);
        myBullet.paint(g);
    }

    // 使用双缓冲机制，避免屏幕闪烁
    private Image offscreenImage = null;
    @Override
    public void update(Graphics g) {
        super.update(g);
        if (offscreenImage == null) {
            offscreenImage = this.createImage(Definitions.FRAME_WIDTH, Definitions.FRAME_HEIGHT);
        }
        Graphics gOffscreen = offscreenImage.getGraphics();
        Color c = gOffscreen.getColor();
        gOffscreen.setColor(Color.BLACK);
        gOffscreen.fillRect(0, 0, Definitions.FRAME_WIDTH, Definitions.FRAME_HEIGHT);
        gOffscreen.setColor(c);
        paint(gOffscreen);
        g.drawImage(offscreenImage, 0, 0, null);
    }
}
