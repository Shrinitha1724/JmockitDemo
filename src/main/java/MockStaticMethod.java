public class MockStaticMethod {
    public String makeConnection(){
        //some connection related code
        //goes here

        // call to static method
        String conStr = DBManager1.getConnectionString();

        // If the connection String
        // is anything other than
        // ORIGINAL return FAIL
        if(conStr.equals("ORIGINAL"))
            return "SUCCESS";
        else
            return "FAIL";
    }
}
