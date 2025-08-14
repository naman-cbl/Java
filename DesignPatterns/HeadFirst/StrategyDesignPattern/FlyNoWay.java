package DesignPatterns.HeadFirst.StrategyDesignPattern;

public class FlyNoWay implements FlyBehavior {
    
    @Override
    public void fly(){
        System.out.println("No Fly");
    }
}
