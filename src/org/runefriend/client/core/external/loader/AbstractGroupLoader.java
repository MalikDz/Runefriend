package org.runefriend.client.core.external.loader;

import java.util.List;
import java.util.ArrayList;
import org.runefriend.client.core.external.plugins.Plugin;
import org.runefriend.client.core.external.scripting.Script;
import org.runefriend.client.core.external.data.ScriptableEntityData;

/**
 * 
 * @author MalikDz
 *
 */

public abstract class AbstractGroupLoader {

	/**
	 * 
	 * theses fields contain our script and plugins data
	 * 
	 */

	private List<ScriptableEntityData> pluginsList = new ArrayList<ScriptableEntityData>();
	private List<ScriptableEntityData> scriptsList = new ArrayList<ScriptableEntityData>();

	/**
	 * 
	 * this function is used to fill our list with updated data
	 * 
	 */

	public abstract void update();

	/**
	 * 
	 * clear the plugin and script list so that we can update them again
	 * 
	 */

	public void clearScriptableEntitiesList() {
		pluginsList.clear();
		scriptsList.clear();
	}

	/**
	 * 
	 * add our scriptable entity data to the corresponding list
	 * 
	 */

	public void addScriptableEntity(ScriptableEntityData scriptableEntity) throws Exception {
		if (scriptableEntity.getClazz().isAssignableFrom(Script.class))
			scriptsList.add(scriptableEntity);
		if (scriptableEntity.getClazz().isAssignableFrom(Plugin.class))
			pluginsList.add(scriptableEntity);
	}
}
