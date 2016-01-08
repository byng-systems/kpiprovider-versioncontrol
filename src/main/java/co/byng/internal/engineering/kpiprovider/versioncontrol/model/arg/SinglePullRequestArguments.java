/**
 * SinglePullRequestArguments.java
 * Created 16-Dec-2015 08:23:54
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol.model.arg;

import co.byng.internal.engineering.kpiprovider.versioncontrol.model.PullRequestState;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;



/**
 * SinglePullRequestArguments
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public class SinglePullRequestArguments implements PullRequestArguments<Repository> {

    protected Repository repository;
    protected PullRequestState[] states;
    
    @Override
    public Repository getRepositories() {
        return this.getRepository();
    }

    public Repository getRepository() {
        return this.repository;
    }
    
    @Override
    public PullRequestState[] getStates() {
        return this.states;
    }

    public SinglePullRequestArguments setRepository(Repository repository) {
        this.repository = repository;

        return this;
    }

    public SinglePullRequestArguments setStates(PullRequestState[] states) {
        this.states = states;

        return this;
    }

}
