package com.dev.devinspringboot.pattern.structural.decorator.v2;

/**
 * 香肠实体装饰者
 */
public class SausageDecorator extends AbstractDecorator {

    public SausageDecorator(AbstractBatterCake abstractBatterCake) {
        super(abstractBatterCake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + " 加一个香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
