package com.rockwellcollins.spear.typing;

import java.util.List;

public class SpearEnumType extends SpearType {
	public final String id;
	public final List<String> values;
	
	public SpearEnumType(String id, List<String> values) {
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
		if(obj instanceof SpearEnumType) {
			SpearEnumType other = (SpearEnumType) obj;
			return id.equals(other.id);
		}
		return false;
	}
}
