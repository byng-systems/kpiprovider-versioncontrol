/**
 * MultiRepositoryPullRequestArguments.java
 * Created 23-Dec-2015 19:18:33
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol.model.arg;

import co.byng.internal.engineering.kpiprovider.versioncontrol.model.PullRequestState;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;



/**
 * MultiRepositoryPullRequestArguments
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public class MultiRepositoryPullRequestArguments implements PullRequestArguments<Repository[]> {
    
    protected Repository[] repositories;
    protected PullRequestState[] states;

    
    
    @Override
    public Repository[] getRepositories() {
        return repositories;
    }

    @Override
    public PullRequestState[] getStates() {
        return states;
    }

    public MultiRepositoryPullRequestArguments setRepositories(Repository[] repositories) {
        this.repositories = repositories;
        
        return this;
    }

    public MultiRepositoryPullRequestArguments setStates(PullRequestState[] states) {
        this.states = states;
        
        return this;
    }
    
}
