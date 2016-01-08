/*
 * Copyright (c) 2016, Byng Services Ltd
 */
package co.byng.internal.engineering.kpiprovider.versioncontrol;

import co.byng.internal.engineering.kpiprovider.versioncontrol.filter.PullRequestFilter;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.PullRequestState;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.arg.PullRequestArguments;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 */
@RunWith(MockitoJUnitRunner.class)
public class MultiRepositoryPullRequestsKpiProviderTest {
    
    private MultiRepositoryPullRequestsCounter pullRequestCounter;
    private Collection<PullRequestFilter> pullRequestFilters;
    private MultiRepositoryPullRequestsKpiProvider kpiProvider;
    private PullRequestArguments<Repository[]> pullRequestArgs;

    @Before
    public void setUp() {
        this.pullRequestCounter = mock(MultiRepositoryPullRequestsCounter.class);
        this.pullRequestFilters = (Collection<PullRequestFilter>) mock(Collection.class);
        
        this.kpiProvider = new MultiRepositoryPullRequestsKpiProvider(
            this.pullRequestCounter,
            this.pullRequestFilters
        );
        
        this.pullRequestArgs = new PullRequestArguments<Repository[]>() {

            @Override
            public PullRequestState[] getStates() {
                return new PullRequestState[0];
            }

            @Override
            public Repository[] getRepositories() {
                return new Repository[0];
            }
        };
    }

    public void setPullRequestFilters(Collection<PullRequestFilter> pullRequestFilters) {
        this.pullRequestFilters = pullRequestFilters;
    }
    
    /**
     * Test of getCurrentValues method, of class MultiRepositoryPullRequestsKpiProvider.
     */
    @Test
    public void testGetCurrentValues() {
        Map<Repository, Integer> result = new LinkedHashMap<>();
        result.put(mock(Repository.class), 5);
        result.put(mock(Repository.class), 10);
        
        Matcher<PullRequestFilter[]> matcher = new BaseMatcher<PullRequestFilter[]>() {

            @Override
            public boolean matches(Object item) {
                return (((PullRequestFilter[]) item).length == 1);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
        
        PullRequestFilter[] returnedFilters = new PullRequestFilter[]{mock(PullRequestFilter.class)};
        
        when(this.pullRequestFilters.size()).thenReturn(1);
        when(this.pullRequestFilters.toArray(argThat(matcher))).thenReturn(returnedFilters);        
        when(
            this.pullRequestCounter
                .getPullRequestCounts(
                    eq(this.pullRequestArgs.getRepositories()),
                    eq(this.pullRequestArgs.getStates()),
                    same(returnedFilters)
                )
        ).thenReturn(result);
        
        assertSame(
            result,
            this.kpiProvider.getCurrentValues(this.pullRequestArgs)
        );
        
        verify(this.pullRequestFilters, times(1)).size();
        verify(this.pullRequestFilters, times(1)).toArray(eq(new PullRequestFilter[1]));
    }
    
    @Test
    public void testDefaultArrayConstructor() {
        when(
            this.pullRequestCounter
                .getPullRequestCounts(
                    same(this.pullRequestArgs.getRepositories()),
                    same(this.pullRequestArgs.getStates()),
                    eq(new PullRequestFilter[0])
                )
        ).thenReturn(new HashMap<Repository, Integer>());
        
        this.kpiProvider = new MultiRepositoryPullRequestsKpiProvider(this.pullRequestCounter);
        this.kpiProvider.getCurrentValues(this.pullRequestArgs);
        
        verify(this.pullRequestFilters, times(0)).size();
        verify(this.pullRequestFilters, times(0)).toArray(eq(new PullRequestFilter[0]));
    }
    
    /**
     * Test of setFilters method, of class PullRequestKpiProvider.
     */
    @Test
    public void testSetFilters() {
        when(
            this.pullRequestCounter
                .getPullRequestCounts(
                    same(this.pullRequestArgs.getRepositories()),
                    same(this.pullRequestArgs.getStates()),
                    eq(new PullRequestFilter[0])
                )
        ).thenReturn(new HashMap<Repository, Integer>());
        
        this.kpiProvider.setFilters(new ArrayList<PullRequestFilter>());
        this.kpiProvider.getCurrentValues(this.pullRequestArgs);

        verify(this.pullRequestFilters, times(0)).size();
        verify(this.pullRequestFilters, times(0)).toArray(eq(new PullRequestFilter[0]));
    }
}
