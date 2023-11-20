package com.features.growharvestnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.features.growharvestnew.adapter.DataBarangAdapter;
import com.features.growharvestnew.adapter.GridAdapter;
import com.features.growharvestnew.databinding.ActivityDataBarangBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataBarangActivity extends AppCompatActivity {

    String apiUrl = "https://rickandmortyapi.com/api/character";
    ArrayList<DataBarangMain> dataBarangMains;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_barang);
        dataBarangMains = new ArrayList<>();
        gridView = findViewById(R.id.gridView);
        fentchData();
       }
       public void parseJSON(String response){
           try {
               JSONArray jsonArray = new JSONArray(response);
               for (int i = 0; i < jsonArray.length(); i++ ){
                   JSONObject object = jsonArray.getJSONObject(i);
                   String name = object.getString("name");
                   String image = object.getString("img");
                    dataBarangMains.add(new DataBarangMain(name, image));
               }
               DataBarangAdapter adapter = new DataBarangAdapter(getApplicationContext(), dataBarangMains);
               gridView.setAdapter(adapter);
           } catch (JSONException e) {
               throw new RuntimeException(e);
           }
       }
       public void fentchData(){
           RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
           StringRequest stringRequest = new StringRequest(Request.Method.GET, apiUrl, new Response.Listener<String>() {
               @Override
               public void onResponse(String response) {
                    parseJSON(response);
               }
           }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
               }
           });
           requestQueue.add(stringRequest);
       }
}