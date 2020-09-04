package basic.control;

import javafx.beans.property.SimpleStringProperty;

public class Board {
	private SimpleStringProperty title;
	private SimpleStringProperty password;
	private SimpleStringProperty publicity;
	private SimpleStringProperty exitDate;
	private SimpleStringProperty content;
	
	
	public Board(String title,String password,String publicity,String exitDate,String content) {
		this.title=new SimpleStringProperty(title);
		this.password=new SimpleStringProperty(password);
		this.publicity=new SimpleStringProperty(publicity);
		this.exitDate=new SimpleStringProperty(exitDate);
		this.content=new SimpleStringProperty(content);
	}
	
////////////////
	public String getTitle() {
		return this.title.get();
	}
	public void setTitle(String title) {
		this.title.set(title);
	}
	public SimpleStringProperty titleProperty() {
		return this.title;
	}
////////////////////
	public String getPassword() {
		return this.password.get();
	}
	public void setPassword(String password) {
		this.password.set(password);
	}
	public SimpleStringProperty passwordProperty() {
		return this.password;
	}
//////////////////////
	public String getPublicity() {
		return this.publicity.get();
	}
	public void setPublicity(String publicity) {
		this.publicity.set(publicity);
	}
	public SimpleStringProperty publicityProperty() {
		return this.publicity;
	}
	//////////////////////
	public String getExitDate() {
		return this.publicity.get();
	}
	public void setExitDate(String exitDate) {
		this.exitDate.set(exitDate);
	}
	public SimpleStringProperty exitDateProperty() {
		return this.exitDate;
	}
///////////////////
	public String getContent() {
		return this.content.get();
	}
	public void setCntent(String content) {
		this.content.set(content);
	}
	public SimpleStringProperty contentProperty() {
		return this.content;
	}
}
