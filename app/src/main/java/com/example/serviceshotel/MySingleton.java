package com.example.serviceshotel;

import android.content.Context;
//import android.net.http.RequestQueue;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.RequestQueue;


import java.util.Collection;


public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue mRequestQueue;
    private Context mCtx;

    public MySingleton(Context mCtx) {
        this.mCtx = mCtx;
        mRequestQueue = getmRequestQueue();

    }


    public RequestQueue getmRequestQueue(){


        if(mRequestQueue == null){
            Cache cache = new DiskBasedCache(mCtx.getCacheDir(),1024*1024);
            Network network = new BasicNetwork(new HurlStack());
             mRequestQueue = new RequestQueue(cache, network);
           //mRquestQueue = new RequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

     static synchronized MySingleton getmInstance(Context context){

        if (mInstance == null){
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }


    public<T> void addToRequestQueue(Request<T> request) {

        mRequestQueue.add(request);
    }



}