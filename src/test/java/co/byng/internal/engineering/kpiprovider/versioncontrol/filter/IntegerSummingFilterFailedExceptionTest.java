/*
 * Copyright (c) 2016, Byng Services Ltd
 */
package co.byng.internal.engineering.kpiprovider.versioncontrol.filter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public class IntegerSummingFilterFailedExceptionTest {
    
    /**
     * Test of getTotal method, of class IntegerSummingFilterFailedException.
     */
    @Test
    public void testGetTotal() {
        IntegerSummingFilterFailedException exception = new IntegerSummingFilterFailedException(5);
        
        assertEquals(5, exception.getTotal());
    }
    
}
