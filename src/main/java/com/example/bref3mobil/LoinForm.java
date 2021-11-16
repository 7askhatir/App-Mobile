package com.example.bref3mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bref3mobil.model.LoginUser;
import com.example.bref3mobil.model.User;
import com.example.bref3mobil.service.UserClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoinForm extends AppCompatActivity {
    //declaration des inputs et buttons
    EditText text1,text2;
    Button button;
    //definition de port
    Retrofit.Builder builder=new Retrofit.Builder()
            .baseUrl("http://192.168.8.161:8888/")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit=builder.build();
    //declaration de lènterface UserClient
    UserClient userClient=retrofit.create(UserClient.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loin_form);
        //declaration des inputs et buttons
        text1=findViewById(R.id.email1);
        text2=findViewById(R.id.password2);
        button=findViewById(R.id.button3);
     //onClick in button Connection
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creation d'au objet LoginUser
                LoginUser loginUser=new LoginUser(text1.getText().toString(),text2.getText().toString());
                //Send body forma Json http://localhost:8888/user/Login
                loginF(loginUser);
            }
        });
    }
    public void loginF(LoginUser loginUser){
        Call<Void> call= userClient.login(loginUser);
        call.enqueue(new Callback<Void>() {
            @Override
            //if requeste Seccessful
            public void onResponse(Call<Void> call, Response<Void> response) {
               if(response.isSuccessful()){
                   Toast.makeText(LoinForm.this,response.headers().get("Autorization"),Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(LoinForm.this,"email or password incorrect",Toast.LENGTH_SHORT).show();

               }
            }

            @Override
            //if requeste not Seccessful
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(LoinForm.this,"no",Toast.LENGTH_SHORT).show();


            }
        });

    }
}