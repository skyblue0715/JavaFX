package basic.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Phone {
	SimpleStringProperty image;
	SimpleStringProperty smartPhone;
	
	public Phone(String smartPhone,String image) {
		this.smartPhone=new SimpleStringProperty(smartPhone);
		this.image=new SimpleStringProperty(image);
	}
	public void setSmartPhone(String smartPhone) {
		this.smartPhone.set(smartPhone);
	}
	public String getSmartPhone() {
		return this.smartPhone.get();
	}
	public void setImage(String image) {
		this.image.set(image);
	}
	public String getImage() {
		return this.image.get();
	}
	
}
