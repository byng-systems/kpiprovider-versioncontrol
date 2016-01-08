/**
 * PullRequestArguments.java
 * Created 16-Dec-2015 08:23:42
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol.model.arg;

import co.byng.internal.engineering.kpiprovider.versioncontrol.model.PullRequestState;



/**
 * PullRequestArguments
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface PullRequestArguments<R> extends VersionControlArguments {
    
    public PullRequestState[] getStates();
    
    public R getRepositories();
    
}
