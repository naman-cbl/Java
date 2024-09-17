package OOPS.Interfaces;

public interface Idemo2 {

    public void Display();

    default void function2(){
        System.out.println("Function from Demo2");
    }

    default void fn(){
        System.out.println("Common function from Demo2");
    }
}
