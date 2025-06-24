import java.util.ArrayList;

public class Main {

    private final static Employee[] people = new Employee[10];

    public static void main(String[] args) {
        System.out.println("Coursework 1");
        initEmployees();
        printCompleteDateOfEmployees();
        System.out.println("Сумма затрат в месяц равна " + getCostAmount());
        System.out.println("Сотрудник с минимальной зарплатой " + employeeWithMinSumma());
        System.out.println("Сотрудник с максимальной зарплатой " + employeeWitMaxSumma());
        System.out.println("Средняя зарплата сотрудников: " + averageSumma());
        System.out.println("Список ФИО сотрудников:");
        printListEmployees();

        System.out.println("Повышенная сложность.");
        int percentage = 20;
        System.out.println("Данные сотрудников после увеличения на процент :" + percentage);
        indexSalaries(percentage);
        printCompleteDateOfEmployees();
        int departmentNumber = 2;
        System.out.println("Сотрудник с минимальной зарплатой " + minSalaryDepartment(departmentNumber) + " по отделу " + departmentNumber);
        System.out.println("Сотрудник с максимальной зарплатой " + maxSalaryDepartment(departmentNumber) + " по отделу " + departmentNumber);
        System.out.println("Сумма затрат по отделу " + departmentNumber + " в месяц равна " + getCostAmountDepartment(departmentNumber));
        System.out.println("Средняя зарплата сотрудников по отделу " + departmentNumber + ": " + averageSummaDepartment(departmentNumber));
        indexSalariesDepartment(departmentNumber, percentage);
        printDateOfDepartment(departmentNumber);

        double filterSalary = 140000.00;
        filterSalaries(filterSalary, "<");
        filterSalaries(filterSalary, ">=");

    }
    private static void initEmployees() {
        people[0] = new Employee( "Иван", "Иванов", "Иванович", 1, 120000);
        people[1] = new Employee( "Петр", "Петров", "Петрович", 1, 110000);
        people[2] = new Employee("Денис", "Денисов", "Денисович", 2, 130000);
        people[3] = new Employee("Николай", "Николаев", "Николаевич", 2, 115000);
    }

    private static int getCostAmount() {
        int summa = 0;
        for (Employee employer : people) {
            if (employer != null) {
                summa += employer.getSalary();
            }
        }
        return summa;
    }

    private static Employee employeeWithMinSumma() {
        double minSumma = Integer.MAX_VALUE;
        Employee employeeForReturn = null;
        for (Employee employer : people) {
            if (employer != null && employer.getSalary() < minSumma) {
                minSumma = employer.getSalary();
                employeeForReturn = employer;
            }
        }
        return employeeForReturn;
    }

    private static Employee employeeWitMaxSumma() {
        double maxSumma = 0;
        Employee employeeForReturn = null;
        int id = 0;
        for (Employee employer : people) {
            if (employer != null && employer.getSalary() > maxSumma) {
                maxSumma = employer.getSalary();
                employeeForReturn = employer;
            }
        }
        return employeeForReturn;
    }

    private static double averageSumma() {
        int summa = 0;
        int amount = 0;
        for (Employee employer : people) {
            if (employer!= null) {
                summa += employer.getSalary();
                amount += 1;
            }
        }
        if (amount == 0) {
            return 0;
        }
         return (double) summa / amount;
    }

    private static void printListEmployees() {
        for (Employee employer : people) {
            if (employer != null) {
                System.out.println(employer.getLastName() + " " + employer.getFirstName() + " " + employer.getSurName());
            }
        }
    }

    private static void printCompleteDateOfEmployees() {
        for (Employee employer : people) {
            if (employer!= null) {
                System.out.println(employer);
            }
        }
    }

    private static void indexSalaries(int percentage) {
        for (Employee employer : people) {
            if (employer != null) {
                double currentSalary = employer.getSalary();
                double newSalary = currentSalary * (1 + (double) percentage / 100); // Добавляем процент
                employer.setSalary(newSalary);
            }
        }
    }

    private static void filterSalaries(double filterSalary, String sign) {
        if (sign.equals("<")) {
            System.out.println("Сотрудники с зарплатой меньше " + filterSalary);
            for (Employee employer : people) {
                if (employer != null && employer.getSalary() < filterSalary) {
                    System.out.println(employer.getLastName() + " " + employer.getFirstName() + " " + employer.getSurName() + " " + employer.getSalary());
                }
            }
        }
        if (sign.equals(">=")) {
            System.out.println("Сотрудники с зарплатой больше (или равно) " + filterSalary);
            for (Employee employer : people) {
                if (employer != null && employer.getSalary() > filterSalary) {
                    System.out.println(employer.getLastName() + " " + employer.getFirstName() + " " + employer.getSurName() + " " + employer.getSalary());
                }
            }
        }
    }
    private static Employee minSalaryDepartment( int departmentNumber) {
            double minSumma = Double.MAX_VALUE;
            Employee employeeForReturn = null;
            for (Employee employer : people) {
                if (employer != null && employer.getDepartment() == departmentNumber && employer.getSalary() < minSumma) {
                    minSumma = employer.getSalary();
                    employeeForReturn = employer;
                }
            }
            return employeeForReturn;
        }

    private static Employee maxSalaryDepartment(int departmentNumber) {
        double maxSumma = 0;
        Employee employeeForReturn = null;

        for (Employee employer : people) {
            if (employer!= null && employer.getDepartment() == departmentNumber && employer.getSalary() > maxSumma) {
                maxSumma = employer.getSalary();
                employeeForReturn = employer;
            }
        }
        return employeeForReturn;
    }
    private static int getCostAmountDepartment(int departmentNumber) {
        int summa = 0;
        for (Employee employer : people) {
            if (employer!= null && employer.getDepartment() == departmentNumber) {
                summa += employer.getSalary();
            }
        }
        return summa;
    }
    private static int averageSummaDepartment(int departmentNumber) {
        int summa = 0;
        int amount = 0;
        for (Employee employer : people) {
            if (employer!= null && employer.getDepartment() == departmentNumber) {
                summa += employer.getSalary();
                amount += 1;
            }
        }
        if (amount == 0) {
            return 0;
        }
        return (int) summa / amount;
    }
    private static void indexSalariesDepartment( int departmentNumber, int percentage) {
        for (Employee employer : people) {
            if (employer != null && employer.getDepartment() == departmentNumber) {
                double currentSalary = employer.getSalary();
                double newSalary = currentSalary * (1 + (double) percentage / 100); // Добавляем процент
                employer.setSalary(newSalary);
            }
        }
    }

    private static void printDateOfDepartment(int departmentNumber) {
        System.out.println("Сотрудники отдела: ");
        for (Employee employer : people) {
            if (employer != null && employer.getDepartment() == departmentNumber) {
                System.out.println(employer.getId() + " " +employer.getLastName() + " " + employer.getFirstName() + " " + employer.getSurName() + " " +  String.format("%.2f", employer.getSalary()));
            }
        }
    }

    }

