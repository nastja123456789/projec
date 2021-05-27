package com.example.p

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.project.ContactFragment
import com.example.project.R


var currentFragMain: String? = null
var currentFragInMain: String? = null


class MainActivity : AppCompatActivity() {
    lateinit var loginScreenFragment: loginScreenFragment
    lateinit var mapScreenFragment:MapScreenFragment
    lateinit var aboutFragment:AboutFragment
    lateinit var eventScreenFragment: EventScreenFragment
    lateinit var contactFragment: ContactFragment
lateinit var descriptionFragment: DescriptionFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        loginScreenFragment = loginScreenFragment()
        mapScreenFragment = MapScreenFragment()
        aboutFragment = AboutFragment()
        eventScreenFragment = EventScreenFragment()
        descriptionFragment = DescriptionFragment()
        contactFragment = ContactFragment()
        currentFragMain = "loginScreenFragment"
        currentFragInMain = "MapScreenFragment"

//        if (savedInstanceState != null) {
//            currentFragInMain = savedInstanceState.getString("currentFragInMain")
//            currentFragMain = savedInstanceState.getString("currentFragMain")
//
//            if (savedInstanceState != null) {
//                currentFragInMain = savedInstanceState.getString("currentFragInMain")
//                currentFragMain = savedInstanceState.getString("currentFragMain")

                if (currentFragMain != null) {
                    when (currentFragMain) {
                        "loginScreenFragment" -> {
                            makeCurrentFragmentMainWindow(loginScreenFragment, "loginScreen")
                        }
                        "MainFragment" -> {
                            if (currentFragInMain != null) {
                                when (currentFragInMain) {
                                    "MapScreenFragment" -> {
                                        makeCurrentFragmentMainWindow(mapScreenFragment, "mainScreen")
                                        makeCurrentFragmentInMainWindow(
                                            mapScreenFragment,
                                            "MapScreen"
                                        )
                                    }
                                    "AboutFragment" -> {
                                        makeCurrentFragmentMainWindow(aboutFragment, "About")
                                        makeCurrentFragmentInMainWindow(
                                            aboutFragment,
                                            "About"
                                        )
                                    }
                                    "EventScreenFragment" -> {
                                        makeCurrentFragmentMainWindow(eventScreenFragment, "EventScreen")
                                        makeCurrentFragmentInMainWindow(
                                            eventScreenFragment,
                                            "EventScreen"
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }


      //  }
    //}

    private fun makeCurrentFragmentMainWindow(fragment: Fragment, name: String) {
        currentFragMain = name
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragmnet, fragment)
            addToBackStack(name.toString())
            commit()
        }
    }

    private fun makeCurrentFragmentInMainWindow(fragment: Fragment, name: String) {
        currentFragInMain = name
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragmnet, fragment)
            addToBackStack(name.toString())
            commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState?.run {
            putString("currentFragMain", currentFragMain)
            putString("currentFragInMain", currentFragInMain)
        }
        super.onSaveInstanceState(outState, outPersistentState)
    }

}
