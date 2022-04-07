package org.runefriend.client.core.external.loader;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.JarURLConnection;

import org.runefriend.client.core.Constants;
import org.runefriend.client.core.external.data.Manifest;
import org.runefriend.client.core.external.data.ManifestInfo;
import org.runefriend.client.core.external.data.ScriptableEntityData;

/**
 * 
 * @author MalikDz
 *
 */

public class GroupJarLoader extends AbstractGroupLoader {

	/**
	 * 
	 * our fields
	 * 
	 */
	private List<String> webPaths = new ArrayList<String>();
	private List<String> localPaths = new ArrayList<String>();

	/**
	 * 
	 * Create scripts instance and get their manifest
	 * 
	 */

	public GroupJarLoader() {
		localPaths.add(Constants.CLIENT_SCRIPT_PLUGINS_PATH);
	}

	/**
	 * 
	 * add folder paths of where macros and plugins will be stored
	 * 
	 */

	public void registerLocalFolderPaths(final String... paths) {
		Collections.addAll(localPaths, paths);
	}

	/**
	 * 
	 * add web paths of where macros and plugins will be stored
	 * 
	 */

	public void registerWebJarFilePaths(final String... paths) {
		Collections.addAll(webPaths, paths);
	}

	/**
	 * 
	 * parse and load all the jars in our local and web paths and cache them
	 * 
	 */

	@Override
	public void update() {
		try {
			clearScriptableEntitiesList();
			populateLocalJarList();
			populateWebJarList();
		} catch (Exception e) {
		}
	}

	/**
	 * 
	 * proccess the jar that the user added using the script repository
	 * 
	 */

	private void populateWebJarList() throws Exception {
		for (String jarWebUrl : webPaths)
			processJar(jarWebUrl, false);
	}

	/**
	 * 
	 * proccess the jar that the user added on his computer manually
	 * 
	 */

	private void populateLocalJarList() throws Exception {
		List<String> localJarPaths = new ArrayList<String>();
		localPaths.forEach(p -> localJarPaths.addAll(getJarFilesFullPath(p)));
		for (String jarPath : localJarPaths)
			processJar(jarPath, true);
	}

	/**
	 * 
	 * @return all the jars full path located in the folder passed in parameters
	 * 
	 */

	public List<String> getJarFilesFullPath(String folder) {
		return Arrays.stream(new File(folder).list()).filter(name -> name.endsWith("jar")).collect(toArrayList());
	}

	/**
	 * 
	 * @return give a certain type to our arraylist
	 * 
	 */

	public static <T> Collector<T, ?, ArrayList<T>> toArrayList() {
		return Collectors.toCollection(ArrayList::new);
	}

	/**
	 * 
	 * @return the jar corresponding to this url
	 * 
	 */

	private JarFile getJar(final URL url) throws Exception {
		return ((JarURLConnection) url.openConnection()).getJarFile();
	}

	/**
	 * 
	 * we create from a jar file a scriptable entity data and add it to our list
	 * 
	 */

	@SuppressWarnings("resource")
	public void processJar(final String jarPath, final boolean isLocal) throws Exception {
		final URL[] jarUrl = { new URL(isLocal ? "jar:file:" : "jar:" + jarPath + "!/") };
		final JarFile jarFile = isLocal ? new JarFile(jarPath) : getJar(jarUrl[0]);
		final Class<?> c = new URLClassLoader(jarUrl).loadClass(getPath(jarFile));
		final Manifest m = (Manifest) c.getAnnotation(Manifest.class);
		if (m == null)
			return;
		final ManifestInfo info = new ManifestInfo(m.version(), m.author(), m.description(), m.scriptName());
		final ScriptableEntityData scriptableEntity = new ScriptableEntityData(info, c);
		addScriptableEntity(scriptableEntity);
	}

	/**
	 * 
	 * @return the main class path of the jar file passed in parameter
	 * 
	 */

	private String getPath(final JarFile jar) throws Exception {
		String line, result = null;
		final JarEntry entry = jar.getJarEntry("META-INF/MANIFEST.MF");
		final BufferedReader reader = new BufferedReader(new InputStreamReader(jar.getInputStream(entry)));
		while ((line = reader.readLine()) != null && result == null)
			if (line.startsWith("Main"))
				result = line.split(":")[1].trim();
		reader.close();
		return result;
	}
}
