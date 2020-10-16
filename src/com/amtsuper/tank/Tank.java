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
            case RIGHT: {
                int x = pos.getX();
                x = Math.min(x + Definitions.TANK_SPEED, 800 - Definitions.TANK_SIZE);
                pos.setX(x);
            }
                break;
            case LEFT: {
                int x = pos.getX();
                x = Math.max(x - Definitions.TANK_SPEED, 0);
                pos.setX(x);
            }
                break;
            case UP: {
                int y = pos.getY();
                y = Math.max(y - Definitions.TANK_SPEED, 0);
                pos.setY(y);
            }
                break;
            case DOWN: {
                int y = pos.getY();
                y = Math.min(y + Definitions.TANK_SPEED, 600 - Definitions.TANK_SIZE);
                pos.setY(y);
            }
                break;
            default: break;
        }
    }

    // 坦克自绘
    public void paint(Graphics g) {
        g.fillRect(pos.getX(), pos.getY(), Definitions.TANK_SIZE, Definitions.TANK_SIZE);
    }

}
