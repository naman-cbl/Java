package DesignPatterns.HeadFirst.StrategyDesignPattern;

public class main {
    public static void main(String[] args) {
        RedHeadDuck d1 = new RedHeadDuck();
        d1.display();
        d1.performFly();
        d1.performQuack();
    }
}
