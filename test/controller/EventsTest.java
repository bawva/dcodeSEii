
package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class EventsTest {
    
    public EventsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBoom method, of class Events.
     */
    @Test
    public void testGetBoom() {
        System.out.println("getBoom");
        Events instance = new Events();
        int expResult = 0;
        int result = instance.getBoom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBust method, of class Events.
     */
    @Test
    public void testGetBust() {
        System.out.println("getBust");
        Events instance = new Events();
        int expResult = 0;
        int result = instance.getBust();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfitWarning method, of class Events.
     */
    @Test
    public void testGetProfitWarning() {
        System.out.println("getProfitWarning");
        Events instance = new Events();
        int expResult = 0;
        int result = instance.getProfitWarning();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTakeOver method, of class Events.
     */
    @Test
    public void testGetTakeOver() {
        System.out.println("getTakeOver");
        Events instance = new Events();
        int expResult = 0;
        int result = instance.getTakeOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScandal method, of class Events.
     */
    @Test
    public void testGetScandal() {
        System.out.println("getScandal");
        Events instance = new Events();
        int expResult = 0;
        int result = instance.getScandal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
