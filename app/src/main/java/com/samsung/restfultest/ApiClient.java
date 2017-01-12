package com.samsung.restfultest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private static TaskService REST_CLIENT;
    private static final String API_URL = "http://192.168.1.234:9000";

    private ApiClient() {
    }

    public static TaskService get() {
        return REST_CLIENT;
    }

    static {
        setupRestClient();
    }
    private static void setupRestClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        REST_CLIENT = retrofit.create(TaskService.class);
    }

}
