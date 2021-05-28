package com.example.p

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.project.R

private const val TAG_EVENT_DESC = "TAG_EVENT_DESC"

class DescriptionFragment : Fragment() {
    var title:String? = null
    var description: String? = null
    var picture:Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            title = bundle.getString("title")
            description = bundle.getString("context")
            picture = bundle.getInt("image")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val t = view.findViewById<TextView>(R.id.name)
        t.text = title
        val d = view.findViewById<TextView>(R.id.description)
        d.text = description
        val p = view.findViewById<ImageView>(R.id.poster)
        picture?.let { p.setImageResource(it) }
//        b = view.findViewById(R.id.description) as TextView
//        a = view.findViewById(R.id.name) as TextView
//        c = view.findViewById(R.id.poster) as ImageView
//
//        val bundle = arguments
//        if (bundle != null) {
//            val movie = bundle.getParcelable<Movie>(KEY_PARSE_DATA)
//            text_name!!.setText(movie.title)
//            text_desc!!.setText(movie.description)
//            image.setImageResourse(movie.picture)
//        }
//    return view
    }
}