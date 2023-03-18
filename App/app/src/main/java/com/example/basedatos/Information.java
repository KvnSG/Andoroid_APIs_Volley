package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Information extends AppCompatActivity {

    private String info;
    private EditText txtID, txtAddress, txtborough, txtCuisine, txtGrades, txtName;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        delete = (Button) findViewById(R.id.eliminar);

        txtID = (EditText) findViewById(R.id.id);
        txtAddress = (EditText) findViewById(R.id.address);
        txtborough = (EditText) findViewById(R.id.borough);
        txtCuisine = (EditText) findViewById(R.id.cuisine);
        txtGrades = (EditText) findViewById(R.id.grades);
        txtName = (EditText) findViewById(R.id.name);

        info = getIntent().getStringExtra("restaurant");
        String[] lines = info.split("\\R");
        txtID.setText(lines[0]);
        txtAddress.setText(lines[1]);
        txtborough.setText(lines[2]);
        txtCuisine.setText(lines[3]);
        txtGrades.setText(lines[4]);
        txtName.setText(lines[5]);

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getDeleteByID(lines[0]);
                Intent inicio = new Intent(getApplicationContext(),MainActivity.class);
                v.getContext().startActivity(inicio);
            }
        });


    }

    private void getDeleteByID(String id) {

        String myUrl = "http://YOUR_LOCALHOST:8000/posts/"+id;

        StringRequest myRequest = new StringRequest(Request.Method.DELETE, myUrl,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Information.this, "Deleted!", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                //Toast.makeText(MainActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("error");
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(myRequest);
    }


}