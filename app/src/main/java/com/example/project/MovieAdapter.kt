package com.example.p

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R

class MovieAdapter(val movies: List<Movie>, val fragmentManager: FragmentManager): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View, val fragmentManager: FragmentManager): RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.findViewById(R.id.movie_item_tv_name)
        val tvDes: TextView = itemView.findViewById(R.id.descriprion)
        val tvPoster: ImageView = itemView.findViewById(R.id.movie_item_poster)

        fun bind(movie:Movie) {
            tvName.text = movie.title
            tvDes.text = movie.description
            tvPoster.setImageResource(movie.picture)
            itemView.setOnClickListener() {
//               val i = Intent(itemView.context, EventLogTags.Description::class.java).apply {
//                    putExtra("title", tvName.text.toString())
//                    putExtra("context",tvDes.text.toString())
//                    putExtra("image",movie.picture)
//                }
//                       // title = editTextName!!.text.toString()
                //  description = editTextName!!.text.toString()
                //  picture.setImageResource(movie.picture)
            //    itemView.context.startActivity(i)

                val descriptionFragment = DescriptionFragment()
                val bundle = Bundle()
                bundle.putString("title", tvName.text.toString())
                bundle.putString("context", tvDes.text.toString())
                bundle.putInt("image", movie.picture)
                descriptionFragment.arguments = bundle
                makeCurrentFragmentInMainWindow(descriptionFragment, "descriptionFragment", fragmentManager)

            }


          //      val viewFragment = ViewFragment()
                //это пердача данных из фрагмента в фрагмнт, нашла в интернете, до этого было передала из фрагмента в активити, и работа сделана
                        //по лекции на котлин, там использовался Adapter, Moview и Description. А это в Adaptore, потому что я грубо
            // заменяла один код другим, не совсем поняла куда и как вставлять.  я сейчас раскомментила, но приложение ломается
                        // потому что я из фрагмента запускаю активити, а надо чтобы переходило в другой фрагмент или создавала(?)
 //               val bundle = Bundle()
//                bundle.putParcelable(KEY_PARSE_DATA, details)
//                viewFragment.setArguments(bundle)
//                val transaction = fragmentManager.beginTransaction()
//                transaction.replace(R.id.fragment_desctiption, viewFragment)
//                transaction.commit()
            }


            private fun makeCurrentFragmentInMainWindow(fragment: Fragment, name: String, fragmentManager : FragmentManager) {
                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.main_fragmnet, fragment)
                    addToBackStack(name.toString())
                    commit()
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view, fragmentManager )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }


}
