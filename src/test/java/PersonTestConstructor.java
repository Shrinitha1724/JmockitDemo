import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/******************* PersonTestConstructor.java ***********/
@RunWith(JMockit.class)
public class PersonTestConstructor {


    //Testing Default constructor
    @Test
    public void testGetName() {
        new MockUp<Person>() {
            @Mock
            public void $init() {
                //Dont assign name variable at all
                //Leave it null
            }

        };

        Person p = new Person();
        String name = p.getName();

        assertNull("Name of person is null",name);
//        assertEquals("it should give error","Shri",name);

    }

    //Testing parametrised constructor
    @Test
    public void testGetName1() {
        new MockUp<Person>() {
            @Mock
            public void $init(String name) {
                //Dont assign name variable at all
                //Leave it null
            }

        };

        Person p = new Person("Shrinitha Monica");
        String name = p.getName();
        System.out.println(name);
        assertNull("Name of person is null",name);
    }


}

