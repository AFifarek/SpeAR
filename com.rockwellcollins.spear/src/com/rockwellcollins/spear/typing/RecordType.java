package com.rockwellcollins.spear.typing;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RecordType extends Type {

	public final String id;
	public final Map<String, Type> fields;
	
	public RecordType(String id, Map<String, Type> fields) {
		this.id=id;
		this.fields=Collections.unmodifiableSortedMap(new TreeMap<>(fields));
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
		if (obj instanceof RecordType) {
			RecordType other = (RecordType) obj;
			return id.equals(other.id);
		}
		return false;
	}
}
