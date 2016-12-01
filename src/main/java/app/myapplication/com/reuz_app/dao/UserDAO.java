package app.myapplication.com.reuz_app.dao;

import java.util.ArrayList;

import app.myapplication.com.reuz_app.DTO.User;
import app.myapplication.com.reuz_app.Validator.IValidation;
import app.myapplication.com.reuz_app.Validator.Validation;

public class UserDAO implements IUserDAO {

	@Override
	public boolean isEmailExist(String email) {
		ArrayList<String> emailList = new ArrayList<>();
		emailList.add("manoj.pathak1215@gmail.com");
		emailList.add("lovish007jm@gmail.com");
		emailList.add("suraj0705@gmail.com");
		for(String singleEmail : emailList){
			if(singleEmail.equals(email)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isPhoneExist(String phone){
		ArrayList<String> phoneList = new ArrayList<>();
		phoneList.add("9899536808");
		phoneList.add("9958725572");
		phoneList.add("9958540459");
		for(String singlePhone : phoneList){
			if(singlePhone.equals(phone)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmailOrPhoneAndPasswordExist(String emailPhone, String password, String emailOrPhone) {
		if(emailOrPhone.equals("email")){
			// Write Database code here.
			if(emailOrPhone.equals("manoj.pathak1215@gmail.com") && password.equals("manojpathak")){
				return true;
			}
		}
		else if(emailOrPhone.equals("phone")){
			if(emailOrPhone.equals("9899536808") && password.equals("manojpathak")){
				return true;
			}
			}
		return false;
	}

	@Override
	public String fetchUserFromLocalStorage() {
		return "";
	}
}
