package DesignPrinciples.DIP;

public class MovieMaker {
    public void hiring(IMovieMaker movieMaker){
        movieMaker.hirePeople();
    }
}
