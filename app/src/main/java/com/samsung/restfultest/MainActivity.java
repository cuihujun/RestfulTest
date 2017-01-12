package com.samsung.restfultest;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "cuihj ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestfulTest();
    }

    private void RestfulTest() {
        Task task = new Task(1, "my task title");

        Gson gson = new Gson();
        String str = gson.toJson(task);
        Log.d(TAG, "RestfulTest: "+str);

        Call<Task> callCreateTask = ApiClient.get().createTask(task);
        callCreateTask.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                Log.d(TAG, "onResponse: ");
//                try {
//                    Log.d(TAG, "callCreateTask onResponse: "+response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onFailure(Call<Task> call, Throwable throwable) {

                Log.d(TAG, "callCreateTask onFailure: "+ throwable.getMessage());
            }
        });

        Call<ResponseBody> callWelcome = ApiClient.get().getWelcome();
        callWelcome.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d(TAG, "callWelcome onResponse: "+ response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "callWelcome onFailure: "+ t.getMessage());
            }

        });
    }
}
