package com.example.tarpapp

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_cell.view.*
import android.support.v4.content.ContextCompat.startActivity
import android.R.id
import kotlin.coroutines.coroutineContext


class ForumAdapter(var context: Context): RecyclerView.Adapter<CustomCategoryViewHolder>(){

    private val posts = ArrayList<String>()
    private val postIds = ArrayList<Int>()

    init {
        getposts()
    }

    private fun getposts() {
        val db = DataBase(context)
        var results = db.readPosts()
        if (results != null)
            for (res in results) posts.add(res)

        var ids = db.readPostIds()
        if (ids != null)
            for (res in ids) postIds.add(res)
    }

    //number of items
    override fun getItemCount(): Int{
        return posts.size
    }

    override fun onBindViewHolder(holder: CustomCategoryViewHolder, position: Int) {
        val category = posts[position]
        holder.view.forum_post?.text = category
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomCategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.activity_list_cell,parent,false)

        val holder = CustomCategoryViewHolder(cellForRow)
        val viewGroup = cellForRow as ViewGroup
        val card = viewGroup.getChildAt(0)

        card.setOnClickListener {
            val pos = holder.adapterPosition
            val id = postIds[pos]
            val intent = Intent(this.context, forum2::class.java)
            intent.putExtra("postID", id)
            context.startActivity(intent)

        }

        return holder
    }
}

class CustomCategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val context = view.context

}
