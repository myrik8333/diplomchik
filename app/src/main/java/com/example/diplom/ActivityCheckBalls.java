package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.Gravity.LEFT;
import static android.view.Gravity.RIGHT;

public class ActivityCheckBalls extends AppCompatActivity {

    private static final String TAG = "log";
//    public EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11;
    SharedPreferences sharedPreferences;
//    String string1, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11;
//    int pass1, pass2, pass3, pass4, pass5, pass6, pass7, pass8, pass9, pass10, pass11;
//    int sumballs;

    private ListView list;

    private String[] names = {"Русский язык", "Математика", "Обществознание", "Биология", "Иностранный язык", "История", "Химия", "География", "Информатика", "Литература", "Физика"};
    private int[] images = {R.drawable.icons1, R.drawable.icons2, R.drawable.icons3, R.drawable.icons4, R.drawable.icons5, R.drawable.icons6, R.drawable.icons7, R.drawable.icons8, R.drawable.icons9, R.drawable.icons9, R.drawable.icons10, R.drawable.icons11};
    private Boolean flag=false;  // Флаг указывающий что если хоть одно число больше 100 то нихера перехода не будет
//    private RelativeLayout frameLayout;
//    private LinearLayout linearLayout;

    ArrayList<ResorsesForRow> resorsesForRows = new ArrayList<ResorsesForRow>();


    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bals2);

        button = findViewById(R.id.button);

        list = findViewById(R.id.listView);

        for(int i=0; i<11; i++){
            resorsesForRows.add(new ResorsesForRow(names[i], images[i], "0"));
            Log.d(TAG, names[i]);
        }

        AdapterForList adapterForList = new AdapterForList(this, resorsesForRows);
        list.setAdapter(adapterForList);

//        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(11);
//        Map<String, Object> map;

//        for( int i=0; i<11; i++){
//            map = new HashMap<String, Object>();
//            map.put("name", names[i]);
//            map.put("img", images[i]);
//            //map.put("edit", );
//            //map.put("edit", )
//            data.add(map);
//        }
//
//        String[] from = {"name", "img"};
//        int[] to = {R.id.name, R.id.image_view};
//
//        list = findViewById(R.id.listView);
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.row_for_listview, from, to);
//
//        list.setAdapter(simpleAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityCheckBalls.this, ActivityTown.class);
                startActivity(intent);
            }
        });


//        frameLayout = findViewById(R.id.FrameRoot);
//        ScrollView scrollView = new ScrollView(this);
//        scrollView.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT));
//        frameLayout.addView(scrollView);
//
//        LinearLayout verticalLinearLayout = new LinearLayout(this);
//        verticalLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//        verticalLinearLayout.setOrientation(LinearLayout.VERTICAL);
//        scrollView.addView(verticalLinearLayout);
//
//        for(int i=0; i<11; i++){
//            LinearLayout horisontalLinearLayout = new LinearLayout(this);
//            horisontalLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//            horisontalLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
//            verticalLinearLayout.addView(horisontalLinearLayout);
//
//            LinearLayout linearleft = new LinearLayout(this);
//            linearleft.setGravity(LEFT);
//            linearleft.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
//            linearleft.setOrientation(LinearLayout.HORIZONTAL);
//            horisontalLinearLayout.addView(linearleft);
//
//            LinearLayout linearRight = new LinearLayout(this);
//            linearRight.setGravity(RIGHT);
//            linearRight.setOrientation(LinearLayout.HORIZONTAL);
//            linearRight.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
//            horisontalLinearLayout.addView(linearRight);
//
//            switch (i){
//                case 0:
//                    ImageView imageView = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView);
//                    Drawable drawable = getResources().getDrawable(R.drawable.icons1);
//                    imageView.setImageDrawable(drawable);
//                    imageView.getLayoutParams().height = 150;
//                    imageView.getLayoutParams().width = 150;
//                    imageView.setPadding(16,16,16,16);
//
//                    TextView textView = new TextView(this);
//                    textView.setText("Русский язык");
//                    textView.setTextSize(20);
//                    linearleft.addView(textView);
//
//                    EditText editText = new EditText(this);
//                    linearRight.addView(editText);
//                    break;
//                case 1:
//                    ImageView imageView1 = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView1);
//                    Drawable drawable1 = getResources().getDrawable(R.drawable.icons2);
//                    imageView1.setImageDrawable(drawable1);
//                    break;
//                case 2:
//                    ImageView imageView2 = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView2);
//                    Drawable drawable2 = getResources().getDrawable(R.drawable.icons3);
//                    imageView2.setImageDrawable(drawable2);
//                    break;
//                case 3:
//                    ImageView imageView3 = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView3);
//                    Drawable drawable3 = getResources().getDrawable(R.drawable.icons4);
//                    imageView3.setImageDrawable(drawable3);
//                    break;
//                case 4:
//                    ImageView imageView4 = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView4);
//                    Drawable drawable4 = getResources().getDrawable(R.drawable.icons5);
//                    imageView4.setImageDrawable(drawable4);
//                    break;
//                case 5:
//                    ImageView imageView6 = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView6);
//                    Drawable drawable6 = getResources().getDrawable(R.drawable.icons6);
//                    imageView6.setImageDrawable(drawable6);
//                    break;
//                case 6:
//                    ImageView imageView7 = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView7);
//                    Drawable drawable7 = getResources().getDrawable(R.drawable.icons7);
//                    imageView7.setImageDrawable(drawable7);
//                    break;
//                case 7:
//                    ImageView imageView8 = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView8);
//                    Drawable drawable8 = getResources().getDrawable(R.drawable.icons8);
//                    imageView8.setImageDrawable(drawable8);
//                    break;
//                case 8:
//                    ImageView imageView9 = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView9);
//                    Drawable drawable9 = getResources().getDrawable(R.drawable.icons9);
//                    imageView9.setImageDrawable(drawable9);
//                    break;
//                case 9:
//                    ImageView imageView10 = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView10);
//                    Drawable drawable10 = getResources().getDrawable(R.drawable.icons10);
//                    imageView10.setImageDrawable(drawable10);
//                    break;
//                case 10:
//                    ImageView imageView11 = new ImageView(this);
//                    horisontalLinearLayout.addView(imageView11);
//                    Drawable drawable11 = getResources().getDrawable(R.drawable.icons11);
//                    imageView11.setImageDrawable(drawable11);
//                    break;
//            }
//
//
//
//
//        }
//        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        //String string = sharedPreferences.getString("responce", "");

//        button = findViewById(R.id.button);
//
//        editText1 = findViewById(R.id.edittext1);
//        editText2 = findViewById(R.id.edittext2);
//        editText3 = findViewById(R.id.edittext3);
//        editText4 = findViewById(R.id.edittext4);
//        editText5 = findViewById(R.id.edittext5);
//        editText6 = findViewById(R.id.edittext6);
//        editText7 = findViewById(R.id.edittext7);
//        editText8 = findViewById(R.id.edittext8);
//        editText9 = findViewById(R.id.edittext9);
//        editText10 = findViewById(R.id.edittext10);
//        editText11 = findViewById(R.id.edittext11);
//
//        string1 = editText1.getText().toString();
//        pass1 = Integer.parseInt(string1);
//        Log.d(TAG, string1);
//
//        string2 = editText2.getText().toString();
//        pass2 = Integer.parseInt(string2);
//
//        string3 = editText3.getText().toString();
//        pass3 = Integer.parseInt(string3);
//
//        string4 = editText4.getText().toString();
//        pass4 = Integer.parseInt(string4);
//
//        string5 = editText5.getText().toString();
//        pass5 = Integer.parseInt(string5);
//
//        string6 = editText6.getText().toString();
//        pass6 = Integer.parseInt(string6);
//
//        string7 = editText7.getText().toString();
//        pass7 = Integer.parseInt(string7);
//
//        string8 = editText8.getText().toString();
//        pass8 = Integer.parseInt(string8);
//
//        string9 = editText9.getText().toString();
//        pass9 = Integer.parseInt(string9);
//
//        string10 = editText10.getText().toString();
//        pass10 = Integer.parseInt(string10);
//
//        string11 = editText11.getText().toString();
//        pass11 = Integer.parseInt(string11);
//        Log.d(TAG, string1);
//
//        if( pass1>100 || pass2>100 || pass3>100 || pass4>100 || pass5>100 || pass6>100 || pass7>100 || pass8>100 || pass9>100 || pass10>100 || pass11>100)
//        {
//            flag = false;
//        } else {
//            flag = true;
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            if( pass1!=0){
//                editor.putString("rus", string1);
//            }
//            if( pass2!=0){
//                editor.putString("math", string2);
//            }
//            if( pass3!=0){
//                editor.putString("obh", string3);
//            }
//            if( pass4!=0){
//                editor.putString("bio", string4);
//            }
//            if( pass5!=0){
//                editor.putString("eng", string5);
//            }
//            if( pass6!=0){
//                editor.putString("his", string6);
//            }
//            if( pass7!=0){
//                editor.putString("xim", string7);
//            }
//            if( pass8!=0){
//                editor.putString("geo", string8);
//            }
//            if( pass9!=0){
//                editor.putString("inf", string9);
//            }
//            if( pass10!=0){
//                editor.putString("lit", string10);
//            }
//            if( pass11!=0){
//                editor.putString("phi", string11);
//            }
//            editor.apply();
//        }
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(flag) {
//                    Intent intent = new Intent(ActivityCheckBalls.this, ActivityTown.class);
//                    startActivity(intent);
//                }
//            }
//        });
    }
}
