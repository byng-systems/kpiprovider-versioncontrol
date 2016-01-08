/**
 * MultiRepositoryPullRequestsCounter.java
 * Created 16-Dec-2015 07:49:30
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol;

import co.byng.internal.engineering.kpiprovider.versioncontrol.filter.PullRequestFilter;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.PullRequestState;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;



/**
 * MultiRepositoryPullRequestsTotalCounter 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface MultiRepositoryPullRequestsTotalCounter {

    public Integer getPullRequestCount(
        Repository[] repositories,
        PullRequestState[] states,
        PullRequestFilter[] filters
    );
    
}
