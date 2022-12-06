/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Controller {
    static Employee employee = null;
    static Manager manager = null;
    static ArrayList<Employee> empList = new ArrayList<Employee>();
    static ArrayList<Manager> manList = new ArrayList<Manager>();
    public static String employeeInit (File file) {

            BufferedReader buffer = null;
//            Employee emplo1 = new Employee("Elon", "Musk", 3500, this.manList.get(0));
//            empList.add(emplo1);
                try {
                    buffer = new BufferedReader(new FileReader(file));
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                }
            try {
            String s2;
            ArrayList<String> inputEmp = new ArrayList<String>();
            while ((s2 = buffer.readLine()) != null) {
              inputEmp.add(s2);
            }
            for (int i = 0; i < inputEmp.size(); i++) {
              String name = (String) inputEmp.get(i);
              i++;
              String surname = (String) inputEmp.get(i);
              i++;
              double salary = (double) Double.parseDouble(inputEmp.get(i));
              i++;
              String mas = (String) inputEmp.get(i);
              Manager m = null;
              if (mas != null) {
                m = (Manager) manList.get(Integer.parseInt(mas));
              }
              i++;
              employee = new Employee(name, surname, salary, m);
              empList.add(employee);
      }
            } catch (Exception e) {
            System.out.println(e);
        }
            String out = "";
            for (Employee empl:empList) {
                System.out.println(empl.toString());
                out += empl.toString();   
            }
            return out;
    }
    
    public static void employeeSerialize() {
        try {
            FileOutputStream fos2 = new FileOutputStream("D:\\Downloads\\javaOOP_laba5-main (1)\\javaOOP_laba5-main\\app\\src\\main\\java\\employees\\Employee.txt");
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            for (Employee empl:empList) {
                oos2.writeObject(empl);
                System.out.println(empl.toString());
                oos2.flush();
            }
      oos2.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void employeeDeserialize() {
        try {
          FileInputStream fis2 = new FileInputStream("D:\\Downloads\\javaOOP_laba5-main (1)\\javaOOP_laba5-main\\app\\src\\main\\java\\employees\\Employee.txt");
          ObjectInputStream ois2 = new ObjectInputStream(fis2);
          for (int i = 0; i < empList.size(); i++) {
              Employee emp1 = (Employee) ois2.readObject();
//              System.out.println(emp1.toString());
          }
      } catch (Exception e) {
          System.out.println(e);
      }
    }
    
    
    public static String managerInit(File file) {
        BufferedReader buffer = null;
        Manager manager1 = new Manager("Thomas", "Shelby", 2700, null, 250);
        manList.add(manager1);
        String s1;
        ArrayList<String> inputMan = new ArrayList<String>();
        try {
            buffer = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        try {
            while ((s1 = buffer.readLine()) != null) {
                  inputMan.add(s1);
              }
              for (int i = 0; i < inputMan.size(); i++) {
                String name = (String) inputMan.get(i);
                i++;
                String surname = (String) inputMan.get(i);
                i++;
                double salary = (double) Double.parseDouble(inputMan.get(i));
                i++;
                String mas = (String) inputMan.get(i);
                Manager m = null;
                if (mas != null) {
//                    System.out.println(manList.get(Integer.parseInt(mas)).toString());
                    m = (Manager) manList.get(Integer.parseInt(mas));
                }
              i++;
                double bonus = (double) Double.parseDouble(inputMan.get(i));
                    manager = new Manager(name, surname, salary, m, bonus);
                    manList.add(manager);
            }
              
        } catch (Exception e) {
            System.out.println(e);
        }
        String out = "";
              for (Manager m:manList) {
                System.out.println(m.toString());
                out += m.toString();
            }
        return out;        
    }
    
    public static void managerSerialize() {
        try {
            FileOutputStream fos = new FileOutputStream("D:\\Downloads\\javaOOP_laba5-main (1)\\javaOOP_laba5-main\\app\\src\\main\\java\\employees\\Manager.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Manager manag:manList) {
                oos.writeObject(manag);
    //            System.out.println(manag.toString());
                oos.flush();
            }
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void managerDeserialize() {
        try {
            FileInputStream fis = new FileInputStream("D:\\Downloads\\javaOOP_laba5-main (1)\\javaOOP_laba5-main\\app\\src\\main\\java\\employees\\Manager.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            for (int i = 0; i < manList.size(); i++) {
                Manager m1 = (Manager) ois.readObject();
                System.out.println(m1.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
