package com.androyen.interactivestory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.androyen.interactivestory.R;

public class StoryActivity extends Activity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //Get intent data from MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        if (name == null) {
            name = "friend";
        }

       Log.v(TAG, "value of intent extra is" + name);
    }



}
