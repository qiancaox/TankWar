package com.amtsuper.tank;

public class Position {

    private int x, y;

    public Position(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x > Definitions.FRAME_WIDTH - Definitions.TANK_SIZE) {
            this.x = Definitions.FRAME_WIDTH - Definitions.TANK_SIZE;
        } else if (x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y > Definitions.FRAME_HEIGHT - Definitions.TANK_SIZE) {
            this.y = Definitions.FRAME_HEIGHT - Definitions.TANK_SIZE;
        } else if (y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }
}
