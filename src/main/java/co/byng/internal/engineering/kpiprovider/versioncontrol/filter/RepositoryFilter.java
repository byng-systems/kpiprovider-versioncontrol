/**
 * RepositoryFilter.java
 * Created 18-Dec-2015 13:28:59
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol.filter;

import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;



/**
 * RepositoryFilter 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface RepositoryFilter<R extends Repository> {

    public boolean accept(R repository);
    
}
