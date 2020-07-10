package com.fauzi.contentreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Uri CONTENT_URI = Uri.parse("content://com.fauzi.myworkprovider/mahasiswa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void doLoad(View view) {
        Cursor cursor = getContentResolver().query(CONTENT_URI,
                null, null, null, "_id");
        StringBuilder stringBuilder = new StringBuilder();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String text1 = cursor.getString(1);
            String text2 = cursor.getString(2);
            String text3 = cursor.getString(3);
            stringBuilder.append(id + "     " + text1 + "    " + text2 + "   " + text3 + "\n");

            Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
        }
    }
}