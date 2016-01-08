/**
 * RepositoryLister.java
 * Created 18-Dec-2015 13:27:05
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol;

import co.byng.internal.engineering.kpiprovider.versioncontrol.filter.RepositoryFilter;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;
import java.util.Collection;



/**
 * RepositoryLister 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface RepositoryLister<R extends Repository> {

    public Collection<R> listRepositories(String account, RepositoryFilter[] filters);

}
