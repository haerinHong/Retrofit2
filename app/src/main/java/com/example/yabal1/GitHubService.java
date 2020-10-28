package com.example.yabal1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    // GET 방식
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}

class Repo{
    @SerializedName("name")
    String name;
}