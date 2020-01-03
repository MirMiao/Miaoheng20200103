package com.bw.miaoheng20200103.api;

import com.bw.miaoheng20200103.entity.DataEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 时间 :2020/1/3  8:49
 * 作者 :苗恒
 * 功能 :
 */
public interface DataApiService {
    @GET(Api.DATA_URL)
    Call<DataEntity> getData();
}
