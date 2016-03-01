package com.rockwellcollins.spear.translate.master;

import java.util.LinkedHashMap;
import java.util.Map;

import com.rockwellcollins.spear.FieldType;
import com.rockwellcollins.spear.RecordTypeDef;
import com.rockwellcollins.spear.Type;
import com.rockwellcollins.spear.translate.lustre.TranslateType;
import com.rockwellcollins.spear.translate.naming.NameMap;

import jkind.lustre.RecordType;
import jkind.lustre.TypeDef;

public class SRecordTypeDef extends STypeDef {
	
	public String definitionName;
	public Map<String,Type> fields = new LinkedHashMap<>();
	
	public SRecordTypeDef(RecordTypeDef rtd, NameMap map) {
		this.name = map.getFileBasedName(rtd);
		this.definitionName = map.getDefinitionsName(rtd);
		for(FieldType ft : rtd.getFields()) {
			fields.put(ft.getName(), ft.getType());
		}
	}

	@Override
	public TypeDef toLustre(NameMap naming) {
		Map<String,jkind.lustre.Type> lustreFields = new LinkedHashMap<>();
		for(String fieldName : fields.keySet()) {
			lustreFields.put(fieldName,TranslateType.translate(fields.get(fieldName), naming));
		}
		jkind.lustre.RecordType rt = new RecordType(this.definitionName,lustreFields);
		return new TypeDef(this.name,rt);
	}
}
