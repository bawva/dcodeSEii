
package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ValueChangeAlgorithmTest {
    
    public ValueChangeAlgorithmTest() {
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

   
    @Test
    public void testGetRandomMarketComponent() {
        System.out.println("getRandomMarketComponent");
        ValueChangeAlgorithm instance = new ValueChangeAlgorithm();
        int expResult = 0;
        int result = instance.getRandomMarketComponent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSectorTrendMarketComponent method, of class ValueChangeAlgorithm.
     */
    @Test
    public void testGetSectorTrendMarketComponent() {
        System.out.println("getSectorTrendMarketComponent");
        ValueChangeAlgorithm instance = new ValueChangeAlgorithm();
        int expResult = 0;
        int result = instance.getSectorTrendMarketComponent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGeneralTrendMarketComponent method, of class ValueChangeAlgorithm.
     */
    @Test
    public void testGetGeneralTrendMarketComponent() {
        System.out.println("getGeneralTrendMarketComponent");
        ValueChangeAlgorithm instance = new ValueChangeAlgorithm();
        int expResult = 0;
        int result = instance.getGeneralTrendMarketComponent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
