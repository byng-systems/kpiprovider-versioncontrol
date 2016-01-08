/**
 * RepositoryArgs.java
 * Created 18-Dec-2015 13:27:48
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol.model.arg;



/**
 * RepositoryArgs 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface RepositoryArgs<R> extends VersionControlArguments {

    public R getRepositoryNames();

}
