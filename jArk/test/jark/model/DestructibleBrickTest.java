/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author пользователь
 */
public class DestructibleBrickTest {
    
    public DestructibleBrickTest() {
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
     * Test of destruct method, of class DestructibleBrick.
     */
    @Test
    public void testDestruct() {
        System.out.println("destruct");
        int count = 0;
        DestructibleBrick instance = null;
        instance.destruct(count);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destructibleCount method, of class DestructibleBrick.
     */
    @Test
    public void testGetDestructibleCount() {
        System.out.println("getDestructibleCount");
        DestructibleBrick instance = null;
        int expResult = 0;
        int result = instance.destructibleCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
