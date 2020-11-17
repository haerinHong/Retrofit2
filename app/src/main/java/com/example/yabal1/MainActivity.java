package com.example.yabal1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//2020-10-27 저녁에 공유했던 예제
//Example 1 : https://m.blog.naver.com/PostView.nhn?blogId=slavmsla&logNo=221126567021&proxyReferer=https:%2F%2Fwww.google.com%2F
// 새로 하나 찾은것 참고하면 좋음
//Example 2 : https://coding-oneday.tistory.com/18
public class MainActivity extends AppCompatActivity {
    //.baseUrl("")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.22.67:8000/register/")
                .addConverterFactory(GsonConverterFactory.create()) //아래의 service에서 callback 받는것을 자동으로 Convert 해주게 하는것
                .build();

        User chosun = new User("제갈량", "01022223334");
        HashMap<String, Object> input = new HashMap<>();
        input.put("user_name", chosun.getUserName());
        input.put("phone", chosun.getPhone());
//        input.put("body", "body body 당근당근");

        GitHubService service = retrofit.create(GitHubService.class);

       try {
           service.postPeople(input).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    Log.d("MainActivity", "접속 성공\n" + response.raw());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("MainActivity" + "실패1",t.getMessage());
                Log.e("MainActivity",t.getStackTrace().toString());
            }
        });


        } catch (Exception ex) {
            Log.e("MainActivity" + "실패2 ", ex.getMessage());
            Log.e("MainActivity", ex.getLocalizedMessage());
        }
    }
}