package Ejercicio_redes_sociales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private LocalDate date;
	private List<Comment> commentList = new ArrayList<>();
	
	public Post(LocalDate date, List commentList) {
		this.date = date;
		this.commentList = commentList;
	}
	
	public Post() {
	}

	public LocalDate getDate() {return date;}
	public void setDate(LocalDate date) {this.date = date;}

	public List<Comment> getCommentList() {return commentList;}
    public void setCommentList(List<Comment> commentList) {this.commentList = commentList;}

	
    

}
