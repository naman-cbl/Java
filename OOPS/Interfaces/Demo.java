package OOPS.Interfaces;

public class Demo implements Idemo1, Idemo2{
    @Override
    public void Print(){
        System.out.println("Print function");
    }

    @Override
    public void Display(){
        System.out.println("Display Function");
    }
    
    // common function
    @Override
    public void fn(){
        Idemo1.super.fn();
        Idemo2.super.fn();

    }
}
