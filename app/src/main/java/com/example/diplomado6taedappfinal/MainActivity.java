package com.example.diplomado6taedappfinal;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Nuevos imports
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// import com.github.bumptech.Glide;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    ArrayList<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        models = new ArrayList<>();

        String url = "http://192.168.10.15:3000/buscarComic/thor";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, response -> {
                    try {

                        JSONArray jsonArray = response.getJSONArray("comics" );
                        System.out.println("comics " +jsonArray );


                        for(int i = 0; i< jsonArray.length(); i++) {

                            JSONObject jsonObject = jsonArray.getJSONObject(i );

                            String id = jsonObject.getString("id" );
                            String issueNumber = jsonObject.getString("issueNumber" );
                            String onSaleDate = jsonObject.getString("onSaleDate" );
                            String pageCount = jsonObject.getString("pageCount" );
                            String title = jsonObject.getString("title" );

                            System.out.println("id " +id );
                            System.out.println("issueNumber " +issueNumber );
                            System.out.println("onSaleDate " +onSaleDate );
                            System.out.println("pageCount " +pageCount );
                            System.out.println("title " +title );

                            Model model = new Model( );
                            model.setId(jsonObject.getString("id"));
                            model.setIssueNumber(jsonObject.getString("issueNumber"));
                            model.setOnSaleDate(jsonObject.getString("onSaleDate"));
                            model.setPageCount(jsonObject.getString("pageCount"));
                            model.setTitle(jsonObject.getString("title"));
                            models.add(model);
                        }

                        mainAdapter = new MainAdapter(MainActivity.this, models);

                        recyclerView.setAdapter(mainAdapter);




                    } catch (Exception e) {
                        e.printStackTrace( );
                    }                    }, error -> {
                    // TODO: Handle error
                });
        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this.getApplicationContext()).addToRequestQueue(jsonObjectRequest);



    }
}