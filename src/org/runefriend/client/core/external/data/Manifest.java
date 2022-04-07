package org.runefriend.client.core.external.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)

/**
 * 
 * @author MalikDz
 *
 */

public @interface Manifest {

	public String author();

	public String version();

	public String scriptName();

	public String description();
}
