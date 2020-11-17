package com.example.yabal1;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
//
//    Call<List<Repo>> listRepos(
//            @Path("user") String user,
//            @Query("user_name") String name,
//            @Query("phone") String phone,
//            @Body User people);

//    @GET("{user}")
//@HTTP(method = "GET", path = "{user}", hasBody = true)
//        Call<List<User>> checkUserValid(
//            @Path("user") String user,
//            @Body User people);

public interface GitHubService {
    // GET 방식
//    @GET("{user}/")
////    Call<List<Repo>> listRepos(@Path("user") String user);
//
//    @GET("{user}")
//    Call<List<User>> listPeople(
//        @Path("user") String user,
//            @Body User people
//    );
//
//    @FormUrlEncoded
    @POST("register")
    Call<User> postPeople(
            @Body HashMap<String, Object> param
            );
}









class Repo{
    @SerializedName("user_name")
    private String userName;

    @SerializedName("phone")
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}