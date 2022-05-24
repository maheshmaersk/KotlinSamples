package com.amvlabs.kotlinsamples.retrofitsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amvlabs.kotlinsamples.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.DelicateCoroutinesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URI

class ApiResponseActivity : AppCompatActivity() {

    var dataList = arrayListOf<Datum>()

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_response)

        val userImage: AppCompatImageView = findViewById(R.id.contactImage)
        val userId: AppCompatEditText = findViewById(R.id.enterId)
        val userName: AppCompatTextView = findViewById(R.id.contactName)
        val userEmail: AppCompatTextView = findViewById(R.id.contactEmail)


        val usersApi = RetrofitHelper.getInstance().create(UsersApi::class.java)
        // launching a new coroutine
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.usersList)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
//        recyclerview.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        recyclerview.layoutManager = GridLayoutManager(this,2)
//        GlobalScope.launch {
//            val result = usersApi.getUsers()
//            if (result != null) {
//                val userList = result.body();
//                var datum = userList?.data
//                datum?.let {
//                    dataList = it
//                }
//            }
//        }
        var apiInterface: ApiInterface =
            ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getUsersList().enqueue(object : Callback<UserList> {
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                var userData = response?.body()!!
                dataList = userData.data
                val adapter = UserAdapter(dataList)
                recyclerview.adapter = adapter
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
            }

        })


        findViewById<AppCompatButton>(R.id.getResult).setOnClickListener {

            var str = "/api/users/${userId.text.toString()}"
            apiInterface.getUsersDetails(str).enqueue(object : Callback<UserDetails> {
                override fun onResponse(call: Call<UserDetails>, response: Response<UserDetails>) {
                    var userData = response?.body()!!
                    Picasso.get().load(userData.data.avatar)
                        .placeholder(R.drawable.ic_movie_placeholder)
                        .error(R.drawable.ic_movie_error).into(userImage);
                    // sets the text to the textview from our itemHolder class
                    userName.text = userData.data.firstName
                    userEmail.text = userData.data.email
                }

                override fun onFailure(call: Call<UserDetails>, t: Throwable) {
                }

            })
        }
    }
}