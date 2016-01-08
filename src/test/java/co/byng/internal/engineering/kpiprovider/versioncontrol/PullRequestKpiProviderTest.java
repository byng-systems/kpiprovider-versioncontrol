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
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
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
public class PullRequestKpiProviderTest {
    
    private PullRequestKpiProvider kpiProvider;
    private PullRequestCounter pullRequestCounter;
    private Collection<PullRequestFilter> pullRequestFilters;
    private PullRequestArguments<Repository> pullRequestArgs;
    
    @Before
    public void setUp() {
        this.pullRequestFilters = (Collection<PullRequestFilter>) mock(Collection.class);
        this.pullRequestCounter = mock(PullRequestCounter.class);
        
        this.kpiProvider = new PullRequestKpiProvider(
            this.pullRequestCounter,
            this.pullRequestFilters
        );
        
        final Repository repository = mock(Repository.class);
        
        this.pullRequestArgs = new PullRequestArguments<Repository>() {

            @Override
            public PullRequestState[] getStates() {
                return new PullRequestState[0];
            }

            @Override
            public Repository getRepositories() {
                return repository;
            }
        };
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentValue method, of class PullRequestKpiProvider.
     */
    @Test
    public void testGetCurrentValue() {
        Integer result = 10;
        
        Matcher<PullRequestFilter[]> argMatcher = new BaseMatcher<PullRequestFilter[]>() {

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
        when(this.pullRequestFilters.toArray(argThat(argMatcher))).thenReturn(returnedFilters);
        
        when(
            this.pullRequestCounter
                .getPullRequestCount(
                    eq(this.pullRequestArgs.getRepositories()),
                    eq(this.pullRequestArgs.getStates()),
                    same(returnedFilters)
                )
        ).thenReturn(result);
        
        assertSame(
            result,
            this.kpiProvider.getCurrentValue(this.pullRequestArgs)
        );
        
        verify(this.pullRequestFilters, times(1)).size();
        verify(this.pullRequestFilters, times(1)).toArray(eq(new PullRequestFilter[1]));
    }
    
    @Test
    public void testDefaultArrayConstructor() {
        when(
            this.pullRequestCounter
                .getPullRequestCount(
                    same(this.pullRequestArgs.getRepositories()),
                    same(this.pullRequestArgs.getStates()),
                    eq(new PullRequestFilter[0])
                )
        ).thenReturn(5);
        
        this.kpiProvider = new PullRequestKpiProvider(this.pullRequestCounter);
        this.kpiProvider.getCurrentValue(this.pullRequestArgs);
        
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
                .getPullRequestCount(
                    same(this.pullRequestArgs.getRepositories()),
                    same(this.pullRequestArgs.getStates()),
                    eq(new PullRequestFilter[0])
                )
        ).thenReturn(5);
        
        this.kpiProvider.setFilters(new ArrayList<PullRequestFilter>());
        this.kpiProvider.getCurrentValue(this.pullRequestArgs);
        
        verify(this.pullRequestFilters, times(0)).size();
        verify(this.pullRequestFilters, times(0)).toArray(eq(new PullRequestFilter[0]));
    }

}
