package com.rockwellcollins.spear.typing;

public class SpearBuiltinType extends SpearType {
	
	public static final SpearBuiltinType BOOL = new SpearBuiltinType("bool");
	public static final SpearBuiltinType REAL = new SpearBuiltinType("real");
	public static final SpearBuiltinType INT = new SpearBuiltinType("int");
	public static final SpearBuiltinType ERROR = new SpearBuiltinType("<ERROR>");
	
	private final String name;
	
	private SpearBuiltinType(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
