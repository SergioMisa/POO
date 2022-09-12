package Ejercicio_redes_sociales;

import java.time.LocalDate;
import java.util.List;

public class TextPost extends Post {

	private String contents;

	public TextPost(LocalDate date, List comments, String contents) {
		super(date, comments);
		this.contents = contents;
	}

	public String getContents() {return contents;}
	public void setContents(String contents) {this.contents = contents;}
	
	
}
