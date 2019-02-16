package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {
    
    OnImageClickLisener mCallBack;
   
    public interface OnImageClickLisener{
        void onImageSelected(int position);
    }
    
   public  MasterListFragment(){
   
      }
      
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       
        View rootView = inflater.inflate(R.layout.fragment_master_list,container,false);
        // Get a reference to the GridView in the fragment_master_list xml layout file
        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);
        
        //Create the adapter
        //This adapter takes in the context and an ArrayList of ALL the image resources to display
        MasterListAdapter  mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(mAdapter);
        
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mCallBack.onImageSelected(position);
            }
        });
        return rootView;
    }
    
    @Override
    public void onAttach(Context context) {
        
        super.onAttach(context);
        try{
            mCallBack = (OnImageClickLisener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement OnImageClickLisener");
        }
    }
}

