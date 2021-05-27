package com.example.p

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


class EventScreenFragment : Fragment() {
    var title_new:String? = null
    var description_new: String? = null
    var picture_new:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            title_new = bundle.getString("title_new")
            description_new = bundle.getString("context_new")
            picture_new = bundle.getInt("image_new")
        }
        Log.d("title_new",title_new.toString())
        Log.d("description_new",description_new.toString())
        Log.d("picture_new",picture_new.toString())
    }

   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_screen, container, false)
    }

    // override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
     //   super.onViewCreated(view, savedInstanceState)
     //   var orientation = RecyclerView.VERTICAL
//        var spanCount = 1

  //      val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewFinishWork)
    //    val layoutManager = GridLayoutManager(requireContext(), spanCount, orientation, false)


    //}


    private val movies = generateMovieList().toMutableList()
    var adapter:MovieAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv_movie_list: RecyclerView = view.findViewById(R.id.recyclerViewFinishWork)
        adapter = fragmentManager?.let { MovieAdapter(movies, it) }
        rv_movie_list.adapter = adapter
        rv_movie_list.layoutManager = LinearLayoutManager(this.context)
        val hello: FloatingActionButton = view.findViewById(R.id.hello)
        //val hello = view?.findViewById<MaterialButton>(R.id.hello)
        hello.setOnClickListener {
            //     onClick()
            val newEventFragment = NewEventFragment()
            val bundle = Bundle()
            newEventFragment.arguments = bundle
            makeCurrentFragmentInMainWindow(newEventFragment, "descriptionFragment")
        }
//        val t = view.findViewById<TextView>(R.id.name)
//        t.text = title_new
//        val d = view.findViewById<TextView>(R.id.description)
//        d.text = description_new
//        val p = view.findViewById<ImageView>(R.id.poster)
//        picture_new?.let { p.setImageResource(it) }
//        movies.add(
//                Movie(
//                        "title_new",
//                "context_new"
//                )
//        )
//        adapter?.notifyDataSetChanged()
//                //        onClick()
//   }

//
//    fun onClick() {
//        movies.add(
//            Movie(
//                "title_new",
//                "context_new",
//                R.drawable.foto
//            )
//        )
//        adapter?.notifyDataSetChanged()
//    }

//    fun onClick() {
//        val bundle = arguments
//        bundle?.getString("description_new")?.let {
//            Movie(
//                    title = bundle?.getString("title_new")!!,
//                    description = it,
//                    picture = bundle?.getInt("image_new")
//            )
//        }?.let {
//            movies.add(
//                    it
//        )
//        }
//        adapter?.notifyDataSetChanged()
//    }
    }
        fun generateMovieList(): List<Movie> {
            return listOf(
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
