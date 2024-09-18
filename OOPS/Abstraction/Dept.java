package OOPS.Abstraction;

public abstract class Dept {
    private int leaves = 4;
    public Dept(){
        System.out.println("Department Constructor");
        System.out.println("Leaves:"+this.leaves);
    }

    public void deprDetails(){
        System.out.println("Department Details");
    }

    public abstract void subDeptDetails();
}
