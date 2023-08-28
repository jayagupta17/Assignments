import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

class Empl {
    int empid;
    String ename;
    double salary;
    public Empl() {}
    public Empl(int empid, String ename, double salary) {
        this.empid = empid;
        this.ename = ename;
        this.salary = salary;
    }
    public String toString() {
        return "Empid: " + empid + "Ename: " + ename + "Salary: " + salary;
    }
    public boolean equals(Object obj) {
        if(obj instanceof Empl)
        {
            Empl e = (Empl)obj;
            return empid==e.empid && ename.equals(e.ename) && salary==e.salary;
        }
        return false;
    }
    public int compareTo(Empl e) {
        return empid-e.empid;
        // return hashCode()-e.hashCode();
    }
    public int hashCode() {
        return empid + ename.hashCode() + (int)salary;
    }
}
class Address {
    String locality;
    String city;
    String state;
    public Address() {}
    public Address(String locality, String city, String state) {
        this.locality = locality;
        this.city = city;
        this.state = state;
    }
    public String toString() {
        return "Locality: " + locality + "City: " + city + "State: " + state;
    }
}
public class HashMapMain {
    public static void main(String[] args)
    {
//        HashMap<String, String> emailAccountMap = new HashMap<>();
//
//        // Adding elements
//
//        emailAccountMap.put("abc@gmail.com", "abc@123");
//        emailAccountMap.put("bcd@gmail.com", "bcd@123");
//        emailAccountMap.put("cde@gmail.com", "cde@123");
//
//        // Print size and elements
//
//        System.out.println(emailAccountMap.size());
//
//        // Printing elements in object of Map
//
//        System.out.println(emailAccountMap);
//
//        // Contains
//        if (emailAccountMap.containsKey("bcd@gmail.com")) {
//            String s = emailAccountMap.get("bcd@gmail.com");
//            System.out.println(s);
//        }



        HashMap<Empl,Address> map = new HashMap<>();
        map.put(new Empl(101,"ABC",20000),new Address("hgvhn","lko","UP"));
        map.put(new Empl(102,"AB",25000),new Address("hgvhn","lko","UP"));
        map.put(new Empl(103,"AC",10000),new Address("hgvhn","lko","UP"));
        map.put(new Empl(104,"ABD",15000),new Address("hgvhn","lko","UP"));
        System.out.println(map.size());
        System.out.println(map);
        Set<Entry<Empl,Address>> eset = map.entrySet();
        for(Entry<Empl,Address> e : eset) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }
}
