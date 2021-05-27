package com.example.project

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
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


private const val TIT = "param1"
private const val DES = "param2"
private const val PIC = "param3"
@Suppress("UNREACHABLE_CODE")
class NewEventFragment : Fragment() {
    private val REQUEST_TAKE_PHOTO = 1

    private lateinit var imageView: ImageView

    var title_new:String? = null
    var description_new: String? = null
    var picture_new:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        val des:EditText = view.findViewById(R.id.desc_new)
       val tit:EditText = view.findViewById(R.id.title_new)
       val image:ImageView = view.findViewById(R.id.imageView2)
        val button: Button = view.findViewById(R.id.button)
        button.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
            } catch (e: ActivityNotFoundException) {
                e.printStackTrace()
            }
        }
val event: Button = view.findViewById(R.id.new_event)
        event.setOnClickListener{
//               val i = Intent(itemView.context, EventLogTags.Description::class.java).apply {
//                    putExtra("title", tvName.text.toString())
//                    putExtra("context",tvDes.text.toString())
//                    putExtra("image",movie.picture)
//                }

                //    itemView.context.startActivity(i)


                val EventScreenFragment = EventScreenFragment()
//                val bundle = Bundle()
//                bundle.putString("title_new", tit.text.toString())
//                bundle.putString("context_new", des.text.toString())
////                image?.let { it1 -> bundle.putInt("image_new", it1.) }
//            bundle.putInt("image_new",image.id)
//                EventScreenFragment.arguments = bundle
//                makeCurrentFragmentInMainWindow(EventScreenFragment, "eventFragment")
            Log.d("title_new1",tit.text.toString())
            Log.d("description_new1",des.text.toString())
            Log.d("picture_new1",image.id.toString())
        }

//        arguments?.let {
//            title_new = it.getString(TIT)
//            description_new = it.getString(DES)
//            picture_new = it.getInt(PIC)
//        }

    }
    private fun makeCurrentFragmentInMainWindow(fragment: Fragment, name: String) {
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.main_fragmnet, fragment)
            addToBackStack(name.toString())

            commit()
        }


    }





    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            // Фотка сделана, извлекаем миниатюру картинки
            val thumbnailBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(thumbnailBitmap)
        }

        // Другой вариант с применением when
        when (requestCode) {
            REQUEST_TAKE_PHOTO -> {
                if (resultCode == Activity.RESULT_OK && data !== null) {
                    imageView.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
//            else -> Toast.makeText(this,"Wrong code",Toast.LENGTH_SHORT).show()
        }
    }
//    companion object {
//        @JvmStatic
//        fun newInstance(title_new:String, description_new: String, picture_new: Int) =
//            EventScreenFragment().apply {
//                arguments = Bundle().apply {
//                    putString(TIT, title_new)
//                    putString(DES, description_new)
//                    putInt(PIC, picture_new)
//                }
//            }
//    }


}

