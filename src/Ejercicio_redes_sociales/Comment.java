package Ejercicio_redes_sociales;

import java.time.LocalDate;

public class Comment {
	
	private String text;
	private LocalDate update;
	private User owner;
	
	
	public Comment(String text, LocalDate update, User owner) {
		this.text = text;
		this.update = update;
		this.owner = owner;
	}

	
	public Comment() {
	}


	public String getText() {return text;}
	public void setText(String text) {this.text = text;}

	public LocalDate getUpdate() {return update;}
	public void setUpdate(LocalDate update) {this.update = update;}

	public User getOwner() {return owner;}
	public void setOwner(User owner) {this.owner = owner;}
	
	
	
}
