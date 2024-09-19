package OOPS.Static;

public class Program {
    public static void main(String[] args) {
        // for static nested class
        OuterClass.StaticClass obj1 = new OuterClass.StaticClass();
        obj1.PrintStatic();
        OuterClass.StaticClass.PrintStatic();

        // for non static nested class
        OuterClass.InnerClass obj2 = new OuterClass().new InnerClass();
        obj2.PrintInner();
    }
}
