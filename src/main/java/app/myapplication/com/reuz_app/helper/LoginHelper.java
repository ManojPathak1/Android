package app.myapplication.com.reuz_app.helper;

import app.myapplication.com.reuz_app.Validator.IValidation;
import app.myapplication.com.reuz_app.Validator.Validation;
import app.myapplication.com.reuz_app.dao.IUserDAO;
import app.myapplication.com.reuz_app.dao.UserDAO;

public class LoginHelper implements ILoginHelper {

	@Override
	public boolean isEmailOrPhoneExist(String emailPhone) {
		IValidation iValidation = new Validation();
		String result = iValidation.isPhoneOrEmail(emailPhone);
		IUserDAO iUserDAO = new UserDAO();
		if(result.equals("email")){
			return iUserDAO.isEmailExist(emailPhone);
		}
		else if(result.equals("phone")){
			return iUserDAO.isPhoneExist(emailPhone);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isEmailOrPhoneAndPasswordExist(String emailPhone, String password) {
		IValidation iValidation = new Validation();
		String emailOrPhone = iValidation.isPhoneOrEmail(emailPhone);
		IUserDAO iUserDAO = new UserDAO();
		return iUserDAO.isEmailOrPhoneAndPasswordExist(emailPhone, password, emailOrPhone);
	}

}
