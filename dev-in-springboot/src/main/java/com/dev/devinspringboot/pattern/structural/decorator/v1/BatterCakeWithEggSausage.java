package com.dev.devinspringboot.pattern.structural.decorator.v1;

public class BatterCakeWithEggSausage extends BatterCakeWithEgg {

    @Override
    public String getDesc() {
        return super.getDesc() + "加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
