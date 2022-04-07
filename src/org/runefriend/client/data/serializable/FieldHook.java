package org.runefriend.client.data.serializable;

import java.io.Serializable;

/**
 * 
 * @author MalikDz
 *
 */

public class FieldHook implements Serializable {

	/**
	 * 
	 * our fields
	 * 
	 */

	private long decoder, encoder;
	private static final long serialVersionUID = 1L;
	private String className, fieldName, realName, sourceName, type, sourceType;

	/**
	 * 
	 * creates a new hook
	 * 
	 */

	public FieldHook(final String realName, final String sourceName) {
		this(realName, sourceName, 1);
	}

	/**
	 * 
	 * creates a new hook
	 * 
	 */

	public FieldHook(final String realName, final String sourceName, String type) {
		this(realName, sourceName);
		this.type = type;
	}

	/**
	 * 
	 * creates a new hook
	 * 
	 */

	public FieldHook(String realName, String sourceName, long dec) {
		this(realName, sourceName, dec, -1);
	}

	/**
	 * 
	 * creates a new hook
	 * 
	 */

	public FieldHook(String realName, String sourceName, long dec, long enc) {
		this.decoder = dec;
		this.encoder = enc;
		this.realName = realName;
		this.sourceName = sourceName;
		className = sourceName.split("\\.")[0];
		fieldName = sourceName.split("\\.")[1];
	}

	/**
	 * 
	 * set the source type of this field
	 * 
	 */

	public void setFieldSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	/**
	 * 
	 * @return the field source type of this field hook
	 *
	 */

	public String getSourceType() {
		return sourceType;
	}

	/**
	 * 
	 * set the type of this field
	 * 
	 */

	public void setFieldType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return the field type of this field hook
	 *
	 */

	public String getType() {
		return type;
	}

	/**
	 * 
	 * @return the non obfuscated name of this field
	 *
	 */

	public String getRealName() {
		return realName;
	}

	/**
	 * 
	 * @return the obfuscated name of this field
	 *
	 */

	public String getSourceName() {
		return sourceName;
	}

	/**
	 * 
	 * @return the field encoder
	 *
	 */

	public long getEncoder() {
		return encoder;
	}

	/**
	 * 
	 * @return the field decoder
	 *
	 */

	public long getDecoder() {
		return decoder;
	}

	/**
	 * 
	 * @return the class name where the field is located
	 *
	 */

	public String getClassName() {
		return className;
	}

	/**
	 * 
	 * @return the field name
	 *
	 */

	public String getFieldName() {
		return fieldName;
	}

	/**
	 * 
	 * @return the string padded with n the amount of spaces
	 * 
	 */
	private String padRight(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}

	/**
	 * 
	 * @return a string representation of this class
	 *
	 */

	@Override
	public String toString() {
		return String.format("%s -> %s %s %s", padRight(realName, 30), padRight(sourceName, 20),
				padRight("(" + type + ")", 85), (decoder != 1) ? " * " + decoder : "");
	}
}
