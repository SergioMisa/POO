package Ejercicio_redes_sociales;

import java.util.List;

import es.imatia.units.Input;

public class Utils {
	
	public static User logUser(UserList logUser) {
		for (User user : logUser.getUserlist()) {
			System.out.println(user.getName());
		}
		String user = Input.string();
		User usLogged = logUser.findUserByName(user);
		return usLogged ;
	}
}
