package Ejercicio_redes_sociales;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import es.imatia.units.Input;

public class User {

	private String name;
    private List<User> friends = new ArrayList<>();
    private List<Post> postlist = new ArrayList<>();
 
    public User(String name) {
        this.name = name;
    }

    public User(String name, List<User> friends, List<Post> postlist) {
        this.name = name;
        this.friends = friends;
        this.postlist = postlist;
    }
 
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
 
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
 

 
    
 
    public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	/**
     * @return the postlist
     */
    public List<Post> getPostlist() {
        return postlist;
    }
 
    /**
     * @param postlist the postlist to set
     */
    public void setPostlist(List<Post> postlist) {
        this.postlist = postlist;
    }
 
    public void addUser(List<User> usuarios) {
        if(!usuarios.contains(this)) {
            usuarios.add(this);
        }else {
            System.out.println("El usuario ya existe, no se puede volver a insertar");
        }
    }

	public void addFriends(User friend) {
		if(! this.getFriends().contains(friend)) {
			this.getFriends().add(friend);
		}else {
			System.out.println("Ya estaba agregado antes como amigo");
		}
	}
	
	public void deleteUser (List<User> usuarios) {
		if(usuarios.contains(this)) {
			usuarios.remove(this);
			System.out.println("Usuario removido");
		}else {
			System.out.println("El usuario no existe" );
		}
	}
	
	public void deletePost (Post postToDelete) {
		if(this.getPostlist().contains(postToDelete)) {
			this.getPostlist().remove(postToDelete);
			System.out.println("Post removido");
		}else {
			System.out.println("El post no existe" );
		}
	}
	

	public void deleteFriend(User friend) {
		if(this.getFriends().contains(friend)) {
			this.getFriends().remove(friend);
			System.out.println("Ya no sois amigos");
		}else {
			System.out.println("No existe este amigo");
		}
	}
	
	
	public void listPost (List<Post> postlist , String message) {
		System.out.println(message);
		int i=0;
		for ( Post post : postlist) {
			if ( post instanceof TextPost) {
				System.out.println(i + "- TextPost " + ((TextPost)post).getContents() );
			}
			if ( post instanceof VideoPost) {
				System.out.println(i + "- VideoPost " + ((VideoPost)post).getTitle() );
			}
			if ( post instanceof ImagePost) {
				System.out.println(i + "- ImagePost " + ((ImagePost)post).getTitle() );
			}
			i++;
		}
	}
}
