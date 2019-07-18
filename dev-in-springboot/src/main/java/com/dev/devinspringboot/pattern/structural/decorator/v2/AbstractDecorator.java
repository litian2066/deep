package com.dev.devinspringboot.pattern.structural.decorator.v2;

/**
 * 装饰者
 */
public class AbstractDecorator extends AbstractBatterCake {

    private AbstractBatterCake abstractBatterCake;

    public AbstractDecorator(AbstractBatterCake abstractBatterCake) {
        this.abstractBatterCake = abstractBatterCake;
    }

    @Override
    protected String getDesc() {
        return this.abstractBatterCake.getDesc();
    }

    @Override
    protected int cost() {
        return this.abstractBatterCake.cost();
    }
}
