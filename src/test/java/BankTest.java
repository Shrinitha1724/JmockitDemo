import mockit.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {
    @Tested
    Bank bank;

    @Injectable
    DBManager dbManager;

    @Test
    public void testBankProcessAccount(){
        new MockUp<DBManager>(){

            @Mock
            public String retrieveAccHolderName(int accountId) {
                return "Shrinitha";
            }
        };

        String name = bank.processAccount(10);
        assertEquals("Account holder name is Shrinitha","Shrinitha",name);
    }
    @Test
   public void testRetrieveAccHolderName(){
        new Expectations(){
            {
                dbManager.retrieveAccHolderName(10);
                result="Shrinii";
            }
        };
        String name = bank.processAccount(10);
        assertEquals("Account holder name is Shrinii","Shrinii",name);

    }

    // mock static initialization blocks
    @Test
    public void testBankStaticBlock(){

        new MockUp<Bank>(){

            //clinit is used for mocking static members
            @SuppressWarnings("unused")
            @Mock
            public void $clinit(){
                Bank.updateBalance(500);
            }
        };

        assertEquals("The balance amount is 500", 100, Bank.balanceAmount);

    }

//    @Test
//    public void testRetrieveAccountHolderName() {
//
//        Bank bank = new Bank(dbManager);
//
//        // Define the Expectations block here
//        new Expectations() {
//
//            DBManager dbManager; // variables declared here are mocked by default
//
//            {
//                dbManager.retrieveAccHolderName(10);
//                result="shri";
////                returns("shrini");
//            }
//        };
//
//        String name = bank.processAccount(10);
//
//        assertEquals("Account holder Name for A/C id 10 is 'shrini' ","shrini",name);
//
//    }

}
