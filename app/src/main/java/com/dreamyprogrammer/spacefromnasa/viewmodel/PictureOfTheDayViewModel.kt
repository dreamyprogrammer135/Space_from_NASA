package com.dreamyprogrammer.spacefromnasa.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dreamyprogrammer.spacefromnasa.BuildConfig
import com.dreamyprogrammer.spacefromnasa.model.PictureOfTheDayResponseDate
import com.dreamyprogrammer.spacefromnasa.model.RepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class PictureOfTheDayViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData<AppState>(),
    private val repositoryImpl: RepositoryImpl = RepositoryImpl()
) :
    ViewModel() {

    fun getLiveDate(): MutableLiveData<AppState> {
        //
        return liveData
    }

    fun sendRequest(dateApi: Int) {
        liveData.postValue(AppState.Loading)
//        var df = SimpleDateFormat("yyyy-MM-DD")
        var calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1)
        var formatter = SimpleDateFormat("yyyy-MM-dd")
        var formattedDate = formatter.format(calendar.getTime());

        if (dateApi == 1) {
            repositoryImpl.getPictureOfTheDayApi().getPictureOfTheDay(BuildConfig.NASA_APY_KEY)
                .enqueue(callback)
        } else if (dateApi == 2)
            repositoryImpl.getPictureOfTheDayApi()
                .getPictureOfTheDayByDate(BuildConfig.NASA_APY_KEY, formattedDate).enqueue(callback)
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