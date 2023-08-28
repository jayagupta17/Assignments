import java.util.ArrayDeque;
import java.util.Deque;

class Employees {
    int empid;
    String ename;
    double salary;
    public Employees() {}
    public Employees(int empid, String ename, double salary) {
        this.empid = empid;
        this.ename = ename;
        this.salary = salary;
    }
    public String toString() {
        return "Empid: " + empid + "Ename: " + ename + "Salary: " + salary;
    }
    public boolean equals(Object obj) {
        if(obj instanceof Employees)
        {
            Employees e = (Employees) obj;
            return empid==e.empid && ename.equals(e.ename) && salary==e.salary;
        }
        return false;
    }
    public int compareTo(Employees e) {
        return empid-e.empid;
        // return hashCode()-e.hashCode();
    }
    public int hashCode() {
        return empid + ename.hashCode() + (int)salary;
    }
}
public class DequeueMain {
    public static void main(String[] args) {
        Deque<Employees> deque = new ArrayDeque<>();
        deque.addFirst(new Employees(101,"ABC",20000));
        deque.addLast(new Employees(102,"AC",25000));
        Employees first = deque.removeFirst();
        Employees last = deque.removeLast();
        System.out.println("First: " + first + ", Last: " + last);
    }
}