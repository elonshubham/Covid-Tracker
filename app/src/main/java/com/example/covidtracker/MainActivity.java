package com.example.covidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaSync;
import android.os.Bundle;
import android.view.Menu;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String url="https://api.covid19india.org/data.json";
    ArrayList<Covidresult> mArraylist;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mArraylist=new ArrayList<>();

        RequestQueue mrequestqueue= Volley.newRequestQueue(this);

        JsonObjectRequest mjsonobjectrequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray mjsonarray=response.getJSONArray("statewise");

                    for(int i=0; i<mjsonarray.length();i++){
                        JSONObject mjsonobject= mjsonarray.getJSONObject(i);
                        String jstatename=mjsonobject.getString("state");
                        int jtotalcases= mjsonobject.getInt("confirmed");
                        int jtotaldeaths= mjsonobject.getInt("deaths");
                        int jrecovered= mjsonobject.getInt("recovered");
                        mArraylist.add(new Covidresult(jstatename,jtotalcases,jtotaldeaths,jrecovered));
                    }

                    RecyclerView.Adapter adapter = new RecyclerAdapter(mArraylist,MainActivity.this);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mrequestqueue.add(mjsonobjectrequest);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }
}