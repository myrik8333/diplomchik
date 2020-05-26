package com.example.diplom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterForResy extends RecyclerView.Adapter<AdapterForResy.ViewHolder> {

    private static final String TAG = "log";
    public static List<ResorsesForUnivers> resorsesForUniversList;
    private LayoutInflater inflater;
    private Context context;
    private OnNoteListener mOnNoteListener;

    AdapterForResy(Context context, List<ResorsesForUnivers> resorsesForUniversList, OnNoteListener onNoteListener){
        this.resorsesForUniversList = resorsesForUniversList;
        this.inflater = LayoutInflater.from(context);
        this.mOnNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public AdapterForResy.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resorse_for_univers, parent, false);
        //view.setOnClickListener(mOnClickListener);
        return new ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        ResorsesForUnivers resorsesForUnivers = resorsesForUniversList.get(position);
        holder.textView.setText(resorsesForUnivers.getNameUnivers());

//        ((ViewHolder)holder).linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, Vus.class);
//                intent.putExtra("id", String.valueOf(resorsesForUniversList.get(position)));
//                context.startActivity(intent);
//            }
//        });

//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, Vus.class);
//                intent.putExtra("id", String.valueOf(resorsesForUniversList.get(position)));
//                context.startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return resorsesForUniversList.size();
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout linearLayout;
        TextView textView;
        OnNoteListener onNoteListener;
        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            linearLayout.setOnClickListener(this);
            textView = itemView.findViewById(R.id.name);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
}