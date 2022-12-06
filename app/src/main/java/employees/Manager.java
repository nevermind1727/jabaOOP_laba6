package employees;
import java.io.Serializable;

public class Manager extends Employee implements Serializable {
  private double bonus;

  public Manager(String name, String surname, double salary, Manager manager, double bonus) {
      super(name, surname, salary, manager);
      this.bonus = bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  @Override
  public double getSalary() {
      return this.salary + this.bonus;
  }

  @Override
  public String toString() {
      if (this.manager == null) {
          return " " + this.id + " " + this.name + " " + this.surname + " " + " " + this.salary + " " + " " + null + " " + this.bonus;
      } else {
          return " " + this.id + " " + this.name + " " + this.surname + " " + " " + this.salary + " " + " " + this.manager.getId() + " " + this.bonus;
      }
  }
}