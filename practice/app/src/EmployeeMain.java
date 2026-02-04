import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EmployeeMain {
    public static void main(String[] args) {
        Map<UUID, Employee> employees = new HashMap<>();
        Employee employee1 = new Employee("first", "null", 0.5);
        Employee employee2 = new Employee("first", "null", 0.5);
        employee1.addToMap(employees);
        employee2.addToMap(employees);
        IO.println(employees);
    }
}
