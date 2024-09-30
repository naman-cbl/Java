package DesignPrinciples.DIP;

public class Director implements IMovieMaker{
    @Override
    public void hirePeople(){
        System.out.println("Hire Director");
    }
}
