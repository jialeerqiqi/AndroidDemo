package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;


public class AndroidMeActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        
        if (savedInstanceState == null) {
            // Create a new head BodyPartFragment
            BodyPartFragment headFragment = new BodyPartFragment();
/* 测试一下上传的修改内容
 //Add the fragment to its container using a FragmentManager and a Transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Add the fragment to its container using a FragmentManager and a Transaction
        fragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .commit();
*/
            // Set the list of image id's for the head fragment and set the position to the second image in the list
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            int headIndex = getIntent().getIntExtra("headIndex",0);
            headFragment.setListIndex(headIndex);
            // Add the fragment to its container using a FragmentManager and a Transaction
            FragmentManager fragmentManager = getSupportFragmentManager();
            
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();
            
            //body fragment
            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            bodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex",0);
            bodyPartFragment.setListIndex(bodyIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyPartFragment)
                    .commit();
            
            //leg fragment
            BodyPartFragment legPartFragment = new BodyPartFragment();
            legPartFragment.setImageIds(AndroidImageAssets.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex",0);
            legPartFragment.setListIndex(legIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legPartFragment)
                    .commit();
        }
    }
}
