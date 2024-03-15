package com.example.session10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {

    TextView username, email, password;
    AlertDialog alertDialog;
    Button pdialog;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = findViewById(R.id.tv_username);
        email = findViewById(R.id.tv_email);
        password = findViewById(R.id.tv_password);
        pdialog = findViewById(R.id.pdialog);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        setViewPager2(viewPager2);

        Intent intent = getIntent();
        String uname = intent.getStringExtra("username_user");
        String mail = intent.getStringExtra("email_user");
        String psw = intent.getStringExtra("password_user");
        username.setText(uname);
        email.setText(mail);
        password.setText(psw);
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setTitle("Logout??").setMessage("Are you sure want to log out?").setPositiveButton("Log Out", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog = builder.create();

        ProgressDialog progressDialog = new ProgressDialog(HomeActivity.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("App is on the run, please wait...");
        progressDialog.setCancelable(true);

        pdialog.setOnClickListener(v->{
            progressDialog.show();
        });

        new TabLayoutMediator(tabLayout, viewPager2,
                ((tab, position) -> tab.setText(pagerAdapter.getPageTitle(position)))).attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menu = item.getItemId();
        switch (menu){
            case R.id.logout:
                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setViewPager2(ViewPager2 viewPager2){
        if(pagerAdapter == null){
            pagerAdapter = new PagerAdapter(this);
            pagerAdapter.addFragment(new FragmentFirst(), "First");
            pagerAdapter.addFragment(new FragmentSecond(), "Second");
            pagerAdapter.addFragment(new FragmentThird(), "Third");
            viewPager2.setAdapter(pagerAdapter);
        }
    }

}

// alert dialog -> buat kasi pilihan ke user mau milih apa. are you sure want to exit? yes/no
// progress dialog -> buat kasi tau user kalo masi ada program yang masih jalan