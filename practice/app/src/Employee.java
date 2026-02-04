import java.util.Map;
import java.util.UUID;

public class Employee {
    protected final UUID id;
    protected String firstName;
    protected String lastName;
    protected double wage;

    public Employee(String firstName, String lastName, double wage) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.wage = wage;
    }

    public Employee(UUID id) {
        this.id = id;
    }

    public Map<UUID, Employee> addToMap(Map<UUID, Employee> map) {
        map.put(id, this);
        return map;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", wage=" + wage + "]";
    }
}
