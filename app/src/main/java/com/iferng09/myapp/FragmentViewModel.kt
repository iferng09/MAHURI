package com.iferng09.myapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel(){
    val data = MutableLiveData<Connection>()

    fun setData(newConnection: Connection){
        data.value = newConnection
    }
}