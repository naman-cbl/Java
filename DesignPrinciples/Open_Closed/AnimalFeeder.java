package DesignPrinciples.Open_Closed;

public class AnimalFeeder {
    
    public void feedAnimal(IAnimal animal){
        animal.feed();
    }
}
