package br.com.loja.Padrao;

import java.util.ArrayList;

public class ListUser {
	
	ArrayList<User> users = new ArrayList<>();

	public void addUser(User newUser) {
		users.add(newUser);
	}
	
	public boolean verifyLogin(String email, String pass) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(pass)){
				return true;
			}
		}
		return false;
	}
	
}
