package Ejercicio_redes_sociales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.imatia.units.Input;

public class Main {

	public static void main(String[] args) {
	UserList userList = new UserList (new ArrayList<User>());
	User Pepe = new User("Pepe");
	User Manolita = new User("Manolita");
	User Juan = new User("Juan");
	User Julia = new User("Julia");
	User Sandra = new User("Sandra");
	User Diego = new User("Diego");
	User Carlos = new User("Carlos");
	
	
	userList.getUserlist().add(Pepe);
	userList.getUserlist().add(Manolita);
	userList.getUserlist().add(Diego);
	
	
	List<User> followedPepe = new ArrayList<>();
	followedPepe.add(Manolita);
	followedPepe.add(Diego);
	Pepe.setFriends(followedPepe);
	
	List<User> followedManolita = new ArrayList<>();
	followedManolita.add(Juan);
	followedManolita.add(Diego);
	followedManolita.add(Pepe);
	Manolita.setFriends(followedManolita);
	
	Post imagPepe = new ImagePost(LocalDate.of(2022, 5, 4), new ArrayList<Comment>(), "Selfie.jpg",400, 450);
	Post imagPepe2 = new ImagePost(LocalDate.of(2021, 5, 4), new ArrayList<Comment>(), "Selfie3.jpg",400, 450);
	Post imagManolita = new ImagePost(LocalDate.of(2019, 5, 4), new ArrayList<Comment>(), "Selfie4.jpg",400, 450);
	Post imagDiego = new ImagePost(LocalDate.of(2020, 5, 4), new ArrayList<Comment>(), "Selfie2.jpg",400, 450);
	Post vidPepe = new VideoPost(LocalDate.of(2020, 2, 3), new ArrayList<Comment>(), "Video guay", "4k", 120);
	Post vidManolita = new VideoPost(LocalDate.of(2021, 1, 3), new ArrayList<Comment>(), "Video feo", "4k", 120);
	Post textPepe = new TextPost(LocalDate.of(2022, 5, 4), new ArrayList<Comment>(), "Hoy salí de acampada");
	Post textPepe1 = new TextPost(LocalDate.of(2021, 1, 1), new ArrayList<Comment>(), "Hoy salí de fiesta");
	Post textPepe2 = new TextPost(LocalDate.of(2020, 7, 1), new ArrayList<Comment>(), "Hoy salí de tranqui");

	List<Post> postlistPepe = new ArrayList<>();
	List<Post> postlistManolita = new ArrayList<>();
	List<Post> postlistDiego = new ArrayList<>();
	
	postlistPepe.add(imagPepe);
	postlistPepe.add(imagPepe2);
	postlistPepe.add(textPepe);
	postlistPepe.add(textPepe1);
	postlistPepe.add(textPepe2);
	postlistPepe.add(vidPepe);
	postlistManolita.add(vidManolita);
	postlistManolita.add(imagManolita);
	postlistDiego.add(imagDiego);


	Pepe.setPostlist(postlistPepe);
	Manolita.setPostlist(postlistManolita);
	Diego.setPostlist(postlistDiego);
	
	Comment commentTextPepeDiego1 = new Comment("Menuda suerte", LocalDate.of(2002, 4, 2) , Diego);
	Comment commentTextPepeDiego2 = new Comment("Menuda fortuna", LocalDate.of(2002, 4, 2) , Diego);
	Comment commentTextPepeDiego3 = new Comment("Menuda mala suerte", LocalDate.of(2002, 4, 2) , Diego);

	Comment commentTextPepeManolita1 = new Comment("Espero que no lloviese", LocalDate.of(2002, 4, 2) , Manolita);
	Comment commentTextPepeManolita2= new Comment("Espero que no hiciese sol", LocalDate.of(2002, 4, 2) , Manolita);
	Comment commentTextPepeManolita3 = new Comment("Espero que no tronase", LocalDate.of(2002, 4, 2) , Manolita);

	List<Comment> commentList = new ArrayList<>();
	commentList.add(commentTextPepeManolita1);
	commentList.add(commentTextPepeManolita2);
	commentList.add(commentTextPepeManolita3);
	commentList.add(commentTextPepeDiego1);
	commentList.add(commentTextPepeDiego2);
	commentList.add(commentTextPepeDiego3);
	textPepe.setCommentList(commentList);

	
	String option = "";
	System.out.println();
	do {
		option = Input.string(
				"Selección: \n  '1' - Crear Usuario\n  '2' - Añadir Post\n  '3' - Añadir Comentario\n  '4' - Listar los Post de un Usuario\n  "
				+ "'5' - Ver comentarios de un Post\n  '6' - Agregar a un amigo\n  '7' - Eliminar Usuario\n  '8' - Borrar un Post\n  "
				+ "'9' - Eliminar a un amigo\n  '10' - Contar comentarios de un post\n  '11' - Ver todos los comentarios de un usuario\n  "
				+ "'12' - Borrar comentario de un Post\n  '13' - Borrar comentario del que eres dueño\n  '14' - Monstrar muro\n  '0'- Salir\n  Que quieres hacer?\n");
		System.out.println();
		switch (option) {
		case "0": //Salir
			break;
		case "1": //Crear Usuario
			String name = Input.string("Nombre de usuario");
			User u = new User(name);
			u.addUser(userList.getUserlist());
			break;
		case "2": //Añadir Post
			System.out.println("Que usuario va a publicar");
			User userposter = Utils.logUser(userList);
			if(userposter != null) {
				
				String type = Input.string("Tipo de Post (1 = texto , 2 = imagen , 3 = video)");
				switch (type) {
				case "1":
					String contenido = Input.string("Escribe el contenido");
					TextPost texpost = new TextPost(LocalDate.now(), new ArrayList<Comment>(), contenido);
					userposter.getPostlist().add(texpost);
					break;
				case "2":
					String titleimagen = Input.string("Escribe el titulo de la imagen");
					int anchoimagen = Input.integer("Ancho de imagen");
					int largoimagen = Input.integer("Largo de imagen");
					ImagePost imagepost = new ImagePost(LocalDate.now(), new ArrayList<Comment>(), titleimagen , largoimagen , anchoimagen);
					userposter.getPostlist().add(imagepost);
					break;
				case "3":
					String titlevideo = Input.string("Escribe el titulo del video");
					String calidadvideo = Input.string("Calidad del video");
					int duracion = Input.integer("Duracion de video en segundos");
					VideoPost videopost = new VideoPost(LocalDate.now(), new ArrayList<Comment>(), titlevideo , calidadvideo , duracion);
					userposter.getPostlist().add(videopost);
					break;
				}
			}

			break;
		case "3": //Añadir Comentario
			System.out.println("Que usuario va a comentar");
			User userCommenter = Utils.logUser(userList);
			/* COMPROBAMOS QUE EXISTE EL COMENTADOR */
			if(userCommenter != null) {
				System.out.println("A que usuario vas a comentar");
				User userCommented = Utils.logUser(userList);
				/* COMPROBAMOS QUE EXISTE EL USUARIO COMENTADO */
				if(userCommented != null) {
					int i = 0;
					for ( Object post : userCommented.getPostlist()) {
						if ( post instanceof TextPost) {
							System.out.println(i + "- " + ((TextPost)post).getContents() );
						}
						if ( post instanceof VideoPost) {
							System.out.println(i + "- " + ((VideoPost)post).getTitle() );
						}
						if ( post instanceof ImagePost) {
							System.out.println(i + "- " + ((ImagePost)post).getTitle() );
						}
						i++;
					}
				int numberPost = Input.integer("Elige el número del post que vas a comentar: ");
					if (userCommented.getPostlist().size() > numberPost ) {
						String textComment = Input.string("Escribe el comentario");
						Comment addComment = new Comment(textComment, LocalDate.now(), userCommenter);
						Post postCommented = (Post) userCommented.getPostlist().get(numberPost);
						postCommented.getCommentList().add(addComment);
					}
				}
			}
			break;
		case "4": //Listar los Post de un Usuario
			System.out.println("De que usuario quieres ver los post?");
			User posterer = Utils.logUser(userList);
			if (posterer != null) {
				int i = 0;
				for ( Object post : posterer.getPostlist()) {
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
			break;
		case "5": //Ver comentarios de un Post
			System.out.println("Selecciona al usuario y el post del que quieres ver los comentarios");
			System.out.println("Usuario");
			User ufound = Utils.logUser(userList);
			if (ufound != null) {
				int i = 0;
				for ( Object post : ufound.getPostlist()) {
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
				int numberPost = Input.integer("Elige el número del post del que quieres ver los comentarios: ");
				if (ufound.getPostlist().size() > numberPost ) {
					Post commentedPost = (Post) ufound.getPostlist().get(numberPost);
					for (Comment comment : commentedPost.getCommentList()) {
						System.out.println(comment.getText());
					}
				}
	
			} 
			break;
		case "6": //Agregar a un amigo
			System.out.println("Quien eres?");
			User uLoged = Utils.logUser(userList);
			if (uLoged != null) {
				System.out.println("A quien quieres agregar como amigo?");
				for (User user : userList.getUserlist()) {
					System.out.println(user.getName());
				}
				String userfriend = Input.string();
				User uFriend =userList.findUserByName(userfriend);
				 if (uFriend != null) {
					uLoged.addFriends(uFriend);
				 }	
			}
			System.out.println("Lista de Amigos: ");
			for (User user : uLoged.getFriends()) {
				System.out.println((user.getName()));
			}
			break;
		case "7": //Eliminar Usuario
			System.out.println("Que usuario quieres eliminar");
			User uDeleted = Utils.logUser(userList);
			try {
				uDeleted.deleteUser(userList.getUserlist());
			}catch(Exception e) {
				System.out.println("El usuario no existe");
			}
			break;
		case "8": //Borrar un Post
			System.out.println("Selecciona el usuario del que borrar un post");
			User puDeleted = Utils.logUser(userList);
			if (puDeleted != null) {
				int i = 0;
				for ( Object post : puDeleted.getPostlist()) {
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
				int numberPost = Input.integer("Elige el número del post que quieres eliminar ");
				if (puDeleted.getPostlist().size() > numberPost ) {
					Post postToDelete = (Post) puDeleted.getPostlist().get(numberPost);
					puDeleted.deletePost(postToDelete);
					}
				}
				break;
		case "9": //Eliminar a un amigo
			System.out.println("Quien eres?");
			User usLoged = Utils.logUser(userList);
			if (usLoged != null) {
				System.out.println("A quien quieres borrar como amigo?");
				for (User friend : usLoged.getFriends()) {
					System.out.println(friend.getName());
				}
				String usFriend = Input.string();
				User FriendToDelete =userList.findUserByName(usFriend);
				 if (FriendToDelete != null) {
					usLoged.deleteFriend(FriendToDelete);
				 }	
			}
			System.out.println("Lista de Amigos: ");
			for (User user : usLoged.getFriends()) {
				System.out.println((user.getName()));
			}
			break;
		case "10": //Contar comentarios de un post
			System.out.println("Selecciona al usuario y el post del que quieres contar los comentarios");
			System.out.println("Usuario");
			User uCount = Utils.logUser(userList);
			if (uCount != null) {
				int i = 0;
				for ( Object post : uCount.getPostlist()) {
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
				int numberPost = Input.integer("Elige el número del post del que quieres contar los comentarios: ");
				if (uCount.getPostlist().size() > numberPost ) {
					Post commentedPost = (Post) uCount.getPostlist().get(numberPost);
					int commentsTotal = commentedPost.getCommentList().size();
						System.out.println("numero de comentarios: " + commentsTotal );
						}
			} 
			break;
		case "11": //Ver todos los comentarios de un usuario
			System.out.println("De que usuario queremos ver los comentarios?");
			User useLoged = Utils.logUser(userList);
			if(useLoged != null) {
				for (User user : userList.getUserlist()) {
					for (Post post : user.getPostlist()) {
						for (Comment comment : post.getCommentList()) {
							if (useLoged.equals(comment.getOwner())) {
								System.out.println("Has comentado " + comment.getText() + " en el post de " + user.getName() ); 
							}
						}
					}
				}
			}
			break;
		case "12": // Borrar comentario de un Post
			System.out.println("Selecciona un usuario para mostrar sus post");
			User useLogged = Utils.logUser(userList);
			if (useLogged != null) {
				int i = 0;
				useLogged.listPost(useLogged.getPostlist(), "Estos son los post");
				int numberPost = Input.integer("Elige el número del post del que quieres contar los comentarios: ");
				if (useLogged.getPostlist().size() > numberPost ) {
					int cont = 0;
					Post commentedPost = (Post) useLogged.getPostlist().get(numberPost);
					for (Comment comment : commentedPost.getCommentList()) {
						System.out.println(cont + " - " + comment.getText());
						cont++;
					}
					int numberComment = Input.integer("Elige el número del comentario que quieres borrar: ");
					if (numberComment < commentedPost.getCommentList().size()) {
						commentedPost.getCommentList().remove(numberComment);
						System.out.println("Comentario eliminado");
					}
					
				}
			}
			break;
		case "13": //Borrar comentario del que eres dueño
			User usLogged = Utils.logUser(userList);
			if (usLogged != null) {
				int i = 0;
				System.out.println("Que comentario quieres borrar?");
				for (User user : userList.getUserlist()) {
					for (Post post : user.getPostlist()) {
						for (Comment comment : post.getCommentList()) {
							if (usLogged.equals(comment.getOwner())){
								System.out.println (i + " - " + comment.getText());
								i++;
							}
						}
					}
				}
				int numberComment = Input.integer("Elige el número del comentario que quieres borrar: ");
				i =0;
				Post removedPost = new Post();
				Comment removedComment = new Comment();
				for (User user : userList.getUserlist()) {
					for (Post post : user.getPostlist()) {
						for (Comment comment : post.getCommentList()) {
							if (usLogged.equals(comment.getOwner())){
								if (i == numberComment) {
									removedComment = comment;
									removedPost = post;
								} 
								i++;
								
							}
						}
					}
				}
				removedPost.getCommentList().remove(removedComment);
				
			}
			break;
		case "14": // Monstrar muro
			User ussLogged = Utils.logUser(userList);
			if (ussLogged != null) {
				List<Post> listapost = new ArrayList<>();
				List<LocalDate> listaDate = new ArrayList<>(); 
				for (User user : ussLogged.getFriends()) {
					for (Post post : user.getPostlist()) {
						listapost.add(post);
						listaDate.add(post.getDate());
					}
				}
				listaDate.sort(Comparator.reverseOrder());
				Set<LocalDate> setDate = new HashSet<LocalDate>(listaDate);
				
				for (LocalDate date : setDate) {
					int i = 0;
					while (i < setDate.size() && i < 4) {
						if( listapost.get(i).getDate().equals(date)){
							if ( listapost.get(i) instanceof TextPost) {
								System.out.println(date + "- " + ((TextPost)listapost.get(i)).getContents() );
							}
							if ( listapost.get(i) instanceof VideoPost) {
								System.out.println(date + "- " + ((VideoPost)listapost.get(i)).getTitle() );
							}
							if ( listapost.get(i) instanceof ImagePost) {
								System.out.println(date + "- " + ((ImagePost)listapost.get(i)).getTitle() );
							}
							
						}
						
					i++;	
					} 
					
				}
				
			}
			break;
		default:
			

			}
		
	}while (!option.equalsIgnoreCase("0")); 	
	

	}

}