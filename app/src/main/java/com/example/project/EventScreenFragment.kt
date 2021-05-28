package com.example.p

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.NewEventFragment
import com.example.project.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import service.NewEventService

private const val TAG_EVENT = "TAG_EVENT"

class EventScreenFragment : Fragment() {
    private val movies = generateMovieList()
    var adapter: MovieAdapter? = null
    lateinit var newEventService: NewEventService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_screen, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        newEventService = NewEventService(context)
//        checkService()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newEventService = context?.let { NewEventService(it) }!!
        checkService()
        initAdapter(view)
        setOnClick(view)
    }

    private fun initAdapter(view: View) {
        val rv_movie_list: RecyclerView = view.findViewById(R.id.recyclerViewFinishWork)
        adapter = fragmentManager?.let { MovieAdapter(movies, it) }
        rv_movie_list.adapter = adapter
        rv_movie_list.layoutManager = LinearLayoutManager(this.context)

    }

    private fun setOnClick(view: View) {
        val hello: FloatingActionButton = view.findViewById(R.id.hello)
        hello.setOnClickListener {
            val newEventFragment = NewEventFragment()
            makeCurrentFragmentInMainWindow(newEventFragment, "newEventFragment")
        }
    }

    private fun checkService() {
        Log.d(TAG_EVENT, newEventService.eventName.toString())
        Log.d(TAG_EVENT, newEventService.eventDescription.toString())
        Log.d(TAG_EVENT, newEventService.eventImage.toString())

        //Вот это костыль, придумать как поменять
        if(newEventService.eventName != null && newEventService.eventName != "" &&
            newEventService.eventDescription != null && newEventService.eventDescription != "" &&
            newEventService.eventImage != null && newEventService.eventImage != 0 ) {
            movies.add(
                Movie(
                    newEventService.eventName!!,
                    newEventService.eventDescription!!,
                    R.drawable.foto1 //Сюда добавите нужную фотку
                )
            )
        }
        newEventService.saveEvenName("")
        newEventService.saveEvenDescr("")
        newEventService.saveEvenImage(0)
    }

    private fun generateMovieList(): ArrayList<Movie> {
        return arrayListOf(
            Movie(
                "Погнали в бар",
                "В 2:00 собираемся около главного входа в..",
                R.drawable.foto1
            ),
            Movie(
                "Давно не виделись",
                "Желательно не опаздывать, ждать не будем!",
                R.drawable.foto3
            )
        )
    }


    private fun makeCurrentFragmentInMainWindow(fragment: Fragment, name: String) {
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.main_fragmnet, fragment)
            addToBackStack(name.toString())
            commit()
        }
    }
}
