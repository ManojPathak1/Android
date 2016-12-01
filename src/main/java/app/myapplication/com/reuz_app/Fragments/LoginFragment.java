package app.myapplication.com.reuz_app.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.myapplication.com.reuz_app.Activities.HomeActivity;
import app.myapplication.com.reuz_app.Activities.RegisterActivity;
import app.myapplication.com.reuz_app.Activities.UnableToLoginActivity;
import app.myapplication.com.reuz_app.R;
import app.myapplication.com.reuz_app.Validator.IValidation;
import app.myapplication.com.reuz_app.Validator.Validation;
import app.myapplication.com.reuz_app.dao.IUserDAO;
import app.myapplication.com.reuz_app.dao.UserDAO;
import app.myapplication.com.reuz_app.helper.ILoginHelper;
import app.myapplication.com.reuz_app.helper.LoginHelper;


public class LoginFragment extends Fragment {
    private EditText emailPhoneET, passwordET;
    private Button loginBTN;
    private TextView utlTV, registerTV, invalidEmailTV, invalidPasswordTV;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // keep the fragment and all its data across screen rotation
        setRetainInstance(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        this.mapping();
        this.listeners();
        return view;
    }


        public void mapping(){
            emailPhoneET = (EditText)view.findViewById(R.id.emailPhoneET);
            passwordET = (EditText)view.findViewById(R.id.passwordET);
            loginBTN = (Button)view.findViewById(R.id.loginBTN);
            utlTV = (TextView)view.findViewById(R.id.utlTV);
            invalidEmailTV = (TextView)view.findViewById(R.id.invalidEmailTV);
            invalidPasswordTV = (TextView)view.findViewById(R.id.invalidPasswordTV);
            registerTV = (TextView)view.findViewById(R.id.registerTV);
        }

        public void listeners(){
            loginBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String emailPhone = emailPhoneET.getText().toString();
                    String password = passwordET.getText().toString();
                    validateAndMoveToActivity(emailPhone, password);

                }
            });

            utlTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent utlIntent = new Intent(getActivity(), UnableToLoginActivity.class);
                    startActivity(utlIntent);
                }
            });

            registerTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent registerIntent = new Intent(getActivity(), RegisterActivity.class);
                    startActivity(registerIntent);
                }
            });

            emailPhoneET.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    invalidEmailTV.setText("");
                    invalidPasswordTV.setText("");
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
                    invalidEmailTV.setText("");
                    invalidPasswordTV.setText("");
                }
            });
        }

        public void validateAndMoveToActivity(String emailPhone, String password){
            IValidation iValidation = new Validation();
            if(!iValidation.isFilled(emailPhone) && iValidation.isFilled(password)){
                invalidEmailTV.setText("This field is required");
            }
            else if(iValidation.isFilled(emailPhone) && !iValidation.isFilled(password)) {
                invalidPasswordTV.setText("This field is required");
            }
            else if(!iValidation.isFilled(emailPhone) && !iValidation.isFilled(password)){
                invalidEmailTV.setText("This field is required");
                invalidPasswordTV.setText("This field is required");
            }
            else
            {
                ILoginHelper iLoginHelper = new LoginHelper();
                if(iLoginHelper.isEmailOrPhoneExist(emailPhone)){
                    if(iLoginHelper.isEmailOrPhoneAndPasswordExist(emailPhone, password)) {
                        Toast.makeText(view.getContext(), "Successful Login", Toast.LENGTH_SHORT).show();
                        Intent homeACIntent = new Intent(view.getContext(), HomeActivity.class);
                        homeACIntent.putExtra("userName", "Manoj Pathak");
                        startActivity(homeACIntent);
                        // Remove this fragment.
                        getActivity().getFragmentManager().popBackStack();
                    }
                    else {
                        invalidPasswordTV.setText("Invalid login or password");
                    }
                }
                else {
                    // After successful login where do you want to move your activity.
                    invalidEmailTV.setText("Invalid phone number or email");
                }
                }
            }

}
