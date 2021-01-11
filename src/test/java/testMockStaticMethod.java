import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testMockStaticMethod {
//    @Test
//    public void testMakeConnection(){
//
//        new NonStrictExpectations(){
//            // DBManager is mocked here
//            DBManager dbManager;
//
//            {
//                DBManager.getConnectionString();
//                returns("DUPLICATE");
//            }
//        };
//
//        MockStaticMethod mockStaticMethod =  new MockStaticMethod();
//        String status = mockStaticMethod.makeConnection();
//
//        assertEquals("Status is FAIL","FAIL",status);
//    }

    @Test
    public void testMakeConnectionWithMockUp(){
        new MockUp<DBManager1>(){

            // Redefine the method here
            // But With No static modifier
            @Mock
            public String getConnectionString(){
                return "DUPLICATE";
            }

        };

        MockStaticMethod mockStaticMethod =  new MockStaticMethod();
        String status = mockStaticMethod.makeConnection();


        assertEquals("Status is FAIL","werty",status);
    }
}
