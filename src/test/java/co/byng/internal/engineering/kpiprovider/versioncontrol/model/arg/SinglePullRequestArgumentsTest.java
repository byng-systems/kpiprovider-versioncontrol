/*
 * Copyright (c) 2016, Byng Services Ltd
 */
package co.byng.internal.engineering.kpiprovider.versioncontrol.model.arg;

import co.byng.internal.engineering.kpiprovider.versioncontrol.model.PullRequestState;
import co.byng.internal.engineering.kpiprovider.versioncontrol.model.Repository;
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
public class SinglePullRequestArgumentsTest {
    
    private SinglePullRequestArguments args;
    
    @Before
    public void setUp() {
        args = new SinglePullRequestArguments();
    }
    
    /**
     * Test of getRepositories method, of class SinglePullRequestArguments.
     */
    @Test
    public void testGetAndSetRepository() {
        assertNull(this.args.getRepository());
        assertNull(this.args.getRepositories());
        
        Repository repository = mock(Repository.class);
        
        assertSame(
            this.args,
            this.args.setRepository(repository)
        );
        
        assertSame(
            repository,
            this.args.getRepository()
        );
        
        assertSame(
            repository,
            this.args.getRepositories()
        );
    }

    /**
     * Test of getStates method, of class SinglePullRequestArguments.
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
