package DesignPatterns.HeadFirst.StrategyDesignPattern;

public class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void display(){
        System.out.println("Duck Display");
    }

    public void swim(){
        System.out.println("Duck Swim");
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }
}
