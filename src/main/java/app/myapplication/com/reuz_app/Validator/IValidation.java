package app.myapplication.com.reuz_app.Validator;

public interface IValidation {

	boolean isValidEmail(String email);
	boolean isPasswordValid(String password);
	boolean isNameValid(String name);
	boolean isFilled(String value);
	String isPhoneOrEmail(String emailPhone);
	boolean isPhoneValid(String phone);
}
