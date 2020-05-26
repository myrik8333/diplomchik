package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
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

public class StartActivity extends AppCompatActivity {

    private static final String TAG = "log";
    SharedPreferences sharedPreferences;
    MyTask myTask = new MyTask();
    private String mJSONURLString = "https://myrik8333.github.io/moscow.json";
    private String mJSONURLString2 = "https://myrik8333.github.io/piter.json";
    private String mJSONURLString3 = "https://myrik8333.github.io/kazan.json";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportActionBar().hide();
        myTask.execute();
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

                            Log.d(TAG, "sfdfsdf");
                            try {
                                final JSONObject object = new JSONObject(response.toString());

                                sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString("responce", object.toString());
                                Log.d(TAG, object.toString());
                                edit.apply();

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

            RequestQueue requestQueue2 = Volley.newRequestQueue(getApplicationContext());

            JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest (
                    Request.Method.GET,
                    mJSONURLString2,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {

                            Log.d(TAG, "sfdfsdf");
                            try {
                                final JSONObject object = new JSONObject(response.toString());

                                sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString("responce2", object.toString());
                                Log.d(TAG, object.toString());
                                edit.apply();

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

            requestQueue2.add(jsonObjectRequest2);

            RequestQueue requestQueue3 = Volley.newRequestQueue(getApplicationContext());

            JsonObjectRequest jsonObjectRequest3 = new JsonObjectRequest (
                    Request.Method.GET,
                    mJSONURLString3,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {

                            Log.d(TAG, "sfdfsdf");
                            try {
                                final JSONObject object = new JSONObject(response.toString());

                                sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putString("responce3", object.toString());
                                Log.d(TAG, object.toString());
                                edit.apply();

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

            requestQueue3.add(jsonObjectRequest3);
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
                    Intent intent = new Intent(StartActivity.this, ActivityBalls3.class);
                    startActivity(intent);
                    //dialog.dismiss();
                }
            }, 500);
        }
    }
}