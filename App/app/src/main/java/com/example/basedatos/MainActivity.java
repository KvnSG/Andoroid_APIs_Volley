package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {
    private Button btnBorough;
    private Button btnFood;
    private EditText boroughTxt, foodTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnFood = (Button) findViewById(R.id.cocina);
        btnBorough = (Button) findViewById(R.id.button);
        boroughTxt = (EditText) findViewById(R.id.text);
        foodTxt = (EditText) findViewById(R.id.txtComida);

        btnBorough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button:
                        String texto = boroughTxt.getText().toString();

                        Intent ingresoActivity = new Intent(getApplicationContext(), ParameterBorough.class);
                        ingresoActivity.putExtra("borough", texto);
                        startActivity(ingresoActivity);
                }
            }
        });

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.cocina:
                        String texto = foodTxt.getText().toString();
                        Intent ingresoActivity = new Intent(getApplicationContext(), ParameterFood.class);
                        ingresoActivity.putExtra("food", texto);
                        startActivity(ingresoActivity);

                }
            }
        });

    }
}