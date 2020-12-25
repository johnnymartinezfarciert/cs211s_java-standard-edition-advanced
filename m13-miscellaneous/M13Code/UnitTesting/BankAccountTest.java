import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


class BankAccountTest {

    private BankAccount account;
    private final static int INITIAL_BALANCE = 100;
    private final static double THRESHOLD = 0.0001;


    @BeforeEach
    public void setup() {
       // System.out.println("In setup");
        account = new BankAccount(INITIAL_BALANCE);
    }

    @Test
    public void depositPositiveIncreasesBalance() {
      //  System.out.println("In test of deposit positive");
        int value = 50;

        double beforeBalance = account.getBalance();
        account.deposit(value);
        double afterBalance = account.getBalance();
       
        assertEquals(beforeBalance + value, afterBalance, THRESHOLD);
    }

    @Test
    public void depositNegativeLeavesBalanceUnchanged() {
       // System.out.println("In test of depositive negative");
        int value = -50;

        double beforeBalance = account.getBalance();
        account.deposit(value);
        double afterBalance = account.getBalance();
       
        assertEquals(beforeBalance, afterBalance, THRESHOLD);
    }

    @Test
    public void depositZeroLeavesBalanceUnchanged() {
     //   System.out.println("In test deposit zero");
        int value = 0;

        double beforeBalance = account.getBalance();
        account.deposit(value);
        double afterBalance = account.getBalance();
        
        assertEquals(beforeBalance, afterBalance, THRESHOLD);
    }

    @Test
    public void withdrawNegativeLeavesBalanceUnchanged() {
     //   System.out.println("In test withdraw negative");
        int value = -50;

        double beforeBalance = account.getBalance();
        account.withdraw(value);
        double afterBalance = account.getBalance();

        assertEquals(beforeBalance, afterBalance, THRESHOLD);
    }

    @Test
    public void withdrawPositiveUpToBalanceDecreasesBalance() {
     //   System.out.println("In test withdraw positive");
        int value = 50;

        double beforeBalance = account.getBalance();
        account.withdraw(value);
        double afterBalance = account.getBalance();
       
        assertEquals(beforeBalance-value, afterBalance, THRESHOLD);
    }
    
    @Test
    public void withdrawZeroLeavesBalanceUnchanged() {
     //   System.out.println("In test withdraw zero");
        int value = 0;

        double beforeBalance = account.getBalance();
        account.withdraw(value);
        double afterBalance = account.getBalance();
       
        assertEquals(beforeBalance, afterBalance, THRESHOLD);
    }    

    @Test
    public void withdrawBalanceChangesBalanceToZero() {
     //   System.out.println("In test withdraw balance");
        
        double beforeBalance = account.getBalance();
        account.withdraw(beforeBalance);
        double afterBalance = account.getBalance();
        
        assertEquals(0, afterBalance, THRESHOLD);
    }
    
    @Test
    public void withdrawMoreThanBalanceLeavesBalanceUnchanged() {
     //   System.out.println("In test withdraw more than balance");
        
        double beforeBalance = account.getBalance();
        account.withdraw(beforeBalance+1);
        double afterBalance = account.getBalance();
        
        assertEquals(beforeBalance, afterBalance, THRESHOLD);
    }

}
