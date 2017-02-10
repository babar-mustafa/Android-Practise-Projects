package com.example.babarmustafa.retrofir_practise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.babarmustafa.retrofir_practise.Interfaces.GitHubService;
import com.example.babarmustafa.retrofir_practise.Models.Example;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

/*
https://square.github.io/retrofit/
http://www.jsonschema2pojo.org/
https://jsonplaceholder.typicode.com/users
https://jsonplaceholder.typicode.com/

 */
    List<Example> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        GitHubService gitHubService = GitHubService.retrofit
                .create(GitHubService.class);
        Call<List<Example>> listrepo = gitHubService.listrepo();
        listrepo.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

//                response.body().get(3).getName();
//                Toast.makeText(MainActivity.this, ""+response.body().get(3).getName(), Toast.LENGTH_SHORT).show();
                Log.d("first",response.body().get(0).toString());

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });

    }
}
