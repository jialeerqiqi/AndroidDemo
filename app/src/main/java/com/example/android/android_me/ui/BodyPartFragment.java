package com.example.android.android_me.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    
//    Final Strings to store state information about the list of images and list index
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";
    
    // Tag for logging
    private static final String TAG = "BodyPartFragment";
    
    // Variables to store a list of image resources and the index of the image that this fragment displays
    private List<Integer> mImageIds;
    private int mListIndex;
    
    public BodyPartFragment() {
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        
        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        // Inflate the Android-Me fragment layout
        final View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        // Get a reference to the ImageView in the fragment layout
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_viwe);
        // Set the image to the first in our list of head images
        //imageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        if(mImageIds != null){
//            set the image resource to the list item at the stored index
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListIndex++;
                    if (mListIndex<mImageIds.size()) {
                        imageView.setImageResource(mImageIds.get(mListIndex));
                    }else {
                        mListIndex =0;
                    }
                }
            });
        }else{
            Log.v(TAG, "This fragment has a null list of image id's");
        }
        // Return the rootView
        return rootView;
    }
    
    // Setter methods for keeping track of the list images this fragment can display and which image
    // in the list is currently being displayed
    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }
    
    public void setListIndex(int index) {
        mListIndex = index;
    }
    
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
        
    }
}
