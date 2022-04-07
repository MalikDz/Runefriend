package org.runefriend.client.data.serializable;

import java.io.Serializable;

/**
 * 
 * @author MalikDz
 *
 */

public class MethodHook implements Serializable {

	/**
	 * 
	 * our fields
	 * 
	 */

	private long opaquePredicateValue;
	private static final long serialVersionUID = 1L;
	private String className, methodName, realName, fullMethodName, opaquePredicateType;

	/**
	 * 
	 * creates a new hook
	 * 
	 */

	public MethodHook(final String realName, final String sourceName) {
		this(realName, sourceName, null, 1);
	}

	/**
	 * 
	 * creates a new hook
	 * 
	 */

	public MethodHook(String realName, String sourceName, String opType, long value) {
		this.realName = realName;
		this.fullMethodName = sourceName;
		this.opaquePredicateValue = value;
		this.opaquePredicateType = opType;
		this.className = fullMethodName.split("\\.")[0];
		this.methodName = fullMethodName.split("\\.")[1];
	}

	/**
	 *
	 * @return the opaque predicate type of this hooked method
	 *
	 */

	public String getOpaquePredicateType() {
		return opaquePredicateType;
	}

	/**
	 *
	 * @return the opaque predicate value of this hooked method
	 *
	 */
	public long getOpaquePredicateValue() {
		return opaquePredicateValue;
	}

	/**
	 *
	 * @return the class and method name together of this hooked method
	 *
	 */

	public String getFullMethodName() {
		return fullMethodName;
	}

	/**
	 *
	 * @return the obfuscated class name of this hooked method
	 *
	 */

	public String getClassName() {
		return className;
	}

	/**
	 *
	 * @return the obfuscated method name of this hooked method
	 *
	 */

	public String getMethodName() {
		return methodName;
	}

	/**
	 *
	 * @return the non obfuscated name of this method
	 *
	 */

	public String getRealName() {
		return realName;
	}

	/**
	 * 
	 * @return a string representating this object
	 * 
	 */

	@Override
	public String toString() {
		return String.format("Real name : %s -> %s  %d", realName, fullMethodName, opaquePredicateValue);
	}
}
