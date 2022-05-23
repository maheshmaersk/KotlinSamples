package com.amvlabs.kotlinsamples.retrofitsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amvlabs.kotlinsamples.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ApiResponseActivity : AppCompatActivity() {

    var dataList = arrayListOf<Datum>()

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_response)


        val usersApi = RetrofitHelper.getInstance().create(UsersApi::class.java)
        // launching a new coroutine
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.usersList)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        GlobalScope.launch {
            val result = usersApi.getUsers()
            if (result != null) {
                val userList = result.body();
                var datum = userList?.data
                datum?.let {
                    dataList = it
                }
            }
        }

        val adapter = UserAdapter(dataList)
        recyclerview.adapter = adapter
    }
}