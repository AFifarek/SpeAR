package com.rockwellcollins.spear.typing;

import java.util.Iterator;
import java.util.List;

public class SpearTupleType extends SpearType {

	public final List<SpearType> types;
	
	public SpearTupleType(List<SpearType> types) {
		this.types=types;
	}
	
	@Override
	public String toString() {
		if(types.isEmpty()) {
			return "()";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		Iterator<SpearType> iterator = types.iterator();
		sb.append(iterator.next());
		while(iterator.hasNext()) {
			sb.append(", ");
			sb.append(iterator.next());
		}
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		return types.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SpearTupleType) {
			SpearTupleType other = (SpearTupleType) obj;
			return types.equals(other.types);
		}
		return false;
	}
}
