package com.friendship.friendshipclinic;


import com.friendship.friendshipclinic.Models.AllUsers;
import com.friendship.friendshipclinic.Models.Users;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MyApi {

    //Get User
    @GET("users")
    Call<AllUsers> getAllUsers();

    @GET("users/{id}")
    Call<AllUsers> getCourseById(
            @Path("id") String id

    );

    @GET("users")
    Call<ResponseBody> users(
            @Header("Authorization") String token
    );

    //Create User
    @FormUrlEncoded
    @POST("users")
    Call<ResponseBody> create(
            @Header("Authorization") String token,
            @Field("name") String user_name,
            @Field("email") String user_email,
            @Field("gender") String user_gender,
            @Field("status") String user_status
    );

    //Update User
    @FormUrlEncoded
    @PUT("users/{id}")
    Call<ResponseBody> update(
            @Header("Authorization") String token,
            @Field("name") String user_name,
            @Field("email") String user_email,
            @Field("gender") String user_gender,
            @Field("status") String user_status
    );


}

