package com.kutuphane.izmirkutuphaneler.service

import com.kutuphane.izmirkutuphaneler.model.LibraryListResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LibraryAPIService {

    val BASE_URL = "https://openapi.izmir.bel.tr/api/"

    val retrofitapi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(LibraryAPI::class.java)

    fun getLibraryInfoList() : Single<LibraryListResponse>{
        return retrofitapi.getLibraryInfo()
    }
}