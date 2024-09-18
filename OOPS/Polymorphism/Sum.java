package OOPS.Polymorphism;

public class Sum {
    public int add(int a, int b){
        return a+b;
    }

    public int add(int a, int b, int c){
        return a+b+c;
    }

    public int add(float a, float b){
        return (int) (a+b);
    }

    public float add(float a, int b){
        return (float) a+b;
    }
}
