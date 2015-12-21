package com.rockwellcollins.spear.units;

public class ArrayUnit extends SpearUnit {

	public String name;
	public SpearUnit base;
	public int size;
	
	public ArrayUnit(String name, SpearUnit base, int size) {
		this.name=name;
		this.base=base;
		this.size=size;
	}
	
	@Override
	public String toString() {
		return base.toString() + "[" + size + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ArrayUnit) {
			ArrayUnit other = (ArrayUnit) obj;
			return name.equals(other.name);
		}
		return false;
	}
}
