package employees;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Manager manager = null;
        Employee employee = null;
        BufferedReader[] buffer = new BufferedReader[2];
        buffer[0] = new BufferedReader(new FileReader("D:\\javaOOP_laba5\\app\\src\\main\\java\\employees\\InputManager.txt"));
        buffer[1] = new BufferedReader(new FileReader("D:\\javaOOP_laba5\\app\\src\\main\\java\\employees\\InputEmployeers.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("D:\\javaOOP_laba5\\app\\src\\main\\java\\employees\\InputManager.txt"));
      ArrayList<Employee> empList = new ArrayList<Employee>();
      ArrayList<Manager> manList = new ArrayList<Manager>();
        Manager manager1 = new Manager("Thomas", "Shelby", 2700, null, 250);
        manList.add(manager1);
          String s1;
          String s2;
          ArrayList<String> inputMan = new ArrayList<String>();
          ArrayList<String> inputEmp = new ArrayList<String>();
              while ((s1 = buffer[0].readLine()) != null) {
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

        FileOutputStream fos = new FileOutputStream("D:\\javaOOP_laba5\\app\\src\\main\\java\\employees\\Manager.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Manager manag:manList) {
            oos.writeObject(manag);
//            System.out.println(manag.toString());
            oos.flush();
        }
        oos.close();

        try {
            FileInputStream fis = new FileInputStream("D:\\javaOOP_laba5\\app\\src\\main\\java\\employees\\Manager.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            for (int i = 0; i < manList.size(); i++) {
                Manager m1 = (Manager) ois.readObject();
                System.out.println(m1.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

      while ((s2 = buffer[1].readLine()) != null) {
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
              //                    System.out.println(manList.get(Integer.parseInt(mas)).toString());
            m = (Manager) manList.get(Integer.parseInt(mas));
          }
        i++;
          employee = new Employee(name, surname, salary, m);
          empList.add(employee);
      }

      FileOutputStream fos2 = new FileOutputStream("D:\\javaOOP_laba5\\app\\src\\main\\java\\employees\\Manager.txt");
      ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
      for (Employee empl:empList) {
          oos2.writeObject(empl);
          System.out.println(empl.toString());
          oos2.flush();
      }
      oos2.close();

      try {
          FileInputStream fis2 = new FileInputStream("D:\\javaOOP_laba5\\app\\src\\main\\java\\employees\\Manager.txt");
          ObjectInputStream ois2 = new ObjectInputStream(fis2);
          for (int i = 0; i < empList.size(); i++) {
              Employee emp1 = (Employee) ois2.readObject();
//              System.out.println(emp1.toString());
          }
      } catch (Exception e) {
          System.out.println(e);
      }
    }
}