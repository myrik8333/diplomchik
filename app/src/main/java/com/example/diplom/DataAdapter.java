package com.example.diplom;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static android.media.CamcorderProfile.get;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private static final String TAG = "log";
    SharedPreferences sharedPreferences;
    Context context;
    private LayoutInflater inflater;
    //private Toast toast= Toast.makeText(context,"Не подходящие  значения",0.5);
    public static List<ResorsesForRow> resorsesForRowList;        // editModelArrayList


    DataAdapter(Context context, List<ResorsesForRow> resorsesForRowList){
        this.resorsesForRowList = resorsesForRowList;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_listview, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.editText.setText(resorsesForRowList.get(position).getEditTextValue());
        //holder.myCustomEditTextListener.updatePosition(holder.getAdapterPosition());
        //holder.editText.setText();
        ResorsesForRow resorsesForRow = resorsesForRowList.get(position);

        holder.imageView.setImageResource(resorsesForRow.getImg());
        holder.textView.setText(resorsesForRow.getName());


    }

    @Override
    public int getItemCount() {
        return resorsesForRowList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected EditText editText;
        final ImageView imageView;
        final TextView textView;

        ViewHolder(final View view){
            super(view);
            imageView = view.findViewById(R.id.image_view);
            textView = view.findViewById(R.id.name);
            editText = view.findViewById(R.id.edittext);

            editText.addTextChangedListener(new TextWatcher() {
                private int position;
                private String str="0";
                private int i=0;
                public void updatePosition(int position) {
                    this.position = position;
                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                   // String str="0";


                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    try{
                        i=Integer.parseInt(s.toString());
                    }catch(NumberFormatException e){
                        i=0;
                    }
                    if (s.toString().isEmpty()) {
                        str = "0";
                        //i = Integer.parseInt(s.toString());
                    }
                    else if (i>100&&i<0) {

                        Toast.makeText(view.getContext(), "Ввели не подходящее число", Toast.LENGTH_LONG).show();
                    }
                    else{
                        str = editText.getText().toString();
                    }

//                    resorsesForRowList.get(getAdapterPosition()).setEditTextValue(editText.getText().toString());
//                    Log.d(TAG, s.toString());
                    //Log.d(TAG, )
                }

                @Override
                public void afterTextChanged(Editable s) {
                    resorsesForRowList.get(getAdapterPosition()).setEditTextValue(str);




//                    Log.d(TAG, s.toString());
//                    Log.d(TAG, String.valueOf(get(position)));

                }
            });
        }
    }

//    private class MyCustomEditTextListener implements TextWatcher {
//        private int position;
//
//        void updatePosition(int position) {
//            this.position = position;
//        }
//
//        @Override
//        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//            // no op
//        }
//
//        @Override
//        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//            Log.d(TAG, charSequence.toString());
//            Log.d(TAG, String.valueOf(position));
//        }
//
//        @Override
//        public void afterTextChanged(Editable editable) {
//            // no op
//        }
//    }
}
