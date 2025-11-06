package employeeMaintanance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO() {
        conn = DBConnection.getConnection();
    }

    public boolean addEmployee(Employee emp) {
        String query = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, emp.getEmpId());
            ps.setString(2, emp.getFirstName());
            ps.setString(3, emp.getLastName());
            ps.setInt(4, emp.getAge());
            ps.setString(5, emp.getGender());
            ps.setString(6, emp.getDepartment());
            ps.setString(7, emp.getDesignation());
            ps.setDouble(8, emp.getSalary());
            ps.setString(9, emp.getContactNo());
            ps.setString(10, emp.getEmail());
            ps.setString(11, emp.getAddress());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
            return false;
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getInt("age"), rs.getString("gender"), rs.getString("department"),
                        rs.getString("designation"), rs.getDouble("salary"), rs.getString("contact_no"),
                        rs.getString("email"), rs.getString("address"));
                list.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching employees: " + e.getMessage());
        }
        return list;
    }

    public Employee getEmployeeById(int empId) {
        String query = "SELECT * FROM employees WHERE emp_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getInt("age"), rs.getString("gender"), rs.getString("department"),
                        rs.getString("designation"), rs.getDouble("salary"), rs.getString("contact_no"),
                        rs.getString("email"), rs.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching employee: " + e.getMessage());
        }
        return null;
    }

    public boolean updateEmployeeSalary(int empId, double newSalary) {
        String query = "UPDATE employees SET salary = ? WHERE emp_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, newSalary);
            ps.setInt(2, empId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error updating salary: " + e.getMessage());
            return false;
        }
    }
    
 // Update String column (first_name, last_name, gender, department, designation, contact_no, email, address)
    public boolean updateEmployeeStringField(int empId, String column, String newValue) {
        String query = "UPDATE employees SET " + column + " = ? WHERE emp_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, newValue);
            ps.setInt(2, empId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error updating " + column + ": " + e.getMessage());
            return false;
        }
    }

    // Update int column (age)
    public boolean updateEmployeeIntField(int empId, String column, int newValue) {
        String query = "UPDATE employees SET " + column + " = ? WHERE emp_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, newValue);
            ps.setInt(2, empId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error updating " + column + ": " + e.getMessage());
            return false;
        }
    }

    // Update double column (salary)
    public boolean updateEmployeeDoubleField(int empId, String column, double newValue) {
        String query = "UPDATE employees SET " + column + " = ? WHERE emp_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, newValue);
            ps.setInt(2, empId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error updating " + column + ": " + e.getMessage());
            return false;
        }
    }

    public boolean deleteEmployee(int empId) {
        String query = "DELETE FROM employees WHERE emp_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, empId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
            return false;
        }
    }
}
