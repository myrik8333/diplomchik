package com.example.diplom;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG";
    public ProgressDialog dialog;
    Button mButton;
    MyTask myTask = new MyTask();
    private Context mContext;
    private Button goend;
    private TextView textView1;
    private String mJSONURLString = "https://myrik8333.github.io/kazan.json";

    public EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //myTask.execute();
        mContext = getApplicationContext();

        button = findViewById(R.id.button);

        editText1 = findViewById(R.id.edittext1);
        editText2 = findViewById(R.id.edittext2);
        editText3 = findViewById(R.id.edittext3);
        editText4 = findViewById(R.id.edittext4);
        editText5 = findViewById(R.id.edittext5);
        editText6 = findViewById(R.id.edittext6);
        editText7 = findViewById(R.id.edittext7);
        editText8 = findViewById(R.id.edittext8);
        editText9 = findViewById(R.id.edittext9);
        editText10 = findViewById(R.id.edittext10);
        editText11 = findViewById(R.id.edittext11);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for( int i=0; i<11; i++){

                }

                Intent intent = new Intent(MainActivity.this, Samlpe.class);
                intent.putExtra("one", editText1.getText().toString());
                startActivity(intent);

            }
        });

    }
    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (
                    Request.Method.GET,
                    mJSONURLString,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {

                            //Log.d(TAG, "sfdfsdf");
                            try {
                                final JSONObject object = new JSONObject(response.toString());
                                JSONObject object1 = object.getJSONObject("response");
                                String count = object1.getString("count");
                                Log.d(TAG, count);
                                JSONArray array = object1.getJSONArray("items");

                                for( int i=0; i<array.length(); ++i){
                                    JSONObject item = array.getJSONObject(i);
                                    Log.d(TAG, item.toString());
                                    String id = item.getString("id");
                                    Log.d(TAG, id);
                                    String title = item.getString("title");
                                    Log.d(TAG, title);
//                                    String medium = item.getString("medium");
//                                    Log.d(TAG, medium);
                                    JSONArray faculties = item.getJSONArray("faculties");

                                    for( int j=0; j<faculties.length(); ++j){
                                        JSONObject facultet = faculties.getJSONObject(j);
                                        String id2 = facultet.getString("id");

                                        String title2 = facultet.getString("title");
                                        String medium = facultet.getString("medium");

                                        JSONArray subjects = facultet.optJSONArray("subjects");

                                        for( int k=0; k<subjects.length(); ++k){
                                            JSONObject subject = subjects.getJSONObject(k);
                                            String id3 = subject.getString("id");
                                            Log.d(TAG, id3);
                                            String discipline = subject.getString("discipline");
                                            TextView textView = new TextView(getApplicationContext());
                                            textView.setText(discipline);
                                            textView1.setText(discipline);
                                        }
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    }
            );

            requestQueue.add(jsonObjectRequest);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            // В связи с тем что ответ приходит мнгновенно, пришлось создать временную задержку в 3 секунды для
            // демонстрации работающего ProgressBar-а

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    //dialog.dismiss();
                }
            }, 3000);
        }
    }

}
