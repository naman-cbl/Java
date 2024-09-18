package OOPS.Interfaces;

public class Program {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.Display();
        d.Print();

        d.function1();
        d.function2();

        d.fn();

        // static method(deosn't belong to the object)
        Idemo1.f1();

        Idemo1 d1 = new Demo();
        //d1.Display();
        d1.Print();

        
    }
}
