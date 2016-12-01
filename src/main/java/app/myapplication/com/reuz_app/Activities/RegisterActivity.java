package app.myapplication.com.reuz_app.Activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.myapplication.com.reuz_app.DTO.User;
import app.myapplication.com.reuz_app.Fragments.LoginFragment;
import app.myapplication.com.reuz_app.R;
import app.myapplication.com.reuz_app.Validator.IValidation;
import app.myapplication.com.reuz_app.Validator.Validation;
import app.myapplication.com.reuz_app.dao.IUserDAO;
import app.myapplication.com.reuz_app.dao.UserDAO;


public class RegisterActivity extends AppCompatActivity {
    private EditText emailET, passwordET, nameET;
    private Button registerBtn;
    private TextView uaeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This is for mobile back button.
                onBackPressed();
            }
        });
        this.mapping();
        this.editTextListeners();
        this.buttonListeners();
    }

    public void mapping(){
        emailET = (EditText)findViewById(R.id.emailPhoneET);
        passwordET = (EditText)findViewById(R.id.passwordET);
        nameET = (EditText)findViewById(R.id.nameET);
        registerBtn = (Button)findViewById(R.id.registerBtn);
        registerBtn.setEnabled(false);
        uaeTV = (TextView)findViewById(R.id.uaeTV);
    }

    public void editTextListeners(){
        emailET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableRegisterButton();
            }
        });

        passwordET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableRegisterButton();
            }
        });

        nameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                enableRegisterButton();
            }
        });
    }

    public void buttonListeners(){
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailET.getText().toString();
                // Write here email validation if emailid exist in the database.
                IUserDAO iUserDAO = new UserDAO();
                if(!iUserDAO.isEmailExist(email)) {
                    createNewUser();
                }
                else
                {
                    // Add warning text to the register activity.
                    uaeTV.setText("Unable to register. User already exist !");
                }
            }
        });
    }

    public void enableRegisterButton(){
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();
        String name = nameET.getText().toString();
        IValidation registrationValidation = new Validation();
        boolean isValid=registrationValidation.isValidEmail(email) && registrationValidation.isPasswordValid(password) &&
                registrationValidation.isFilled(name);
        registerBtn.setEnabled(isValid);
    }

    public void createNewUser(){
        User user=new User();
        user.setEmail(emailET.getText().toString());
        user.setPassword(passwordET.getText().toString());
        user.setName(nameET.getText().toString());

        // Send data to the database. addUser(user);

        Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
        Fragment fragment = new LoginFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        // ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}



