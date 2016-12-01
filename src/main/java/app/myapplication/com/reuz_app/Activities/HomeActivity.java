package app.myapplication.com.reuz_app.Activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import app.myapplication.com.reuz_app.Fragments.BrowseAdFragment;
import app.myapplication.com.reuz_app.Fragments.LoginFragment;
import app.myapplication.com.reuz_app.Fragments.TopMainFragment;
import app.myapplication.com.reuz_app.R;
import app.myapplication.com.reuz_app.dao.IUserDAO;
import app.myapplication.com.reuz_app.dao.UserDAO;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
private Fragment fragment;
private String title;
private DrawerLayout drawer;
private NavigationView navigationView;
private View layout;
    private TextView userNameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();
        System.out.println(getSupportActionBar().getHeight());
        View headerLayout = navigationView.getRootView();
        layout=headerLayout.findViewById(R.id.navigationHeader);
        this.mapping();
        this.setUserName();
        this.setInitialFragment();
        this.listeners();
    }

    public void mapping(){
        userNameTV = (TextView)findViewById(R.id.userNameTV);
    }

    public void setUserName(){
        /*Bundle extras = getIntent().getExtras();
        if(extras!=null){
            userNameTV.setText(extras.getString("userName"));
        }*/
        IUserDAO iUserDAO = new UserDAO();
        String userName = iUserDAO.fetchUserFromLocalStorage();
        if(userName.trim().length()>0 && userName!=null) {
         // Fetch the local user and load your application.
            userNameTV.setText(userName);
        }
    }

public void listeners(){
    layout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getLoginFragment();
        }
    });
}
    @Override
    public void onBackPressed() {
         //drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the home action
            setInitialFragment();


        } else if (id == R.id.nav_browse) {
                    fragment=new BrowseAdFragment();
                    title="Browse Ads";
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_help) {
            title="Help";
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        this.setTitleOnActionBar(title);
         //drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);



        return true;
    }

    public void setTitleOnActionBar(String title) {


        getSupportActionBar().setTitle(title);
    }


    public void setInitialFragment(){
        fragment=new TopMainFragment();
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,fragment);
       // ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        title="REUZ";
        setTitleOnActionBar(title);
        drawer.closeDrawer(GravityCompat.START);
    }


    public void getLoginFragment(){
        fragment=new LoginFragment();
        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,fragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        title="LOGIN/REGISTER";
        setTitleOnActionBar(title);
        drawer.closeDrawer(GravityCompat.START);

    }
}
