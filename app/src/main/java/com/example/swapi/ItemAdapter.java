package com.example.swapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemAdapter extends PagedListAdapter<Results, ItemAdapter.ItemViewHolder> {


    private Context mCtx;

    ItemAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;

    }



    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Results item = getItem(position);


        if (item != null) {
            holder.textView.setText(item.getName());
            holder.textView2.setText(item.getBirthYear());

        }else{
            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show();
        }
    }

    private static DiffUtil.ItemCallback<Results> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Results>() {
                @Override
                public boolean areItemsTheSame(Results oldItem, Results newItem) {
                    return oldItem.getName() == newItem.getName();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(Results oldItem, Results newItem) {
                    return oldItem.equals(newItem);
                }
            };

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView textView,textView2;


        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
            textView2 = itemView.findViewById(R.id.txt2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mCtx,ItemDisplayActivity.class);
                    intent.putExtra("films", (Results) getItem(getAdapterPosition()));

                    mCtx.startActivity(intent);
                    Toast.makeText(mCtx,
                            "click"+getAdapterPosition(),
                            Toast.LENGTH_LONG).show();

                }
            });
        }
    }



}