package Ejercicio_redes_sociales;

import java.time.LocalDate;
import java.util.List;

public class ImagePost extends Post {

	private String title;
	private int height;
	private int width;
	
	public ImagePost(LocalDate date, List comments, String title, int height, int width) {
		super(date, comments);
		this.title = title;
		this.height = height;
		this.width = width;
	}

	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}

	public int getWidth() {return width;}
	public void setWidth(int width) {this.width = width;}
	
	
	
	
}
