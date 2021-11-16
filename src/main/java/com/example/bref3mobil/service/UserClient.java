package com.example.bref3mobil.service;

import com.example.bref3mobil.model.Insc;

import com.example.bref3mobil.model.LoginUser;
import com.example.bref3mobil.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserClient {
   //http://localhost:8888/user/
   @POST("/user") Call<User> inscr(@Body Insc insc);//@Body body de l'application --
   //http://localhost:8888/user/Login
   @POST("/user/Login") Call<Void> login(@Body LoginUser loginUser);//@Header  de l'application
   //http://localhost:8888/user/all
   @GET("/all") Call<List<User>> findAll(@Header("Autorization") String token);


}
