/**
 * PullRequest.java
 * Created 14-Dec-2015 10:19:01
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol.model;

import org.joda.time.DateTime;



/**
 * PullRequest 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface PullRequest<S extends PullRequestState> extends VersionControlModellable {

    public DateTime getDateCreated();
    
    public S getState();
    
}
