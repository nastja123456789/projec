package service

import android.content.Context
import android.content.SharedPreferences
import android.widget.ImageView

class NewEventService(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        SharedPrefConstans.NAME,
        Context.MODE_PRIVATE
    )

    var eventName: String? = null
    var eventDescription: String? = null
    var eventImage: Int? = null
        private set

    init {
        loadData()
    }

    fun saveEvenName(newName: String) {
        eventName = newName
        sharedPreferences
            .edit()
            .putString(SharedPrefConstans.NAME_OF_EVENT, newName)
            .apply()
    }

    fun saveEvenDescr(newDescr: String) {
        eventDescription = newDescr
        sharedPreferences
            .edit()
            .putString(SharedPrefConstans.EVENT_DESCR, newDescr)
            .apply()
    }

    fun saveEvenImage(newImage: Int) {
        eventImage = newImage
        sharedPreferences
            .edit()
            .putInt(SharedPrefConstans.EVENT_IMAGE, newImage)
            .apply()
    }

    private fun loadData(){
        eventName =
            if(sharedPreferences.contains(SharedPrefConstans.NAME_OF_EVENT))
                sharedPreferences.getString(SharedPrefConstans.NAME_OF_EVENT, null)
            else
                null

        eventDescription =
            if(sharedPreferences.contains(SharedPrefConstans.EVENT_DESCR))
                sharedPreferences.getString(SharedPrefConstans.EVENT_DESCR, null)
            else
                null

        eventImage =
            if(sharedPreferences.contains(SharedPrefConstans.EVENT_IMAGE))
                sharedPreferences.getInt(SharedPrefConstans.EVENT_IMAGE, 0)
            else
                null
    }
}