/**
 * PullRequestCounter.java
 * Created 14-Dec-2015 10:17:29
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol;

import co.byng.internal.engineering.kpiprovider.versioncontrol.filter.PullRequestFilter;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.PullRequestState;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;



/**
 * PullRequestCounter 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface PullRequestCounter {

    public Integer getPullRequestCount(
        Repository repository,
        PullRequestState[] states,
        PullRequestFilter[] filters
    );
    
}
