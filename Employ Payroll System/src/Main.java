import java.util.ArrayList;

abstract class Employee{
private  String name;
private  int id;

public Employee(String name, int id){
    this.name = name;
    this.id = id;
}

public  String getName(){
return name;
}
public  int getId(){
    return  id;
}

public abstract double CalculateSalary();

@Override
    public  String toString(){
    return  "Employee[name = "+name+", id = "+id+", Salary = "+CalculateSalary()+"]";
}

}


class FullTimeEmployee extends  Employee{
    private double monthlySalary;

    public  FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id); // super is because we want to use constructor of parent class
        this.monthlySalary=monthlySalary;
    }

    @Override
    public  double CalculateSalary(){
        return  monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private  double hourlyRate;
    private  int hoursWorked;
    public  PartTimeEmployee( String name,int id, double hourlyRate, int hoursWorked){
        super(name,id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }
    @Override
    public  double CalculateSalary(){
       return hoursWorked*hourlyRate;
    }
}

class PayrollSystem{
  private ArrayList<Employee> employeeList;
  public  PayrollSystem(){
      employeeList = new ArrayList<>();
  }
  public void addEmployee(Employee employee){
      employeeList.add(employee);
  }

  public void removeEmployee(int id){
      Employee employeeToRemove = null;
      for(Employee employee:employeeList){
          if(employee.getId()==id){
              employeeToRemove = employee;
              break;
          }
      }
      if(employeeToRemove!=null){
          employeeList.remove(employeeToRemove);
      }
  }

  public void displayEmployees(){
      for(Employee employee : employeeList){
          System.out.println(employee);
      }
    }
}

public class Main {
    public static void main(String[] args) {

        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee Emp1 = new FullTimeEmployee("Akash Shah",1,70000.0);
        PartTimeEmployee Emp2 = new PartTimeEmployee("Vikas Shah",2,100,40);

        payrollSystem.addEmployee(Emp1);
        payrollSystem.addEmployee(Emp2);

        System.out.println("Initial Employee Details : ");
        payrollSystem.displayEmployees();


        System.out.println("After Removing one Employee");
        payrollSystem.removeEmployee(2);

        System.out.println("Remaining Employee Details : ");
        payrollSystem.displayEmployees();

    }
}