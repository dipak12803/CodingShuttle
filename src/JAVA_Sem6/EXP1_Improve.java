//package JAVA_Sem6;
//
//class Employee {
//    String empid;
//    String empName;
//    String depName;
//    String dateJoin;
//    int basic;
//    int hra;
//    int it;
//    char empDes;
//
//    public Employee(String empid, String empName, String depName, String dateJoin, int basic, int hra, int it, char empDes) {
//        this.empid = empid;
//        this.empName = empName;
//        this.depName = depName;
//        this.dateJoin = dateJoin;
//        this.basic = basic;
//        this.hra = hra;
//        this.it = it;
//        this.empDes = empDes;
//    }
//
//    public int calculateSalary() {
//        int da = 0;
//        switch (empDes) {
//            case 'e':
//                da = 20000;
//                break;
//            case 'c':
//                da = 32000;
//                break;
//            case 'k':
//                da = 12000;
//                break;
//            case 'r':
//                da = 15000;
//                break;
//            case 'm':
//                da = 40000;
//                break;
//        }
//        return basic + hra + it + da;
//    }
//}
//public class EXP1_Improve {
//    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.out.println("Please provide an employee ID as a command line argument.");
//            return;
//        }
//
//        Employees[] employees = {
//                new Employees("1001", "Ashish", "R&D", "1/04/2009", 20000, 8000, 3000, 'e'),
//                new Employees("1002", "Sushma", "PM", "23/08/2012", 30000, 12000, 9000, 'c'),
//                new Employees("1003", "Rahul", "Acct", "12/11/2008", 10000, 8000, 1000, 'k'),
//                new Employees("1004", "Chahat", "Front Desk", "29/01/2013", 12000, 6000, 2000, 'r'),
//                new Employees("1005", "Ranjan", "Engg", "16/07/2005", 50000, 20000, 20000, 'm'),
//                new Employees("1006", "Suman", "Manufacturing", "1/01/2000", 23000, 9000, 4400, 'e'),
//                new Employees("1007", "Tanmay", "PM", "12/06/2006", 29000, 12000, 10000,'c'),
//                // Add more employees here
//        };
//
//        int pos = -1;
//        for (int i = 0; i < employees.length; i++) {
//            if (args[0].equals(employees[i].empid)) {
//                pos = i;
//                break;
//            }
//        }
//
//        if (pos == -1) {
//            System.out.println("Emp id does not exist");
//            return;
//        }
//
//        Employees selectedEmployee = employees[pos];
//        int salary = selectedEmployee.calculateSalary();
//
//        System.out.println("Emp no\t\tEmployee Name\t\tDepartment\t\tDesignation\t\tSalary");
//        System.out.println(selectedEmployee.empid + "\t\t\t" + selectedEmployee.empName + "\t\t\t" +
//                selectedEmployee.depName + "\t\t\t" + selectedEmployee.empDes + "\t\t" + salary);
//    }
//    }
//
