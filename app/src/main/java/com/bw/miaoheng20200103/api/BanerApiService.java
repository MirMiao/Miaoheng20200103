package com.bw.miaoheng20200103.api;

import com.bw.miaoheng20200103.entity.BanerEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 时间 :2020/1/3  8:44
 * 作者 :苗恒
 * 功能 :
 */
public interface BanerApiService {
    @GET(Api.BANER_URL)
    Call<BanerEntity> getBaner();
}
