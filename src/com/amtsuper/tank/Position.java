package com.amtsuper.tank;

public class Position {

    private int x, y;
    /*
    * 可以采用固定参数的方式解决，但是策略模式的扩展性好。因为，如果将来还有其他策略，
    * 只需要传入其他的Strategy就可以了，而无需修改Position的源码。而前者的方式就需
    * 要修改Position,违背了开闭原则.
    */
    private DirSetStrategy strategy;

    public Position(int x, int y, DirSetStrategy s) {
        this.strategy = s;
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = strategy.getValidX(x);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = strategy.getValidY(y);
    }

}
