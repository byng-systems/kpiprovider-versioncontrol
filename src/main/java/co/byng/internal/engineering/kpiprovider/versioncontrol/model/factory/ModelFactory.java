/**
 * VersionModelFactory.java
 * Created 14-Dec-2015 20:00:39
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol.model.factory;

import co.byng.internal.engineering.kpiprovider.versioncontrol.model.VersionControlModellable;



/**
 * ModelFactory 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface ModelFactory <M extends VersionControlModellable, S> {

    public M build(S source);
    
}
