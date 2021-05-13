package com.example.listview;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemsAdapter itemsAdapter;
    private ArrayList<Items> itemsArrayList;
    private TypedArray itemsThumbnailsTypedArray;
    private TypedArray itemsImagesTypedArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemsArrayList = new ArrayList<>();

        itemsAdapter = new ItemsAdapter(this, itemsArrayList);
        recyclerView.setAdapter(itemsAdapter);

        initializeData();
    }

    public void initializeData(){
        String[] Names = getResources().getStringArray(R.array.items_names);
        int[] Prices = getResources().getIntArray(R.array.items_prices);

        itemsThumbnailsTypedArray = getResources().obtainTypedArray(R.array.items_thumbnails);
        itemsImagesTypedArray = getResources().obtainTypedArray(R.array.items_images);
        itemsArrayList.clear();

        for (int i = 0; i < Names.length; i++){
            itemsArrayList.add(new Items(Names[i], Prices[i], itemsThumbnailsTypedArray.getResourceId(i, 0), itemsImagesTypedArray.getResourceId(i, 0)));
        }
        itemsThumbnailsTypedArray.recycle();
        itemsImagesTypedArray.recycle();
        itemsAdapter.notifyDataSetChanged();
    }
}