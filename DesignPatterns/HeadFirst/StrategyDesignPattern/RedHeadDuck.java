package DesignPatterns.HeadFirst.StrategyDesignPattern;

public class RedHeadDuck extends Duck {
    public RedHeadDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display(){
        System.out.println("I am a Red Head Duck");
    }
}
