import mockit.Deencapsulation;
import mockit.Deencapsulation.*;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MockPrivateMethodTest {

  /*
    @Test
    public void testPublicInvokesPrivate(){

        //Make simple final to be used in the Expectations inner class
        final MockPrivateMethod simple =  new MockPrivateMethod();

        //pass simple as argument to make it a Mocked type
        //in the Expectations class
        new Expectations(simple){
            {
                Deencapsulation.invoke(simple, "iAmPrivate");
                result= ("I got INVOKED");
            }
        };

        String str = simple.publicCallsPrivate();
        assertEquals("The returned string is - I got INVOKED","I got INVOKED",str);
    }
   */
    @Test
    public void testPublicInvokesPrivateMockUp() {

        new MockUp<MockPrivateMethod>() {

            //Override the private method
            //Dont provide any ACCESSS MODIFIER!
            @Mock
            String iAmPrivate() {
                return "MockUp Invoke";
            }

        };

        MockPrivateMethod mpm = new MockPrivateMethod();

        String str = mpm.publicCallsPrivate();
        assertEquals("String returned - MockUp Invoke", "MockUp Invoke", str);
    }

}
