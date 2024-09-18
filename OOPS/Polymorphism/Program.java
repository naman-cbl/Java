package OOPS.Polymorphism;

public class Program {
    public static void main(String[] args) {
        // Static/ Runtime Polymorphism
        Sum s = new Sum();

        System.out.println(s.add(4,5));
        System.out.println(s.add(7.0f, 9.0f));
        System.out.println(s.add(1, 2, 3));


        // Dynamic/ Compile time Polymorphism

        Dog d = new Dog();
        d.eat();


    }
}
