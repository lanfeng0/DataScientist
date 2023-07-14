package org.example.week2.day12.enumclass;

//枚举的基本使用示例
public class EnumEntity {
	private TypeEnum type;

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public static void main(String[] args) {
		EnumEntity ee = new EnumEntity();
		ee.setType(TypeEnum.AUDIO);
	}

}
