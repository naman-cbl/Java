package DesignPrinciples.Open_Closed;

public class Dog implements IAnimal {
    @Override
    public void feed(){
        System.out.println("Feeding Dog");
    }
}
