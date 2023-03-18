package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParameterBorough extends AppCompatActivity {
    ArrayList<String> dataBorough = new ArrayList<String>();
    ArrayList<String> url = new ArrayList<String>();
    ListView lstBorough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criterio_barrios);

        lstBorough = (ListView) findViewById(R.id.lstBarrios);

        String barrio = getIntent().getStringExtra("borough");

        getDataByName(barrio);
    }

    private void getDataByName(String id) {
        String myUrl = "http://YOUR_LOCALHOST:8000/posts/findByBorough/"+id;
        dataBorough.clear();

        JsonArrayRequest myRequest = new JsonArrayRequest(Request.Method.GET, myUrl, null, new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response) {
                if(response.length() > 0){
                    for(int i=0; i<response.length();i++){
                        try {
                            JSONObject myJsonObject = response.getJSONObject(i);
                            JSONObject dirObject = myJsonObject.getJSONObject("address");

                            Adress dir = new Adress();
                            Restaurant r = new Restaurant();
                            r.setId(myJsonObject.get("_id").toString());

                            dir.setBuidings(dirObject.get("building").toString());
                            dir.setStreet(dirObject.get("street").toString());
                            dir.setZipcode(dirObject.get("zipcode").toString());

                            r.setAdress(dir);

                            r.setBorough(myJsonObject.get("borough").toString());
                            r.setName(myJsonObject.get("name").toString());
                            r.setCuisine(myJsonObject.get("cuisine").toString());
                            r.setRestaurant_id(myJsonObject.get("restaurant_id").toString());


                            String contenido = new String(r.getId() + "\n" + r.getAdress().getStreet()+ "\n" + r.getBorough() + "\n"  + r.getCuisine() + "\n" + r.getGrades() + "\n" + r.getName() + "\n" + r.getRestaurant_id());

                            dataBorough.add(contenido);


                            Myadapter myadapter = new Myadapter(url, getApplicationContext(), R.layout.sitios, dataBorough);
                            lstBorough.setAdapter(myadapter);
                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "¡Borough not found!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                try {
                    throw error;
                } catch (VolleyError e) {
                    if (e.networkResponse != null && e.networkResponse.statusCode == 404) {
                        Toast.makeText(getApplicationContext(), "¡Borough not found!", Toast.LENGTH_SHORT).show();
                    } else {
                        System.out.println(e);
                    }
                }
            }
        }
        );


        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(myRequest);
    }
}