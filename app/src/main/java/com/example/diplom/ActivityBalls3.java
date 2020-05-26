package com.example.diplom;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appinvite.AppInviteInvitation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActivityBalls3 extends AppCompatActivity {

    private static final int REQUEST_INVITE =1;
    List<ResorsesForRow> resorsesForRowList = new ArrayList<>();
    private String[] names = {"Русский язык", "Математика", "Обществознание", "Биология", "Иностранный язык", "История", "Химия", "География", "Информатика", "Литература", "Физика"};
    private int[] images = {R.drawable.icons1, R.drawable.icons2, R.drawable.icons3, R.drawable.icons4, R.drawable.icons5, R.drawable.icons6, R.drawable.icons7, R.drawable.icons8, R.drawable.icons9, R.drawable.icons9, R.drawable.icons10, R.drawable.icons11};
    private static final String TAG = "log";
    SharedPreferences sharedPreferences;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balls3);

        button = findViewById(R.id.button);

        InitData();
        RecyclerView recyclerView = findViewById(R.id.list);
        DataAdapter adapter = new DataAdapter(this, resorsesForRowList);
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                StringBuilder sumid = new StringBuilder();
                for(int i=0; i<11; i++){
                    String string = DataAdapter.resorsesForRowList.get(i).getEditTextValue();
                    int l = Integer.parseInt(string);


                    if(l>0 && l<=100){
                        sumid.append(i);
                        edit.putString(String.valueOf(i), string);
                        Log.d(TAG, String.valueOf(i));
                        Log.d(TAG, string);
                        Log.d(TAG, sumid.toString());
                        edit.apply();
                    }
                }
                edit.putString("sumid", sumid.toString());
                edit.apply();
                Intent intent = new Intent(ActivityBalls3.this, ActivityDop.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_balls, menu);
        return true;
    }
    private void InitData(){
        for(int i=0; i<11; i++){
            resorsesForRowList.add(new ResorsesForRow(names[i], images[i], "0"));
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(ActivityBalls3.this, ActivityWeb.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.invite) {
            Intent intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
                    .setMessage(getString(R.string.invitation_message))
                    .setDeepLink(Uri.parse("diplom1.page.link"))
                    .setCallToActionText(getString(R.string.invitation_cta))
                    .build();
            startActivityForResult(intent, REQUEST_INVITE);
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode);

        if (requestCode == REQUEST_INVITE) {
            if (resultCode == RESULT_OK) {
                // Get the invitation IDs of all sent messages
                String[] ids = AppInviteInvitation.getInvitationIds(resultCode, data);
                for (String id : ids) {
                    Log.d(TAG, "onActivityResult: sent invitation " + id);
                }
            } else {
                Log.d(TAG, "something wrong with messaging" );
                // Sending failed or it was canceled, show failure message to the user
                // ...
            }
        }
    }
//    private List<ResorsesForRow> populateList(){
//
//        List<ResorsesForRow> list = new ArrayList<>();
//
//        for (int i=0; i<11; i++){
//            String edit;
//
//            ResorsesForRow resorsesForRow = new ResorsesForRow(names[i], images[i], "");
//            resorsesForRow.setEditTextValue(String.valueOf(i));
//            Log.d(TAG, resorsesForRow.getEditTextValue());
//
//        }
//
//
//        return list;
//    }
}
