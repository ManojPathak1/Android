package app.myapplication.com.reuz_app.dao;

import app.myapplication.com.reuz_app.DTO.User;

public interface IUserDAO {

	boolean isEmailExist(String email);
	boolean isPhoneExist(String phone);
	boolean isEmailOrPhoneAndPasswordExist(String emailPhone, String password, String emailOrPhone);
	String fetchUserFromLocalStorage();
}
