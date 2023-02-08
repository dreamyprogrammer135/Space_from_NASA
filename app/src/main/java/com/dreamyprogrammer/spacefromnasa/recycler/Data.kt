package com.dreamyprogrammer.spacefromnasa.recycler

data class Data(
    val someText: String = "Text",
    val someDescription: String? = "Description",
    val type: Int = TYPE_MARS
) {
    companion object {
        const val TYPE_EARTH = 1
        const val TYPE_MARS = 2
        const val TYPE_HEADER = 3
    }
}
