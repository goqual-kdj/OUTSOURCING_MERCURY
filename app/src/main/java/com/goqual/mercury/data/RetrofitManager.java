package com.goqual.mercury.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.goqual.mercury.util.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ladmusician on 2/23/16.
 */
public class RetrofitManager {
    private static final String BASE_URL = Constant.BASE_URL;
    private static Retrofit mRetrofit = null;

    public static Retrofit getRetrofitBuilder() {
        if (mRetrofit == null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }

        return mRetrofit;
    }
}
