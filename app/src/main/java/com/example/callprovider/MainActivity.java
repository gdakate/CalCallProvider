package com.example.callprovider;

import static android.Manifest.permission.READ_CALL_LOG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button2,button3;
    ListView unKnown, known;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<String> knownItem = new ArrayList<String>();
        final ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, knownItem);

        final ArrayList<String> unknownItem = new ArrayList<String>();
        final ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, unknownItem);


        known = findViewById(R.id.knownListView);
        known.setAdapter(adapter1);

        unKnown = findViewById(R.id.unknownListView);
        unKnown.setAdapter(adapter2);

        if (ActivityCompat.checkSelfPermission(this, READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            READ_CALL_LOG}, 0);
        }

                String[] msgSet = new String[]{CallLog.Calls.CACHED_NAME, CallLog.Calls.NUMBER, CallLog.Calls.DATE};
                known.getAdapter();
                Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI, msgSet, null, null, null);
                if (c == null) knownItem.add("통화기록없음");
                ArrayList<String> numList= new ArrayList<String>();
                ArrayList<String> nameList= new ArrayList<String>();


                c.moveToFirst();
                do {
                    StringBuffer buffer = new StringBuffer();
                    String name = c.getString(0);
                    if (name != null) {
                        buffer.append("이름 : " + name + "\n");
                        nameList.add(name);


                        String num = c.getString(1);
                        buffer.append("번호 : " + num + "\n");
                        numList.add(num);


                        long callDate = c.getLong(2);
                        SimpleDateFormat datePattern = new SimpleDateFormat("yy-MM-dd");
                        String date_str = datePattern.format(new Date(callDate));
                        buffer.append("날짜 : " + date_str + "\n\n");
                        knownItem.add(String.valueOf(buffer));
                        adapter1.notifyDataSetChanged();

                    }

                } while (c.moveToNext());

                c.close();

                String[] msgSet2 = new String[]{CallLog.Calls.CACHED_NAME, CallLog.Calls.NUMBER, CallLog.Calls.DATE};
                unKnown.getAdapter();
                Cursor c2 = getContentResolver().query(CallLog.Calls.CONTENT_URI, msgSet2, null, null, null);
                if (c2 == null) unknownItem.add("통화기록없음");
                ArrayList<String> numList2= new ArrayList<String>();
                ArrayList<String> nameList2= new ArrayList<String>();

                c2.moveToFirst();
                do {
                    StringBuffer buffer = new StringBuffer();
                    String name = c2.getString(0);
                    if (name == null) {
                        buffer.append("이름 : 발신자 정보없음" + "\n");
                        nameList2.add("");

                        String num = c2.getString(1);
                        buffer.append("번호 : " + num + "\n");
                        numList2.add(num);


                        long callDate = c2.getLong(2);
                        SimpleDateFormat datePattern = new SimpleDateFormat("yy-MM-dd");
                        String date_str = datePattern.format(new Date(callDate));
                        buffer.append("날짜 : " + date_str + "\n\n");

                        unknownItem.add(String.valueOf(buffer));
                        adapter2.notifyDataSetChanged();
                    }

                } while (c2.moveToNext());
                c2.close();


        Intent intent= new Intent(MainActivity.this,ContactsActivity.class);

        known.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //리스트뷰의 포지션을 가져옴.
                //리스트뷰의 포지션 내용을 가져옴.
                String numbers= numList.get(i);
                String name= nameList.get(i);
                intent.putExtra("이름",name);
                intent.putExtra("전화번호",numbers);
                startActivity(intent);

            }

        });

        unKnown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 //리스트뷰의 포지션을 가져옴.
                 //리스트뷰의 포지션 내용을 가져옴.
                 String numbers= numList2.get(i);
                 String name= nameList2.get(i);
                 intent.putExtra("이름",name);
                 intent.putExtra("전화번호",numbers);
                 startActivity(intent);
            }
        });

//







    }
}