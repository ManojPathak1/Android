package app.myapplication.com.reuz_app.helper;

public interface ILoginHelper {

	boolean isEmailOrPhoneExist(String emailPhone);
	boolean isEmailOrPhoneAndPasswordExist(String emailPhone, String password);
}
