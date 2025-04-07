package lk.ijse.mushroom.DTO;

public class EmployeeDTO {
    private int Employee_id;
    private String First_name;
    private String Last_name;
    private Double salary;
    private String Contact;
    private String Email;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int employee_id, String first_name, String last_name, Double salary, String contact, String email) {
        Employee_id = employee_id;
        First_name = first_name;
        Last_name = last_name;
        this.salary = salary;
        Contact = contact;
        Email = email;
    }

    public int getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(int employee_id) {
        Employee_id = employee_id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "Employee_id=" + Employee_id +
                ", First_name='" + First_name + '\'' +
                ", Last_name='" + Last_name + '\'' +
                ", salary=" + salary +
                ", Contact='" + Contact + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}