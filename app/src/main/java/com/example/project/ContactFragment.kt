package com.example.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class ContactFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val rv: RecyclerView = view.findViewById(R.id.contact_list)
//        rv.layoutManager = LinearLayoutManager(this.context)
//
//        val button = view.findViewById<Button>(R.id.btn_read_contact)
//        button.setOnClickListener{
//           val contactList : MutableList<ContactDTO> = ArrayList()
//            val contacts = ContentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,0,null)
//            while (contacts.moveToNext()) {
//                val name = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
//                val number = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
//                val obj = ContactDTO()
//                obj.name = name
//                obj.number = number
//
//                contactList.add(obj)
//            }
//            rv.adapter = ContactAdapter(contactList,this)
//            contacts.close()
//        }
    }

//    class ContactAdapter(items: List<ContactDTO>, ctx: ContactFragment) : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){
//
//        private var list = items
//        private var context = ctx
//
//        override fun getItemCount(): Int {
//            return list.size
//        }
//
//        override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
//            holder.name.text = list[position].name
//            holder.number.text = list[position].number
//            if(list[position].image!=null){
//                holder.profile.setImageBitmap(list[position].image)
//            }
//            else
//                holder.profile.setImageDrawable(context.context?.let { ContextCompat.getDrawable(it,R.mipmap.ic_launcher) })
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//            return ViewHolder(LayoutInflater.from(context.context).inflate(R.layout.contact_child,parent,false))
//        }
//
//
//        class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
//            val name = v.findViewById<TextView>(R.id.tv_name)!!
//            val number = v.findViewById<TextView>(R.id.tv_number)!!
//            val profile = v.findViewById<ImageView>(R.id.iv_profile)!!
//        }
//
//    }


}

