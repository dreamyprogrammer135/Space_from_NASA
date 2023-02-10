package com.dreamyprogrammer.spacefromnasa.viewmodel

import com.dreamyprogrammer.spacefromnasa.model.PictureOfTheDayResponseDate

sealed class AppState {
    data class Success(val pictureOfTheDayResponseDate: PictureOfTheDayResponseDate) : AppState()

    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()

}