package com.example.facebooktimeline

import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.facebooktimeline.databinding.ActivityFacebookTimeLineBinding
import com.example.facebooktimeline.model.Post
import com.example.facebooktimeline.model.User
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FacebookTimeLineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFacebookTimeLineBinding
    private val posts = mutableListOf<Post>()
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFacebookTimeLineBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecycleView()
    }

    private fun initRecycleView() {
        createPostsList()
        postsAdapter = PostsAdapter(posts)
        binding.rvPosts.apply {
            adapter = postsAdapter
            layoutManager = LinearLayoutManager(this@FacebookTimeLineActivity)

        }

    }

    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time


    }

    private fun createPostsList() {
        for (i in 1..10) {
            posts.add(
                Post(
                    author = User("mohamed", R.drawable.car),
                    date = getCurrentDateTime().toString("yyyy/MMM/dd hh:mm a"),
                    content = "Hello",
                    image = R.drawable.route_logo
                )
            )
            posts.add(
                Post(
                    author = User("ahmed", R.drawable.car),
                    date = getCurrentDateTime().toString("yyyy/MMM/dd hh:mm a"),
                    content = "Hello",
                    image = R.drawable.img_public
                )
            )
            posts.add(
                Post(
                    author = User("mostafa", R.drawable.car),
                    date = getCurrentDateTime().toString("yyyy/MMM/dd hh:mm a"),
                    content = "Hello",
                    image = R.drawable.img_public
                )
            )
        }
    }


}

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formater = SimpleDateFormat(format, locale)
    return formater.format(this)

}