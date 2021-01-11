public class MockPrivateMethod {
    private String iAmPrivate(){
        return "Private Method";
    }

    public String publicCallsPrivate(){
        return iAmPrivate();
    }
}
