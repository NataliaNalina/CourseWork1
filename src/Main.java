
public class Main {
    public static void main(String[] args) {
        System.out.println("Coursework 1");
        Employee[] people = new Employee[10];
        int idCurrentEmployee = -1;
        AutoIncrementCounter id = new AutoIncrementCounter();

        people[0] = new Employee (id.getNextId(), "Иван", "Иванов", "Иванович", 1,120000);
        people[1] = new Employee (id.getNextId(), "Петр", "Петров", "Петрович", 1,110000);
        people[2] = new Employee (id.getNextId(), "Денис", "Денисов", "Денисович", 2,130000);
        printCompleteDateOfEmployees(people);

        int summa = getCostAmount(people);
        System.out.println("Сумма затрат в месяц равна " + summa);
        idCurrentEmployee = minSumma(people);
        System.out.println("Сотрудник с минимальной зарплатой " + people[idCurrentEmployee]);
        idCurrentEmployee = maxSumma(people);
        System.out.println("Сотрудник с максимальной зарплатой " + people[idCurrentEmployee]);
        summa = averageSumma(people);
        System.out.println("Средняя зарплата сотрудников: "+ summa);
        System.out.println("Список ФИО сотрудников:" );
        printListEmployees(people);
    }

    public static int getCostAmount(Employee[] employees) {
        int summa = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                summa += employees[i].getSalary();

            }
        }
        return summa;
    }

    public static int minSumma(Employee[] employees) {
        int minSumma = 10000000;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSumma) {
                minSumma = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        return id;
    }

    public static int maxSumma(Employee[] employees) {
        int maxSumma = 0;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSumma) {
                maxSumma = employees[i].getSalary();
                id = employees[i].getId();
            }
        }
        return id;
    }

    public static int averageSumma(Employee[] employees) {
        int summa = 0;
        int amount = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null ) {
                summa += employees[i].getSalary();
                amount += 1;
            }
        }
        return (int) summa/amount;
    }

    public static void printListEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null ) {
                System.out.println( employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getSurName());

            }
        }
    }
    public static void printCompleteDateOfEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null ) {
                System.out.println(employees[i]);

            }
        }
    }
    }