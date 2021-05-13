package com.example.listview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    private ArrayList<Items> itemList;
    private Context context;

    ItemsAdapter(Context context, ArrayList<Items> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.single_view_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        Items currentItem = itemList.get(position);
        holder.bindTo(currentItem);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mNameTextView;
        private TextView mPriceTextView;
        private ImageView imageLarge;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            mNameTextView = itemView.findViewById(R.id.itemNameTextView);
            mPriceTextView = itemView.findViewById(R.id.itemPriceTextView);
            imageLarge = itemView.findViewById(R.id.itemThumbnail);
            imageLarge.setOnClickListener(this);
        }

        void bindTo(Items currentItem){
            mNameTextView.setText(currentItem.getName());
            mPriceTextView.setText(context.getResources().getString(R.string.price_format, currentItem.getPrice()));

            Glide.with(context).load(currentItem.getImage()).into(imageLarge);
        }

        @Override
        public void onClick(View v) {
            Items currentItem = itemList.get(getAdapterPosition());

            final Dialog dialog = new Dialog(context, R.style.Theme_AppCompat_Light_DialogWhenLarge);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

            dialog.setContentView(R.layout.dialog_layout);
            ImageView largeImage = dialog.findViewById(R.id.largeImageView);
            largeImage.setImageResource(currentItem.getImage());
            Button button = dialog.findViewById(R.id.doneButton);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }
}
