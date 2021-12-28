package com.kutuphane.izmirkutuphaneler.service

import com.kutuphane.izmirkutuphaneler.model.LibraryListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LibraryAPI {
    companion object {
        const val LIBRARYIES = "ibb/cbs/kutuphaneler"
    }
        //gameType/10 -> Path
        //gameType?=1 -> Query

        // {
        // gameType: 1 -> Body
        // }


         @GET(LIBRARYIES)
         fun getLibraryInfo() : Single<LibraryListResponse>



}