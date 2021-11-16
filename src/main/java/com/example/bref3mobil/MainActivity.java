package com.example.bref3mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bref3mobil.model.Insc;
import com.example.bref3mobil.model.User;
import com.example.bref3mobil.service.UserClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText nom,prenom,email,password;
    Button btn,btn2;
    //definition de port se form api

    Retrofit.Builder builder=new Retrofit.Builder()
            .baseUrl("http://192.168.8.161:8888")//equivalance de http://localhost:8888
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit=builder.build();
    //declaration de lènterface UserClient
    UserClient userClient=retrofit.create(UserClient.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //return les valur des inputs et des buttons par id
        nom=(EditText) findViewById(R.id.nom);
        prenom=(EditText) findViewById((R.id.prenm));
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        btn=(Button) findViewById(R.id.button);
        btn2=(Button) findViewById(R.id.button2);
        //on click sur button Connection dans l'activité Main
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoinForm.class);
                startActivity(intent);
            }
        });
        //on click sur button Inscreption dans l'activité Main
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creation d'un objet Insc
                Insc insc=new Insc(nom.getText().toString(),prenom.getText().toString(),email.getText().toString(),password.getText().toString());
                Inscreption(insc);
            }
        });

    }
    private void Inscreption(Insc insc){
        Call<User> call=userClient.inscr(insc);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"save",Toast.LENGTH_SHORT).show();
                    //change l'activite apres l'operation 
                    Intent intent=new Intent(MainActivity.this,LoinForm.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Login not Correct",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,LoinForm.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this,"err",Toast.LENGTH_SHORT).show();
            }
        });



    }

}