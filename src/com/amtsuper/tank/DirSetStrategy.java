package com.amtsuper.tank;

// 方向改变的计算策略
public interface DirSetStrategy {
    int getValidY(int y);
    int getValidX(int x);
}
