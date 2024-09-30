package DesignPrinciples.DIP;

public class Program{
    public static void main(String[] args) {
        MovieMaker movieMaker = new MovieMaker();

        movieMaker.hiring(new Actor());
        movieMaker.hiring(new Producer());
    }

    // Classes are not depending on each other, also taken care of open/closed principle
}