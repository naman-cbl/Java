package OOPS.Static;

public class OuterClass {
    private static String msg = "hello";

    // Static class
    public static class StaticClass{
        public static void PrintStatic(){
            System.out.println("Static class:"+msg);
        }
    }

    public class InnerClass{
        public void PrintInner(){
            System.out.println("Inner class");
        }
    }


}
