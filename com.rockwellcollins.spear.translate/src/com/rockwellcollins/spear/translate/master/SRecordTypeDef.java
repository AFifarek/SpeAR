package com.rockwellcollins.spear.translate.master;

import java.util.LinkedHashMap;
import java.util.Map;

import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.File;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.Type;

public class SRecordTypeDef extends STypeDef {
	
	public Map<String,Type> fields = new LinkedHashMap<>();
	
	public SRecordTypeDef(RecordTypeDef rtd, SProgram context) {
		File root = Utilities.getRoot(rtd);
		this.name = context.scope.getFileBasedName(root.getName(), rtd.getName());
		for(FieldType ft : rtd.getFields()) {
			fields.put(ft.getName(), ft.getType());
		}
	}
}
