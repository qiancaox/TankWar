package com.amtsuper.tank;

import java.awt.*;

public class Bullet {

    private Position pos;
    private Direction dir;

    public Bullet(Position pos, Direction dir) {
        this.pos = pos;
        this.dir = dir;
    }

    public void move() {
        switch (dir) {
            case RIGHT:
                pos.setX(pos.getX() + Definitions.BULLET_SPPED);
                break;
            case LEFT:
                pos.setX(pos.getX() - Definitions.BULLET_SPPED);
                break;
            case UP:
                pos.setY(pos.getY() - Definitions.BULLET_SPPED);
                break;
            case DOWN:
                pos.setY(pos.getY() + Definitions.BULLET_SPPED);
                break;
            default: break;
        }
    }

    // 子弹自绘
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(pos.getX(), pos.getY(), Definitions.BULLET_SIZE, Definitions.BULLET_SIZE);
        g.setColor(c);
        move();
    }

}
