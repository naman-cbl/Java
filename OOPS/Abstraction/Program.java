package OOPS.Abstraction;

public class Program {
    public static void main(String[] args) {
        Node n1 = new Node();
        n1.deprDetails();
        n1.subDeptDetails();
        System.out.println();
        React r1 = new React();
        r1.deprDetails();
        r1.subDeptDetails();

        
        // Dept d = new Dept(); Note:- cannot initiate abstract class diractly
    }
}
