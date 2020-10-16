package com.amtsuper.tank;

public class TankDirSetStrategy implements DirSetStrategy {
    @Override
    public int getValidY(int y) {
        if (y > Definitions.FRAME_HEIGHT - Definitions.TANK_SIZE) {
            return Definitions.FRAME_HEIGHT - Definitions.TANK_SIZE;
        } else if (y < 0) {
            return 0;
        } else {
            return y;
        }
    }

    @Override
    public int getValidX(int x) {
        if (x > Definitions.FRAME_WIDTH - Definitions.TANK_SIZE) {
            return Definitions.FRAME_WIDTH - Definitions.TANK_SIZE;
        } else if (x < 0) {
            return 0;
        } else {
            return x;
        }
    }
}
