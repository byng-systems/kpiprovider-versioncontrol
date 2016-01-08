/**
 * PullRequestKpiProvider.java
 * Created 14-Dec-2015 10:16:36
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol;

import co.byng.internal.engineering.kpiprovider.base.KpiCurrentValueProvider;
import co.byng.internal.engineering.kpiprovider.versioncontrol.filter.PullRequestFilter;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.arg.PullRequestArguments;
import java.util.ArrayList;
import java.util.Collection;



/**
 * PullRequestKpiProvider
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public class PullRequestKpiProvider implements KpiCurrentValueProvider<Integer, PullRequestArguments<Repository>> {

    protected final PullRequestCounter pullRequestCounter;
    protected Collection<PullRequestFilter> filters;

    public PullRequestKpiProvider(
        PullRequestCounter pullRequestCounter,
        Collection<PullRequestFilter> filters
    ) {
        this.pullRequestCounter = pullRequestCounter;
        this.filters = filters;
    }

    public PullRequestKpiProvider(PullRequestCounter pullRequestCounter) {
        this(pullRequestCounter, new ArrayList<PullRequestFilter>());
    }

    public void setFilters(Collection<PullRequestFilter> filters) {
        this.filters = filters;
    }
    
    @Override
    public Integer getCurrentValue(PullRequestArguments<Repository> args) {
        return this.pullRequestCounter.getPullRequestCount(
            args.getRepositories(),
            args.getStates(),
            filters.toArray(new PullRequestFilter[filters.size()])
        );
    }
    
}
