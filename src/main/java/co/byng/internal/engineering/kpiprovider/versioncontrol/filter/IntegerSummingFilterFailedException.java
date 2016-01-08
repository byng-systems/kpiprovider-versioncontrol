/**
 * IntegerSummingFilterFailedException.java
 * Created 29-Dec-2015 07:47:42
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol.filter;



/**
 * IntegerSummingFilterFailedException
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public class IntegerSummingFilterFailedException extends FilterFailedException {
    
    private final int total;

    public IntegerSummingFilterFailedException(int total) {
        super();
        
        this.total = total;
    }

    public int getTotal() {
        return this.total;
    }
    
}
