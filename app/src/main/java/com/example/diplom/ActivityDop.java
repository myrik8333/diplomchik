package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import java.lang.reflect.Array;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDop extends AppCompatActivity {
    private static final String TAG = "log";
    String[] countries = { "Медаль", "ГТО", "Волонтерство"};
    int [] values={10,8,5};
    int [] flags={0,0,0};
    TextView selection;
    ListView countriesList;
    Button button;
    private String selectedItems="";
    SharedPreferences sharedPreferences;
    private int summ=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dop);

        // получаем элемент TextView
        selection = (TextView) findViewById(R.id.selection);
        // получаем элемент ListView
        countriesList = (ListView) findViewById(R.id.countriesList);

        // создаем адаптер
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_multiple_choice, countries);
        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);
        // добвляем для списка слушатель
        button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                selectedItems = String.valueOf(summ);
                Log.d("selected shit", selectedItems);
                edit.putString("dop", selectedItems);
                edit.apply();
                Intent intent = new Intent(ActivityDop.this, ActivityTown.class);
                startActivity(intent);
            }
        });
        countriesList.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                SparseBooleanArray sp=countriesList.getCheckedItemPositions();
               // summ=0;
                if(flags[position]==0){
                    summ=summ+values[position];
                    flags[position]=1;
                }
                else if(flags[position]==1){
                    summ=summ-values[position];
                    flags[position]=0;
                }

                for(int i=0;i < countries.length;i++)
                {

                    if(sp.get(i)) {

                        //selectedItems += String.valueOf(position);
                        Log.d("position", String.valueOf(position));
                        Log.d(TAG, String.valueOf(summ));
                    }
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dop, menu);
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
            Intent intent = new Intent(ActivityDop.this, ActivityWeb.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.invite) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}