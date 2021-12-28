package com.kutuphane.izmirkutuphaneler.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kutuphane.izmirkutuphaneler.model.LibraryListResponse
import com.kutuphane.izmirkutuphaneler.service.LibraryAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class LibraryListViewModel : ViewModel(){

    private var libraryAPIService = LibraryAPIService()

    val libraryListLiveData: MutableLiveData<LibraryListResponse> = MutableLiveData<LibraryListResponse>()

    @SuppressLint("CheckResult")
    fun getLibraryList(){
        libraryAPIService.getLibraryInfoList().subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<LibraryListResponse>() {
                override fun onSuccess(response: LibraryListResponse) {
                    libraryListLiveData.value = response
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
    }

}