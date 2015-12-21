package com.rockwellcollins.spear.units;

import java.util.HashMap;
import java.util.Map;

public class ComputedUnit extends SpearUnit {

	public Map<String,Integer> map;
	
	public ComputedUnit(Map<String,Integer> map) {
		this.map=map;
	}
	
	public ComputedUnit multiply(ComputedUnit other) {
		Map<String,Integer> merged = ComputedUnit.mergeMaps(this.map, other.map);
		return new ComputedUnit(merged);
	}
	
	public ComputedUnit divide(ComputedUnit other) {
		Map<String,Integer> reciprocal = ComputedUnit.reciprocal(other.map);
		Map<String,Integer> merged = ComputedUnit.mergeMaps(this.map, reciprocal);
		return new ComputedUnit(merged);
	}
	
	@Override
	public String toString() {
		
		if(map.isEmpty()) {
			return "scalar";
		}
		
		StringBuilder numerator = new StringBuilder();
		StringBuilder denominator = new StringBuilder();
		
		for(String name : map.keySet()) {
			Integer value = map.get(name);
			if(value > 0) {
				for(int i=0; i<value; i++) {
					numerator.append(name);
					if(i<value-1) {
						numerator.append("*");
					}
				}
			}
			
			if(value < 0) {
				for(int i=0; i<-value; i++) {
					denominator.append(name);
					if(i<-value-1) {
						denominator.append("*");
					}
				}
			}
		}

		if(numerator.length() == 0) {
			numerator.append("1");
		}
		
		if(denominator.length() == 0) {
			return numerator.toString();
		}
		
		return numerator.toString() + "/" + denominator.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ComputedUnit) {
			ComputedUnit other = (ComputedUnit) obj;
			return ComputedUnit.mapsEqual(this.map, other.map);
		} else {
			return false;
		}
	}
	
	/***************************************************************************************************/
	// Helpers
	/***************************************************************************************************/
	private static Map<String, Integer> mergeMaps(Map<String, Integer> left, Map<String, Integer> right) {
		Map<String, Integer> merged = new HashMap<>();
		merged.putAll(left);

		for (String unit : right.keySet()) {
			Integer rightValue = right.get(unit);
			if (merged.containsKey(unit)) {
				Integer leftValue = merged.get(unit);
				Integer sum = leftValue + rightValue;
				if(sum == 0) {
					merged.remove(unit);
				} else {
					merged.put(unit, sum);	
				}
			} else {
				merged.put(unit, rightValue);
			}
		}
		return merged;
	}

	private static Map<String, Integer> reciprocal(Map<String, Integer> map) {
		Map<String, Integer> reciprocal = new HashMap<>();
		for (String unit : map.keySet()) {
			Integer value = map.get(unit);
			reciprocal.put(unit, -value);
		}
		return reciprocal;
	}
	
	private static boolean mapsEqual(Map<String, Integer> left, Map<String, Integer> right) {
		if(left.keySet().equals(right.keySet())) {
			for(String unit : left.keySet()) {
				Integer leftValue = left.get(unit);
				Integer rightValue = right.get(unit);
				if(!leftValue.equals(rightValue)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
