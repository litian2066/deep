package com.dev.devinspringboot.pattern.structural.decorator.v1;

/**
 * 煎饼类
 */
public class BatterCake {

    protected String getDesc() {
        return "煎饼";
    }

    /**
     * 8元
     * @return
     */
    protected int cost() {
        return 8;
    }
}
