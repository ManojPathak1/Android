package app.myapplication.com.reuz_app.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import app.myapplication.com.reuz_app.R;


public class SubmitAdActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private EditText priceET, titleET, descET, nameET, phoneET;
    private Button submitBtn;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_ad);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.close2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Submit a Free Ad");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This is for mobile back button.
                finish();
            }
        });
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.close2);

        this.mapping();
        this.listeners();
    }

    public void mapping(){
        categorySpinner = (Spinner)findViewById(R.id.categorySpinner);
        priceET = (EditText)findViewById(R.id.priceET);
        titleET = (EditText)findViewById(R.id.titleET);
        descET = (EditText)findViewById(R.id.descET);
        nameET = (EditText)findViewById(R.id.nameET);
        phoneET = (EditText)findViewById(R.id.phoneET);
        submitBtn = (Button)toolbar.findViewById(R.id.submitBtn);
    }

    public void listeners(){
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ad Submitted ! ", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
