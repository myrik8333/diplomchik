package com.example.diplom;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class AdapterForList extends BaseAdapter {

    private static final String TAG = "log";
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<ResorsesForRow> rows;
    SharedPreferences sharedPreferences;
    TextWatcher mTextWhatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            int ball = Integer.parseInt(s.toString());
            if(ball>100){
                ball = 0;
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };
    private int k;


    AdapterForList(Context ctx, ArrayList<ResorsesForRow> list){
        context = ctx;
        rows = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return rows.size();     // Общее кол-во элиментов
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return rows.get(position);
    }

    ResorsesForRow getResorsessForRow(int position) {
        return (ResorsesForRow) getItem(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view==null){
            view = layoutInflater.inflate(R.layout.row_for_listview, parent, false);
        }


        ResorsesForRow resorsesForRow = getResorsessForRow(position);

        ImageView imageView = view.findViewById(R.id.image_view);
        imageView.setImageResource(resorsesForRow.img);
        TextView textView = view.findViewById(R.id.name);
        textView.setText(resorsesForRow.name);
        EditText editText = view.findViewById(R.id.edittext);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int ball = Integer.parseInt(s.toString());

                if(ball<=100){
                    sharedPreferences = context.getSharedPreferences("pref", MODE_PRIVATE);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    String str = String.valueOf(position);
                    //edit.putString(position.toString(), text inside edittext);
                    edit.putString(String.valueOf(k), String.valueOf(ball));
                    Log.d(TAG, String.valueOf(k));
                    Log.d(TAG, String.valueOf(ball));
                    edit.apply();
                    ++k;
                }

            }
        });

        return view;
    }





//    ArrayList<ResorsesForRow> getList(){
//        ArrayList<ResorsesForRow> list = new ArrayList<ResorsesForRow>();
//        for (ResorsesForRow resorsesForRow : list){
//
//        }
//    }

}
