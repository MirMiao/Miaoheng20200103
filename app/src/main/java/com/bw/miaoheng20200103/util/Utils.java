package com.bw.miaoheng20200103.util;

import com.bw.miaoheng20200103.api.Api;
import com.bw.miaoheng20200103.api.BanerApiService;
import com.bw.miaoheng20200103.api.DataApiService;
import com.bw.miaoheng20200103.entity.BanerEntity;
import com.bw.miaoheng20200103.entity.DataEntity;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间 :2020/1/3  8:45
 * 作者 :苗恒
 * 功能 :
 */
public class Utils {
    private static Utils utils;

    private Utils() {
    }

    public static Utils getInstance() {
        if(utils==null){
            synchronized (Utils.class){
                if(utils==null){
                    utils=new Utils();
                }
            }
        }
        return utils;
    }
    public void getData(final UtilsCallBack utilsCallBack){
        OkHttpClient okHttpClient=new OkHttpClient.Builder().build();
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .build();
        BanerApiService banerApiService = retrofit.create(BanerApiService.class);
        banerApiService.getBaner().enqueue(new Callback<BanerEntity>() {
            @Override
            public void onResponse(Call<BanerEntity> call, Response<BanerEntity> response) {
                 utilsCallBack.cuccess(response.body());
            }

            @Override
            public void onFailure(Call<BanerEntity> call, Throwable t) {

            }
        });

        DataApiService dataApiService = retrofit.create(DataApiService.class);
        dataApiService.getData().enqueue(new Callback<DataEntity>() {
            @Override
            public void onResponse(Call<DataEntity> call, Response<DataEntity> response) {
                utilsCallBack.cuccess(response.body());
            }

            @Override
            public void onFailure(Call<DataEntity> call, Throwable t) {

            }
        });
    }
    public interface UtilsCallBack{
        void cuccess(Object object);
    }
}
