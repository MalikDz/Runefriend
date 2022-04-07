package org.runefriend.client.core.external.loader;

import java.net.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

import java.io.File;
import java.nio.file.*;
import java.io.IOException;
import org.runefriend.client.core.Constants;
import org.runefriend.client.core.external.data.Manifest;
import org.runefriend.client.core.external.plugins.Plugin;
import org.runefriend.client.core.external.scripting.Script;
import org.runefriend.client.core.external.data.ManifestInfo;
import org.runefriend.client.core.external.data.ScriptableEntityData;


/**
 * 
 * @author MalikDz
 *
 */

public class GroupClassLoader extends AbstractGroupLoader {

	/**
	 * 
	 * our fields
	 * 
	 */

	private List<String> localClassFilesPaths = new ArrayList<String>();

	/**
	 * 
	 * Create scripts instance and get their manifest
	 * 
	 */

	public GroupClassLoader() {
		localClassFilesPaths.add(Constants.CLIENT_SCRIPT_PLUGINS_PATH);
	}

	/**
	 * 
	 * load all the class files in our local and web paths and cache them
	 * 
	 */

	@Override
	public void update() {
		try {
			clearScriptableEntitiesList();
			populateScriptableEntityList();
		} catch (Exception e) {
		} catch (Error e) {
		}
	}

	/**
	 * 
	 * return a filtered array of the path stream that we passed in parameter
	 * 
	 */

	public Path[] getfilteredClassPathArray(Stream<Path> sPath) throws IOException {
		return sPath.filter(p -> p.toString().endsWith(".class") && !p.toString().contains("$")).toArray(Path[]::new);
	}

	/**
	 * 
	 * load all the class files in our local and web paths and cache them
	 * 
	 */

	private void populateScriptableEntityList() throws Exception {
		for (String folder : localClassFilesPaths)
			for (Path path : getfilteredClassPathArray(Files.walk(Paths.get(folder))))
				processClassPath(path, folder, new URLClassLoader(new URL[] { new File(folder).toURI().toURL() }));
	}

	/**
	 * 
	 * this function load the class corresponding to the classpath and cache it
	 * 
	 */

	private void processClassPath(Path s, String rootFolder, URLClassLoader cl) throws Exception {
		String localPath = Paths.get(rootFolder).relativize(s).toString();
		Class<?> c = cl.loadClass(localPath.substring(0, localPath.length() - 6).replaceAll("\\\\", "."));
		if (!(c.isAssignableFrom(Plugin.class) || c.isAssignableFrom(Script.class)))
			return;
		final Manifest m = (Manifest) c.getAnnotation(Manifest.class);
		final ManifestInfo info = new ManifestInfo(m.version(), m.author(), m.description(), m.scriptName());
		final ScriptableEntityData scriptableEntity = new ScriptableEntityData(info, c);
		addScriptableEntity(scriptableEntity);
	}
}
