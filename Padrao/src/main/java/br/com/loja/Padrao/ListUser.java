package br.com.loja.Padrao;

import java.util.ArrayList;

public class ListUser {

	ArrayList<User> users = new ArrayList<>();
	User userLogged;

	public void addUser(User newUser) {
		users.add(newUser);
	}

	public boolean verifyLogin(String email, String pass) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(pass)) {
				setUserLogged(users.get(i));
				return true;
			}
		}
		return false;
	}

	public int totalUsers() {
		return users.size();
	}

	public User getUserLogged() {
		return userLogged;
	}

	public void setUserLogged(User userLogged) {
		this.userLogged = userLogged;
	}

}
