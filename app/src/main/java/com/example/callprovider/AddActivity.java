package com.example.callprovider;
import android.Manifest;
import android.content.ContentProviderOperation;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    EditText et_name;
    TextView et_num;
    String num, name;
    Button saved;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        et_name = findViewById(R.id.edit_name);
        et_num = findViewById(R.id.edit_num);
        saved = findViewById(R.id.button_save);

        Intent intent= getIntent();
        et_num.setText(intent.getStringExtra("전화번호"));
        et_name.setText(intent.getStringExtra("이름"));




//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
//                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, 0);
//                }
//                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
//                    requestPermissions(new String[]{Manifest.permission.WRITE_CONTACTS}, 0);
//                } else {
//                    if (et_name.getText().toString().length() == 0) {
//                        Toast.makeText(AddActivity.this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
//                    } else {
//                        setAddContacts();
//
//                    }
//                }
//            }
//        });
//    }
//
//
//    private void setAddContacts(){
//        //                    // Creates a new Intent to insert a contact
////                    Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
////                    // Sets the MIME type to match the Contacts Provider
////                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
////
////                    intent.putExtra(ContactsContract.Intents.Insert.EMAIL, et_num.getText());
////                    intent.putExtra(ContactsContract.Intents.Insert.NAME, et_name.getText());
////                    startActivity(intent);
//
//        ArrayList<ContentProviderOperation> list = new ArrayList<>();
//        list.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
//                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
//                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null).build());
//
//        list.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
//                .withValue(ContactsContract.Data.RAW_CONTACT_ID, 0)
//                .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
//                .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, et_name.getText().toString()).build());
//
//        list.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
//                .withValue(ContactsContract.Data.RAW_CONTACT_ID, 0)
//                .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
//                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, et_num.getText().toString())
//                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE).build());
//
//        try {
//            getContentResolver().applyBatch(ContactsContract.AUTHORITY, list);  //주소록추가
////                           contentResolver.applyBatch(ContactsContract.AUTHORITY, list)
//
//            Toast.makeText(AddActivity.this, "삽입하였습니다.", Toast.LENGTH_SHORT).show();
//
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (OperationApplicationException e) {
//            e.printStackTrace();
//        }
//        list.clear();   //리스트 초기화
//    }
}}
