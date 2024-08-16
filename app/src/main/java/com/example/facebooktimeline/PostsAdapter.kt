package com.example.facebooktimeline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facebooktimeline.model.Post

class PostsAdapter(var postsList: List<Post>) : RecyclerView.Adapter<PostsAdapter.MyViewHolder>() {

    class MyViewHolder(postView: View) : RecyclerView.ViewHolder(postView) {
        val profileImageView: ImageView = postView.findViewById(R.id.profile_img)
        val postImageView: ImageView = postView.findViewById(R.id.image_post)
        val profileName: TextView = postView.findViewById(R.id.page_name)
        val date: TextView = postView.findViewById(R.id.hour_ago)
        val postContent: TextView = postView.findViewById(R.id.content_text)

        fun bind(post: Post) {
            profileImageView.setImageResource(post.author.profileImage)
            postImageView.setImageResource(post.image)
            profileName.text = post.author.name
            date.text = post.date
            postContent.text = post.content


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val postView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return MyViewHolder(postView)
    }

    override fun getItemCount(): Int = postsList.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = postsList[position]
        holder.bind(post)
    }
}