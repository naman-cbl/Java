package DesignPatterns.HeadFirst.StrategyDesignPattern;

public class QuackNo implements QuackBehavior {
    @Override
    public void quack(){
        System.out.println(".......");
    }
}
