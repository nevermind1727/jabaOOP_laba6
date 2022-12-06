package employees;
import java.io.Serializable;

public class Employee implements Serializable {
  protected int id;
  private static int nextId = 0;
  protected String name;
  protected String surname;
  protected double salary;
  protected Manager manager;

  public Employee(){}

  public Employee(String name, String surname, double salary, Manager manager) {
      this.id = setId();
    this.name = name;
    this.surname = surname;
    this.salary = salary;
    this.manager = manager;
  }

  public int getId() {
      return this.id;
  }

  public int setId() {
      return nextId++;
  }

  public final String getName() {
      return name;
  }

  public final void setName(String name) {
      this.name = name;
  }

  public final String getSurname() {
      return surname;
  }

  public final void setSurname(String surname) {
      this.surname = surname;
  }

  public Manager getManager() {
      return manager;
  }

  public void setManager(Manager manager) {
      this.manager = manager;
  }

  public double getSalary() {
      return salary;
  }

  public void setSalary(double salary) {
      this.salary = salary;
  }

  public void raiseSalary(double percent) {
      double raisedValue = (double) ((this.salary / 100) * percent);
      System.out.println(this.surname + "'s salary raised by " + raisedValue + " current salary is: " + (this.salary + raisedValue));
  }

  public String toString() {
      return " " + this.id + " " + this.name + " " + this.surname + " " + " " + this.salary + " " + " " + this.manager.getId();
  }
}