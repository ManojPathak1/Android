package app.myapplication.com.reuz_app.Validator;

public class Validation implements IValidation {

	@Override
	public boolean isValidEmail(String email) {
		String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		boolean isEmailValid = email.matches(emailRegex);
		return isEmailValid;
	}

	@Override
	public boolean isPasswordValid(String password) {
		String passwordRegex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";
		boolean isPasswordValid = password.matches(passwordRegex);
		return isPasswordValid;
	}

	@Override
	public boolean isNameValid(String value) {
		if(value.length()>=4)
			return true;
		return false;
	}

	@Override
	public boolean isFilled(String value) {
		if(value.trim().length()!=0 && value!=null)
			return true;
		return false;
	}

	@Override
	public boolean isPhoneValid(String phone){
		if(phone.matches("\\d{10}"))
			return true;
		return false;
	}

	@Override
	public String isPhoneOrEmail(String emailPhone){
		if(isValidEmail(emailPhone))
			return "email";
		else if(isPhoneValid(emailPhone))
			return "phone";
		else
			return "nothing";
	}
}
