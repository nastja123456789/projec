package com.example.project

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.app.Service
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.p.EventScreenFragment
import service.NewEventService
import kotlin.concurrent.fixedRateTimer

private const val TAG_NEW_EVENT = "TAG_NEW_EVENT"

class NewEventFragment : Fragment() {
    lateinit var newEventService: NewEventService

    override fun onAttach(context: Context) {
        super.onAttach(context)
        newEventService = NewEventService(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val des: EditText = view.findViewById(R.id.desc_new)
        val tit: EditText = view.findViewById(R.id.title_new)
        val image: ImageView = view.findViewById(R.id.imageView2)

        val event: Button = view.findViewById(R.id.new_event)
        event.setOnClickListener {
            newEventService.saveEvenName(tit.text.toString())
            newEventService.saveEvenDescr(des.text.toString())
            newEventService.saveEvenImage(image.id)
            fragmentManager?.popBackStack()
        }

    }

}

