package com.rockwellcollins.spear.typing;

public class ArrayType extends Type {

	public final String id;
	public final Type base;
	public final int size;

	public ArrayType(String id, Type base, int size) {
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
		if (obj instanceof ArrayType) {
			ArrayType other = (ArrayType) obj;
			return size == other.size && base.equals(other.base);
		}
		return false;
	}
}
