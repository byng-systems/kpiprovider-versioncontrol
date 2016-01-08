/*
 * Copyright (c) 2016, Byng Services Ltd
 */
package co.byng.internal.engineering.kpiprovider.versioncontrol.model.arg;

import co.byng.internal.engineering.kpiprovider.versioncontrol.model.PullRequestState;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 */
@RunWith(MockitoJUnitRunner.class)
public class MultiRepositoryPullRequestArgumentsTest {
    
    private MultiRepositoryPullRequestArguments args;
    
    @Before
    public void setUp() {
        this.args = new MultiRepositoryPullRequestArguments();
    }
    
    /**
     * Test of getRepositories method, of class MultiRepositoryPullRequestArguments.
     */
    @Test
    public void testGetAndSetRepositories() {
        assertNull(this.args.getRepositories());
        
        Repository[] repositories = new Repository[]{mock(Repository.class)};
        
        assertSame(
            this.args,
            this.args.setRepositories(repositories)
        );
        
        assertSame(
            repositories,
            this.args.getRepositories()
        );
    }

    /**
     * Test of getStates method, of class MultiRepositoryPullRequestArguments.
     */
    @Test
    public void testGetAndSetStates() {
        assertNull(this.args.getStates());
        PullRequestState[] states = new PullRequestState[] {mock(PullRequestState.class)};

        assertSame(
            this.args,
            this.args.setStates(states)
        );

        assertSame(
            states,
            this.args.getStates()
        );
    }

}
