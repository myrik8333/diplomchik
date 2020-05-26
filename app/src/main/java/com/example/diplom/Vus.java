package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Vus extends AppCompatActivity {
    private static final String TAG = "LOG";

    ListView listView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actuvity_way);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        final String responce = sharedPreferences.getString("responce", "");
        final String sumid = sharedPreferences.getString("sumid", "");

        listView = findViewById(R.id.listView);

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        Intent intent = getIntent();
        String posihion = intent.getStringExtra("id");


        try {
            JSONObject object = new JSONObject(responce);
            JSONObject object1 = object.getJSONObject("response");
            JSONArray array = object1.getJSONArray("items");

            for( int i=0; i<array.length(); ++i) {

                JSONObject item = array.getJSONObject(i);
                Log.d(TAG, item.toString());
                String id = item.getString("id");
                String title = item.getString("title"); // Название вуза
               // if (posihion.equals(id)) {

                    JSONArray faculties = item.getJSONArray("faculties");

                    for( int j=0; j<faculties.length(); ++j) {
                        JSONObject facultet = faculties.getJSONObject(j);
                        String id2 = facultet.getString("id");

                        String title2 = facultet.getString("title");


                        String medium = facultet.getString("medium");
                        String subs = facultet.getString("subs");
                        Log.d(TAG, subs + "  subs");
                        Log.d(TAG, sumid + "  sumid");

                        if(sumid.equals(subs)) {
                            list.add(title2);
                            adapter.notifyDataSetChanged();
                            JSONArray subjects = facultet.optJSONArray("subjects");

                            for (int k = 0; k < subjects.length(); ++k) {
                                JSONObject subject = subjects.getJSONObject(k);
                                String id3 = subject.getString("id");
                                //Log.d(TAG, id3);
                                String discipline = subject.getString("discipline");

                            }
                        }
                    }
               // }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(Vus.this, ActivityWeb.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.invite) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
