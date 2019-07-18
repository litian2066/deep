package com.dev.devinspringboot.pattern.structural.decorator.v2;

public class Test {

    public static void main(String[] args) {
        AbstractBatterCake abstractBatterCake = new BatterCake();
        // 加一个鸡蛋
        abstractBatterCake = new EggDecorator(abstractBatterCake);

        System.out.println(abstractBatterCake.getDesc() +" 价格: " + abstractBatterCake.cost());
    }
}
