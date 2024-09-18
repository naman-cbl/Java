package OOPS.Interfaces;
public interface Idemo1 {
    public void Print();
    
    static void f1(){
        System.out.println("test fn");
    }

    default void function1(){
        System.out.println("Function from Demo1");
    }

    default void fn(){
        System.out.println("Common function from Demo1");
    }
}
