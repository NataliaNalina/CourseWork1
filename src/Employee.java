public class Employee {

    private static int idGenerator =  1;
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String surName;
    private int department;
    private double salary;

    public Employee(String firstName, String lastName, String surName, int department, double salary) {
        id = idGenerator++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.id + " " + this.lastName + " " + this.firstName + " " + this.surName + " подразделение: " + this.department + " текущая зарплата: " + String.format("%.2f", this.salary);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Employee c2 = (Employee) other;
        return this.id == c2.id && this.firstName.equals(c2.firstName) && this.lastName.equals(c2.lastName) && this.surName.equals(c2.surName) && this.department == c2.department && this.salary == c2.salary;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, firstName, lastName, surName, department, salary);
    }

    public String toStringWWithoutDeputment() {
        return "Сотрудник " + this.lastName + " " + this.firstName + " " + this.surName + " текущая зарплата: " + String.format("%.2f", this.salary);
    }
}
