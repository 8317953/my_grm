package ceshi;

public class ZiDuan {
	public String columnName;
	public String columnTypeName;
	
	
	public String getType() {
		if(columnName.endsWith("_id")&&!columnName.contains("code_id")) {
			return "MyObject";
		}
		else if(columnName.contains("inputer")||columnName.contains("manager")||columnName.contains("acter")) {
			return "User";
		}
		else {
			if("INT".equals(columnTypeName)) {
				return "Integer";
			}else if("VARCHAR".equals(columnTypeName)) {
				return "String";
			}else if("DOUBLE".equals(columnTypeName)) {
				return "Double";
			}else if("DATETIME".equals(columnTypeName)) {
				return "Date";
			}else {
				return "UnKnown";
			}
		}
		
		
	}
	
	public String getAttributeName() {
		String attName=columnName.replace("_", "");
		attName=attName.toLowerCase();
		return attName;
	}
}
