package com.androyen.interactivestory.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androyen.interactivestory.R;
import com.androyen.interactivestory.model.Page;
import com.androyen.interactivestory.model.Story;

public class StoryActivity extends Activity {


    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private Page mCurrentPage;

    public static final String TAG = StoryActivity.class.getSimpleName();

    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //Get intent data from MainActivity
        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));

        if (mName == null) {
            mName = "friend";
        }

       Log.v(TAG, "value of intent extra is " + mName);

        mImageView = (ImageView)findViewById(R.id.storyImageView);
        mTextView = (TextView)findViewById(R.id.storyTextView);
        mChoice1 = (Button)findViewById(R.id.choiceButton1);
        mChoice2 = (Button)findViewById(R.id.choiceButton2);

        loadPage(0);


    }


    private void loadPage(int choice) {

        //get page from story
        mCurrentPage = mStory.getPage(choice);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);

        String pageText = mCurrentPage.getText();

        //Add the name of placeholder included.
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);

        mChoice1.setText(mCurrentPage.getChoice1().getText());
        mChoice2.setText(mCurrentPage.getChoice2().getText());

        mChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int nextPage = mCurrentPage.getChoice1().getNextPage();
                loadPage(nextPage);
            }
        });

        mChoice2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int nextPage = mCurrentPage.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
    }






}
