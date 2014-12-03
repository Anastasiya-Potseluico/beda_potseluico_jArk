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
public class SwarmTest {
   
    /**
     * Test of insertBall method, of class Swarm.
     */
    @Test
    public void testInsertBall() {
        System.out.println("insertBall");
        Ball ball = null;
        Swarm instance = new Swarm(5, null);
        boolean expResult = false;
        boolean result = instance.insertBall(ball);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
