package employeeMaintanance;

public class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String department;
    private String designation;
    private double salary;
    private String contactNo;
    private String email;
    private String address;

    // Constructor
    public Employee(int empId, String firstName, String lastName, int age, String gender,
                    String department, String designation, double salary,
                    String contactNo, String email, String address) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
    }

    // Getters
    public int getEmpId() { return empId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDepartment() { return department; }
    public String getDesignation() { return designation; }
    public double getSalary() { return salary; }
    public String getContactNo() { return contactNo; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
}
