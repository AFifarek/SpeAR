package com.rockwellcollins.spear.typing;

import java.util.List;

public class EnumType extends Type {
	public final String id;
	public final List<String> values;
	
	public EnumType(String id, List<String> values) {
		this.id=id;
		this.values=values;
	}
	
	@Override
	public String toString() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof EnumType) {
			EnumType other = (EnumType) obj;
			return id.equals(other.id);
		}
		return false;
	}
}
