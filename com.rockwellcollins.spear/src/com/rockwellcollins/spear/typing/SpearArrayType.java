package com.rockwellcollins.spear.typing;

public class SpearArrayType extends SpearType {

	public final String id;
	public final SpearType base;
	public final int size;

	public SpearArrayType(String id, SpearType base, int size) {
		this.id=id;
		this.base=base;
		this.size=size;
	}
	
	@Override
	public String toString() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return base.hashCode() + size;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SpearArrayType) {
			SpearArrayType other = (SpearArrayType) obj;
			return size == other.size && base.equals(other.base);
		}
		return false;
	}
}
