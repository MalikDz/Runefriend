package org.runefriend.client.core;

import java.io.File;

/**
 * 
 * @author MalikDz
 *
 */

public class Constants {
	public static final String SYS_PATH = System.getProperty("user.home");
	public static final String[] SUB_FOLDERS_NAME = { "external", "screenshots", "data" };
	public static final String CLIENT_FOLDER_PATH = (new File(SYS_PATH).exists() ? SYS_PATH : "/root") + "/Runefriend";
	public static final String GAMEPACK_FULL_PATH = CLIENT_FOLDER_PATH + "/" + SUB_FOLDERS_NAME[2] + "/gamepack.jar";
	public static final String INJECTED_FULL_PATH = CLIENT_FOLDER_PATH + "/" + SUB_FOLDERS_NAME[2] + "/injected.jar";
	public static final String CLIENT_SCRIPT_PLUGINS_PATH = CLIENT_FOLDER_PATH + "/" + SUB_FOLDERS_NAME[0] + "/";

	public final static String OSRS_WEBSITE_URL = "http://oldschool%s.runescape.com/";
	public static final String OSRS_GAMEPACK_LINK = String.format(OSRS_WEBSITE_URL, "6") + "gamepack.jar";
	public static final String[] WOLRDS_ID = { "2", "3", "4", "5", "6", "9", "10", "14", "18", "22", "27", "28", "29",
			"30", "33", "34", "36", "41", "43", "44", "46", "50", "51", "54", "58", "62", "67", "68", "69", "70","77", };
}
