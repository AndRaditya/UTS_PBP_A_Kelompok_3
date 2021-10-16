package com.example.project_uts_pbp.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.project_uts_pbp.Model.User;

public class UserPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    //    mendefiniskan key
    public static final String IS_LOGIN = "isLogin";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    private String nama, nomor_telepon;

    public UserPreferences(Context context){
        this.context = context;
//        penamaan bebas
        sharedPreferences = context.getSharedPreferences("userPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLogin(String username, String password){
        //menyimpan data login ke sharedpreferences dengan key dan value
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_EMAIL, username);
        editor.putString(KEY_PASSWORD, password);

        //jangan lupa commit
        editor.commit();
    }

    public User getUserLogin(){
        //mengembalikan object user untuk menampilkan data user jika user udah login
        String email, password;

        email = sharedPreferences.getString(KEY_EMAIL, null);
        password = sharedPreferences.getString(KEY_PASSWORD, null);

//        if(email.equals("arya@gmail.com") && password.equals("arya")){
//            nomor_telepon
//        }else if(email.equals("jona@gmail.com") && password.equals("jona")){
//
//        }

        return new User(email, password);
    }

    public boolean checkLogin(){
        //mengembalikan nilai is login, jika sudah login otomatis nilai true jika tidak akan return false
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void logout(){
        //melakukan clear data yang ada pada sharedPreferences, jangan lupa commit
        editor.clear();
        editor.commit();
    }
}