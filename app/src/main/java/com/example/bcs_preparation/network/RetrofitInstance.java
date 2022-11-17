package com.example.bcs_preparation.network;

import android.util.Log;

import com.example.bcs_preparation.utils.ConstantUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit;
    final static String BASE_URL = "https://job-solution.herokuapp.com/";


    public static OkHttpClient getRetrofitClient(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                if(ConstantUtils.AuthPreference.ACCESS_TOKEN.equals("")){
                    Log.e("responseTag", "intercept: 200" );

                    Request.Builder requestBuilder = original.newBuilder()
                            .addHeader("Content-Type","application/json")
                            .addHeader("Accept","application/json");
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }else {
                    Request.Builder requestBuilder = original.newBuilder()
                            .addHeader("Content-Type","application/json")
                            .addHeader("Accept","application/json")
                            .addHeader("Authorization","Bearer "+ConstantUtils.AuthPreference.ACCESS_TOKEN);
                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
                // Request customization: add request headers



            }
        });

        OkHttpClient client = httpClient.build();
        return client;
    }

    public static Retrofit getRetrofitInstance()  {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getRetrofitClient())
                    .build();
        }
        return retrofit;
    }
}
