/**
 * PullRequestFilter.java
 * Created 11-Dec-2015 19:39:49
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol.filter;

import co.byng.internal.engineering.kpiprovider.versioncontrol.model.PullRequest;



/**
 * PullRequestFilter 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface PullRequestFilter<P extends PullRequest> {

    public boolean accept(P pullRequest);

}
