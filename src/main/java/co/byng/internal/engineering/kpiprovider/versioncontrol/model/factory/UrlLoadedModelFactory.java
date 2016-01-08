/**
 * UrlVersionModelFactory.java
 * Created 14-Dec-2015 20:01:32
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.versioncontrol.model.factory;

import co.byng.internal.engineering.kpiprovider.versioncontrol.model.VersionControlModellable;
import java.net.URL;



/**
 * UrlLoadedModelFactory
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface UrlLoadedModelFactory <M extends VersionControlModellable> extends ModelFactory<M, URL> {

}
