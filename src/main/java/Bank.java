public class Bank {

    static int balanceAmount;
    private DBManager dbManager;


    public Bank(DBManager dbManager){

        this.dbManager=dbManager;
    }

    public String processAccount(int accountId){
        String accHolderName;

        if(accountId<=10){
            accHolderName=dbManager.retrieveAccHolderName(accountId);
        }
        else{
            accHolderName=dbManager.retrieveAccHolderNameAgain(accountId);

        }
        return accHolderName;
    }

    //Static block begins
    static {
        updateBalance(100);
    }

    public static void updateBalance(float balance) {
        balanceAmount += balance;
    }
}
