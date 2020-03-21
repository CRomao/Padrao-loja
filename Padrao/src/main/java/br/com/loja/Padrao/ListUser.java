package br.com.loja.Padrao;

import java.util.ArrayList;

public class ListUser {

	ArrayList<User> users = new ArrayList<>();
	User userLogged;

	public void addUser(User newUser) {
		users.add(newUser);
	}

	//Função para verificar se o email e senha estão corretos
	public boolean verifyLogin(String email, String pass) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(pass)) {
				setUserLogged(users.get(i));
				return true;
			}
		}
		return false;
	}

	public User getUserLogged() {
		return userLogged;
	}

	public void setUserLogged(User userLogged) {
		this.userLogged = userLogged;
	}

}
