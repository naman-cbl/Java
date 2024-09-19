package DesignPrinciples.Single_Responsibility;

public class Program {
    public static void main(String[] args) {
        Employee emp = new Employee();

        Cal_salary salary = new Cal_salary();
        salary.calculate_salary(emp);

        Hire_Employee he = new Hire_Employee();
        he.hire_employee(emp);

        Eluv_Employee ee = new Eluv_Employee();
        ee.evaluate_emp(emp);

        // Every class is given separate responsibility, so each class only have one actor 
    }
}
