package com.features.growharvestnew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import com.features.growharvestnew.adapter.GridAdapter;
import com.features.growharvestnew.databinding.ActivityDataBarangBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityDataBarangBinding binding;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataBarangBinding.inflate(getLayoutInflater());
        searchView = findViewById(R.id.searchView);
        setContentView(binding.getRoot());
        String[] flowerName = {"Bibit 1","Bibit 2","Bibit 3","Bibit 4","Bibit 5","Bibit 6"};
        int[] flowerImages = {R.drawable.adv777ruby,R.drawable.inpago12,R.drawable.inpari32,R.drawable.simetalbisi321,R.drawable.pupuk1,R.drawable.pupuk2};

        GridAdapter gridAdapter = new GridAdapter(MainActivity.this,flowerName,flowerImages);
        binding.gridView.setAdapter(gridAdapter);


        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,"You Clicked on "+ flowerName[position],Toast.LENGTH_SHORT).show();

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<DataBarangMain> filteredList = new ArrayList<>();
                for (DataBarangMain barang : listBarang) {
                    if (barang.getNamaBarang().toLowerCase().contains(newText.toLowerCase())) {
                        filteredList.add(barang);
            }
        });
    }
}