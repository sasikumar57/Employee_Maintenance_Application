package employeeMaintanance;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n===== Employee Maintenance System =====");
            System.out.println("1. Register New Employee");
            System.out.println("2. Manage Employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = getIntInput(sc);

            switch (choice) {
                case 1:
                    registerEmployee(sc, dao);
                    break;
                case 2:
                    manageEmployees(sc, dao);
                    break;
                case 3:
                    System.out.println("Thank you for using Employee Maintenance System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void registerEmployee(Scanner sc, EmployeeDAO dao) {
        try {
            System.out.print("Enter Employee ID: ");
            int id = getIntInput(sc);
            System.out.print("Enter First Name: ");
            String fn = sc.nextLine();
            System.out.print("Enter Last Name: ");
            String ln = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = getIntInput(sc);
            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            System.out.print("Enter Designation: ");
            String desig = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = getDoubleInput(sc);
            System.out.print("Enter Contact No: ");
            String contact = sc.nextLine();
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Address: ");
            String addr = sc.nextLine();

            Employee emp = new Employee(id, fn, ln, age, gender, dept, desig, salary, contact, email, addr);
            if (dao.addEmployee(emp))
                System.out.println("Employee registered successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void manageEmployees(Scanner sc, EmployeeDAO dao) {
        while (true) {
            System.out.println("\n===== Manage Employee =====");
            System.out.println("1. View All Employees");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Update Employee Details");
            System.out.println("4. Delete Employee");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int ch = getIntInput(sc);

            switch (ch) {
                case 1:
                    dao.getAllEmployees().forEach(emp ->
                            System.out.printf("%d | %s %s | %s | %s | %.2f\n",
                                    emp.getEmpId(), emp.getFirstName(), emp.getLastName(),
                                    emp.getDepartment(), emp.getDesignation(), emp.getSalary()));
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    Employee e = dao.getEmployeeById(getIntInput(sc));
                    if (e != null)
                        System.out.printf("%d | %s %s | %s | %s | %.2f\n",
                                e.getEmpId(), e.getFirstName(), e.getLastName(),
                                e.getDepartment(), e.getDesignation(), e.getSalary());
                    else System.out.println("Employee not found!");
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int uid = getIntInput(sc);
                    Employee empToUpdate = dao.getEmployeeById(uid);
                    if (empToUpdate == null) {
                        System.out.println("Employee not found!");
                        break;
                    }

                    // Update field selection menu
                    while (true) {
                        System.out.println("\nChoose field to update for Employee ID " + uid + ":");
                        System.out.println("1. First Name");
                        System.out.println("2. Last Name");
                        System.out.println("3. Age");
                        System.out.println("4. Gender");
                        System.out.println("5. Department");
                        System.out.println("6. Designation");
                        System.out.println("7. Salary");
                        System.out.println("8. Contact No");
                        System.out.println("9. Email");
                        System.out.println("10. Address");
                        System.out.println("11. Back to Manage Menu");
                        System.out.print("Enter your choice: ");
                        int updChoice = getIntInput(sc);

                        boolean updated = false;
                        switch (updChoice) {
                            case 1:
                                System.out.print("Enter new First Name: ");
                                String fn = sc.nextLine();
                                updated = dao.updateEmployeeStringField(uid, "first_name", fn);
                                break;
                            case 2:
                                System.out.print("Enter new Last Name: ");
                                String ln = sc.nextLine();
                                updated = dao.updateEmployeeStringField(uid, "last_name", ln);
                                break;
                            case 3:
                                System.out.print("Enter new Age: ");
                                int newAge = getIntInput(sc);
                                updated = dao.updateEmployeeIntField(uid, "age", newAge);
                                break;
                            case 4:
                                System.out.print("Enter new Gender: ");
                                String gend = sc.nextLine();
                                updated = dao.updateEmployeeStringField(uid, "gender", gend);
                                break;
                            case 5:
                                System.out.print("Enter new Department: ");
                                String dept = sc.nextLine();
                                updated = dao.updateEmployeeStringField(uid, "department", dept);
                                break;
                            case 6:
                                System.out.print("Enter new Designation: ");
                                String desig = sc.nextLine();
                                updated = dao.updateEmployeeStringField(uid, "designation", desig);
                                break;
                            case 7:
                                System.out.print("Enter new Salary: ");
                                double newSal = getDoubleInput(sc);
                                updated = dao.updateEmployeeDoubleField(uid, "salary", newSal);
                                break;
                            case 8:
                                System.out.print("Enter new Contact No: ");
                                String contact = sc.nextLine();
                                updated = dao.updateEmployeeStringField(uid, "contact_no", contact);
                                break;
                            case 9:
                                System.out.print("Enter new Email: ");
                                String email = sc.nextLine();
                                updated = dao.updateEmployeeStringField(uid, "email", email);
                                break;
                            case 10:
                                System.out.print("Enter new Address: ");
                                String addr = sc.nextLine();
                                updated = dao.updateEmployeeStringField(uid, "address", addr);
                                break;
                            case 11:
                                System.out.println("Returning to Manage Menu...");
                                updated = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }

                        if (updChoice == 11) break;

                        if (updated) {
                            System.out.println("Field updated successfully!");
                        } else {
                            System.out.println("Update failed. Please check constraints or try again.");
                        }

                        // ask whether to update another field or go back
                        System.out.print("Update another field for this employee? (Y/N): ");
                        String cont = sc.nextLine().trim();
                        if (!cont.equalsIgnoreCase("Y")) {
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter Employee ID: ");
                    int delId = getIntInput(sc);
                    if (dao.deleteEmployee(delId))
                        System.out.println("Employee deleted successfully!");
                    else
                        System.out.println("Employee not found!");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Enter a number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine(); // consume newline
        return val;
    }

    private static double getDoubleInput(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! Enter a valid number: ");
            sc.next();
        }
        double val = sc.nextDouble();
        sc.nextLine(); // consume newline
        return val;
    }
}
