package OOPS.Inheritence;

public class Program {
    public static void main(String[] args) {
        GrandFather obj1 = new GrandFather();
        obj1.func1();
        System.out.println();

        GrandFather obj2 = new Father();
        obj2.func1();
        System.out.println();

        GrandFather obj3 = new Child();
        obj3.func1();
        System.out.println();

        Father obj4 = new Child();
        obj4.func1();
        obj4.func2();
        System.out.println();

        Child obj5 = new Child();
        obj5.func1();
        obj5.func2();
        obj5.func3();

        // We cannot initiate the objects like the examples given below
        //Father f = new GrandFather();
        //Child c = new Father();
        //Child c1 = new GrandFather();

    }
}
