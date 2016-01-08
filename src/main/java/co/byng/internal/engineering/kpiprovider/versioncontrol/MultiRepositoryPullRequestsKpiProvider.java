/**
 * MultiRepositoryPullRequestsKpiProvider.java
 * Created 23-Dec-2015 19:11:50
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol;

import co.byng.internal.engineering.kpiprovider.base.KpiMultipleCurrentValuesProvider;
import co.byng.internal.engineering.kpiprovider.versioncontrol.filter.PullRequestFilter;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.arg.PullRequestArguments;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;



/**
 * MultiRepositoryPullRequestsKpiProvider
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public class MultiRepositoryPullRequestsKpiProvider implements KpiMultipleCurrentValuesProvider<Repository, Integer, PullRequestArguments<Repository[]>> {

    protected final MultiRepositoryPullRequestsCounter pullRequestCounter;
    protected Collection<PullRequestFilter> filters;



    public MultiRepositoryPullRequestsKpiProvider(
        MultiRepositoryPullRequestsCounter pullRequestCounter,
        Collection<PullRequestFilter> filters
    ) {
        this.pullRequestCounter = pullRequestCounter;
        this.filters = filters;
    }

    public MultiRepositoryPullRequestsKpiProvider(
        MultiRepositoryPullRequestsCounter pullRequestCounter
    ) {
        this(pullRequestCounter, new ArrayList<PullRequestFilter>());
    }

    public void setFilters(Collection<PullRequestFilter> filters) {
        this.filters = filters;
    }
    
    @Override
    public Map<Repository, Integer> getCurrentValues(
        PullRequestArguments<Repository[]> args
    ) {
        return this.pullRequestCounter.getPullRequestCounts(args.getRepositories(),
            args.getStates(),
            this.filters.toArray(new PullRequestFilter[this.filters.size()]
            )
        );
    }
    
}
