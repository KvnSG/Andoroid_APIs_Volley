package com.example.basedatos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Myadapter extends BaseAdapter {
    private ArrayList<String> url;
    private Context context;
    private int layout;
    private ArrayList<String> datos;


    public Myadapter(ArrayList<String> url, Context context, int layout, ArrayList<String> datos) {
        this.url = url;
        this.context = context;
        this.layout = layout;
        this.datos = datos;
    }

    @Override
    public int getCount() {
        return this.datos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.datos.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        Button actualizar;

        View v = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.sitios, null);

        String currentName = datos.get(position);

        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(currentName);


        actualizar = (Button) v.findViewById(R.id.botonActualizar);
        actualizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((ListView) viewGroup).performItemClick(v, position, 0);
                deleteById(v,currentName);
            }
        });

        return v;

    }

    private void deleteById(View v,String info) {

        Intent infoPersona = new Intent(v.getContext(), Information.class);
        infoPersona.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        infoPersona.putExtra("restaurant", info);
        v.getContext().startActivity(infoPersona);

    }

}
