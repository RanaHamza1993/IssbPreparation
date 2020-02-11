package com.bilalandcompany.issbpreparation.kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle

class ActivityNavigator<T>{
    constructor(from: Context, to:Class<T>){
        val intent= Intent(from,to)
        from.startActivity(intent)

    }
    constructor(from: Context, to: Class<T>, extra: Bundle) {
        val intent = Intent(from, to)
        intent.putExtra("bundle", extra)
        from.startActivity(intent)
    }

}