package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
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

import java.util.ArrayList;

import static android.view.Gravity.RIGHT;


public class Samlpe extends AppCompatActivity {

    private static final String TAG = "LOG";
    private String mJSONURLString = "https://myrik8333.github.io/test.json";
    private FrameLayout frameLayout;
    SharedPreferences sharedPreferences;
    private ListView listView;
    //private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samlpe);

        sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        final String string = sharedPreferences.getString("responce", "");
        final String mos = sharedPreferences.getString("mos", "");
        final String pit = sharedPreferences.getString("pit", "");
        final String kas = sharedPreferences.getString("kas", "");

        frameLayout = findViewById(R.id.FrameRoot);
        listView = findViewById(R.id.listview);

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Samlpe.this, Vus.class);
                intent.putExtra("id", String.valueOf(position));
                startActivity(intent);
            }
        });

        try {
            final JSONObject object = new JSONObject(string);
            final JSONObject object1 = object.getJSONObject("response");

            String count = object1.getString("count");
            //Log.d(TAG, count);
            JSONArray array = object1.getJSONArray("items");

            for( int i=0; i<array.length(); ++i) {

                JSONObject item = array.getJSONObject(i);
                //Log.d(TAG, item.toString());
                String id = item.getString("id");
                if(id.equals(mos)) {
                    String title = item.getString("title"); // Название вуза
                    list.add(title);
                    adapter.notifyDataSetChanged();
                }
                if(id.equals(pit)) {
                    String title = item.getString("title"); // Название вуза
                    list.add(title);
                    adapter.notifyDataSetChanged();
                }
                if(id.equals(kas)) {
                    String title = item.getString("title"); // Название вуза
                    list.add(title);
                    adapter.notifyDataSetChanged();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

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
            Intent intent = new Intent(Samlpe.this, ActivityWeb.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.invite) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
