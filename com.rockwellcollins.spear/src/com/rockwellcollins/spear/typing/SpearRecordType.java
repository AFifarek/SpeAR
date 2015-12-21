package com.rockwellcollins.spear.typing;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class SpearRecordType extends SpearType {

	public final String id;
	public final Map<String, SpearType> fields;
	
	public SpearRecordType(String id, Map<String, SpearType> fields) {
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
		if (obj instanceof SpearRecordType) {
			SpearRecordType other = (SpearRecordType) obj;
			return id.equals(other.id);
		}
		return false;
	}
}
