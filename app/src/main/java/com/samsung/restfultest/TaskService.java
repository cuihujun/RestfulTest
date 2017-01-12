package com.samsung.restfultest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TaskService {
    //http://localhost:9000/JerseyWebapp/webapi/welcome
    @GET("/JerseyWebapp/webapi/welcome")
    Call<ResponseBody> getWelcome();


//    @Headers({
//            "Accept: application/json",
//            "Content-Type: application/json"
//    })
    @POST("/JerseyWebapp/webapi/analytics")
    Call<Task> createTask(@Body Task task);
}
