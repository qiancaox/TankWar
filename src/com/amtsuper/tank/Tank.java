package com.amtsuper.tank;

import java.awt.*;

public class Tank {

    // 当前坦克位置
    public Position pos;
    // 坦克的移动方向，默认为NONE。
    public Direction dir = Direction.NONE;

    public Tank(Position pos) {
        this.pos = pos;
    }

    // 坦克移动
    public void moveTo(Direction newDir) {
        dir = newDir;
        switch (dir) {
            case RIGHT:
                pos.setX(pos.getX() + Definitions.TANK_SPEED);
                break;
            case LEFT:
                pos.setX(pos.getX() - Definitions.TANK_SPEED);
                break;
            case UP:
                pos.setY(pos.getY() - Definitions.TANK_SPEED);
                break;
            case DOWN:
                pos.setY(pos.getY() + Definitions.TANK_SPEED);
                break;
            default: break;
        }
    }

    // 坦克自绘
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(pos.getX(), pos.getY(), Definitions.TANK_SIZE, Definitions.TANK_SIZE);
        g.setColor(c);
    }

    // 开火
    public void fire() {

    }

}
