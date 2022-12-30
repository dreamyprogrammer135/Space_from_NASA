package com.dreamyprogrammer.spacefromnasa.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dreamyprogrammer.spacefromnasa.BuildConfig
import com.dreamyprogrammer.spacefromnasa.model.PictureOfTheDayResponseDate
import com.dreamyprogrammer.spacefromnasa.model.RepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>(),
    private val repositoryImpl: RepositoryImpl = RepositoryImpl()
) :
    ViewModel() {

    fun getLiveDate(): MutableLiveData<AppState> {
        //
        return liveData
    }

    fun sendRequest() {
        liveData.postValue(AppState.Loading)
        repositoryImpl.getPictureOfTheDayApi().getPictureOfTheDay(BuildConfig.NASA_APY_KEY)
            .enqueue(callback)
    }

    val callback = object : Callback<PictureOfTheDayResponseDate> {
        override fun onResponse(
            call: Call<PictureOfTheDayResponseDate>,
            response: Response<PictureOfTheDayResponseDate>
        ) {
            if (response.isSuccessful) {
                liveData.postValue(AppState.Success(response.body()!!))
            } else {
                liveData.postValue(AppState.Error(throw IllegalStateException("Error!!!")))
            }
        }

        override fun onFailure(call: Call<PictureOfTheDayResponseDate>, t: Throwable) {
            //TODO HW
        }
    }
}