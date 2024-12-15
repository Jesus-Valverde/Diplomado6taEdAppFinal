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

        String url = "https://www.rmgserver.net/diplomado";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, response -> {
                    try {

                        JSONArray jsonArray = response.getJSONArray("data" );
                        System.out.println("data " +jsonArray );


                        for(int i = 0; i< jsonArray.length(); i++) {

                            JSONObject jsonObject = jsonArray.getJSONObject(i );

                            String nombre = jsonObject.getString("nombre" );
                            String apellidos = jsonObject.getString("apellidos" );
                            String correo = jsonObject.getString("correo" );

                            System.out.println("name " +nombre );
                            System.out.println("email " +correo );
                            System.out.println("post " +apellidos );

                            Model model = new Model( );
                            model.setId(jsonObject.getString("id"));
                            model.setNombre(jsonObject.getString("nombre"));
                            model.setApellidos(jsonObject.getString("apellidos"));
                            model.setCorreo(jsonObject.getString("correo"));
                            model.setGrupo(jsonObject.getString("grupo"));
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