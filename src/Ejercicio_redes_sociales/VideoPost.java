package Ejercicio_redes_sociales;

import java.time.LocalDate;
import java.util.List;

public class VideoPost extends Post {

	private String title;
	private String quality;
	private int secsDuration;
	
	public VideoPost(LocalDate date, List comments, String title, String quality, int secsDuration) {
		super(date, comments);
		this.title = title;
		this.quality = quality;
		this.secsDuration = secsDuration;
	}

	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}

	public String getQuality() {return quality;}
	public void setQuality(String quality) {this.quality = quality;}

	public int getSecsDuration() {return secsDuration;}
	public void setSecsDuration(int secsDuration) {	this.secsDuration = secsDuration;}
	
	
	
	
}
