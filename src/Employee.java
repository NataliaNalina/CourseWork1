public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String surName;
    private int department;
    private int salary;

    public Employee(int id, String firstName, String lastName, String surName, int department, int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.department = department;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getSurName(){
        return surName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "Сотрудник " + this.lastName + " " + this.firstName + " " + this.surName + " подразделение: "+ this.department + " текущая зарплата: "+ this.salary;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Employee c2 = (Employee) other;
        return this.id == c2.id && this.firstName.equals(c2.firstName) && this.lastName.equals(c2.lastName) && this.surName.equals(c2.surName)  && this.department == c2.department && this.salary == c2.salary;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, firstName, lastName, surName, department, salary);
    }
}
