package com.example.xuankexitong;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.PreferenceChangeEvent;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        final SharedPreferences pref;
        final SharedPreferences.Editor editor;
        final EditText account;
        final EditText password;
        Button login;
        final CheckBox checkBox;

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        account = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.Button_login);
        checkBox = findViewById(R.id.checkBox);

        boolean isRemeber = pref.getBoolean("remeber", false);
        if(isRemeber){
            String username = pref.getString("account", "");
            String userpassword = pref.getString("password","");
            account.setText(username);
            password.setText(userpassword);
            checkBox.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = account.getText().toString();
                String userpassword = password.getText().toString();
                if(username.equals("student") && userpassword.equals("123456")){
                    if(checkBox.isChecked()){
                        editor.putBoolean("remeber",true);
                        editor.putString("account",username);
                        editor.putString("password",userpassword);
                    }else{
                        editor.clear();
                    }
                    editor.apply();//用到editor最后需要有一个提交进行执行
                    boolean noFirst = pref.getBoolean("fir",false);
                    if(noFirst){
                        Intent intent = new Intent(Login.this, home.class);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(Login.this, xuanke.class);
                        startActivity(intent);
                        editor.putBoolean("fir",true);
                    }
                }else{
                    Toast.makeText(Login.this, "用户名或密码错误",Toast.LENGTH_LONG).show();
                }
            }
        });
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
    }
}