package com.example.diplomado6taedappfinal;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private RequestQueue requestQueue;
    private final Context ctx;
    private MySingleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }
    public static synchronized MySingleton getInstance(Context context) {
        MySingleton instance = null;
        instance = new MySingleton(context);
        return instance;
    }
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
