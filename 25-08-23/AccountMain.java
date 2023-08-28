import java.time.LocalDate;
import java.util.Date;

class Account {
    int acc_no;
    String holder_name;
    //Date opened_date;
    String status;
    double balance;
    public Account() {}
    public Account(int acc_no, String holder_name, String status, double balance)
    {
        this.acc_no = acc_no;
        this.holder_name = holder_name;
        //this.opened_date = opened_date;
        this.status = status;
        this.balance = balance;
    }
}
class Transaction {
    public static void deposit(Account a, double amount) {
        a.balance += amount;
        System.out.println("Amount added");
    }
    public static void withdraw(Account a, double amount) {
        try
        {
            if(a.balance >= amount)
            {
                a.balance -= amount;
                System.out.println("Amount deducted");
            }
            else
            {
                throw new RuntimeException("Balance is not sufficient");
            }
        }
        catch (Exception e)
        {
            System.out.println("No problem");
        }
    }
}
public class AccountMain {
    public static void main(String[] args) {
        Account a = new Account(123, "Asdff" , "fghg", 50000);
        Transaction.deposit(a, 20000);
        Transaction.withdraw(a, 30000);
        Transaction.withdraw(a, 50000);
        System.out.println("End");
    }
}
