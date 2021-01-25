package kr.or.kh.seven;

public class PropertySetService {
	private PropertySet propertySet; // setXXX( ) 형태의 메서드로 객체 주입

	public void setPropertySet(PropertySet propertySet) {
		this.propertySet = propertySet;
	}

	public void Meg() {
		System.out.println("START");
		propertySet.insert();
		propertySet.update();
		System.out.println("END");
	}
}
