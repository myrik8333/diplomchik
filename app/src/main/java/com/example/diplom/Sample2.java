package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Sample2 extends AppCompatActivity implements AdapterForResy.OnNoteListener, Parcelable {

    private static final String TAG = "LOG";
    public ArrayList<ResorsesForUnivers> resorsesForUnivers = new ArrayList<>();
    public ArrayList<String> ides = new ArrayList<String>();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample2);

        RecyclerView recyclerView = findViewById(R.id.list2);
        AdapterForResy adapter = new AdapterForResy(this, resorsesForUnivers, this);
        recyclerView.setAdapter(adapter);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        final String string1 = sharedPreferences.getString("responce", "");
        final String string2 = sharedPreferences.getString("responce2", "");
        final String string3 = sharedPreferences.getString("responce3", "");
        final String mos = sharedPreferences.getString("mos", "");
        final String pit = sharedPreferences.getString("pit", "");
        final String kas = sharedPreferences.getString("kas", "");

        if(mos.equals("1")) {
            try {
                final JSONObject object = new JSONObject(string1);
                final JSONObject object1 = object.getJSONObject("response");

                String count = object1.getString("count");
                Log.d(TAG, count);
                JSONArray array = object1.getJSONArray("items");

                for (int i = 0; i < array.length(); ++i) {

                    JSONObject item = array.getJSONObject(i);
                    //Log.d(TAG, item.toString());
                    String id = item.getString("id");
                    ides.add(id);

                    String title = item.getString("title"); // Название вуза
                    Log.d(TAG, title);
                    resorsesForUnivers.add(new ResorsesForUnivers(title));
                    adapter.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if(pit.equals("0")) {
            try {
                final JSONObject object = new JSONObject(string2);
                final JSONObject object1 = object.getJSONObject("response");

                String count = object1.getString("count");
                Log.d(TAG, count);
                JSONArray array = object1.getJSONArray("items");

                for (int i = 0; i < array.length(); ++i) {

                    JSONObject item = array.getJSONObject(i);
                    //Log.d(TAG, item.toString());
                    String id = item.getString("id");
                    ides.add(id);

                    String title = item.getString("title"); // Название вуза
                    Log.d(TAG, title);
                    resorsesForUnivers.add(new ResorsesForUnivers(title));
                    adapter.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if(kas.equals("2")) {
            try {
                final JSONObject object = new JSONObject(string3);
                final JSONObject object1 = object.getJSONObject("response");

                String count = object1.getString("count");
                Log.d(TAG, count);
                JSONArray array = object1.getJSONArray("items");

                for (int i = 0; i < array.length(); ++i) {

                    JSONObject item = array.getJSONObject(i);
                    //Log.d(TAG, item.toString());
                    String id = item.getString("id");
                    ides.add(id);

                    String title = item.getString("title"); // Название вуза
                    Log.d(TAG, title);
                    resorsesForUnivers.add(new ResorsesForUnivers(title));
                    adapter.notifyDataSetChanged();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onNoteClick(int position) {
        resorsesForUnivers.get(position);
        Intent intent = new Intent(this, Vus.class);
        //intent.putParcelableArrayListExtra("list", ides);
        intent.putExtra("id", String.valueOf(resorsesForUnivers.get(position)));
        startActivity(intent);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sample, menu);
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(Sample2.this, ActivityWeb.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.invite) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}