package DesignPrinciples.Open_Closed;

public class Program {
    public static void main(String[] args) {
        AnimalFeeder feeder = new AnimalFeeder();
        feeder.feedAnimal(new Dog());
        feeder.feedAnimal(new Cat());

        // I can add as many class as I want without modifying the existing code
        // My code is open for extension and closed for modifications.
    }
}
