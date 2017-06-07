package com.appbusters.robinkamboj.masteringsimplerlayouts;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommonFragment extends Fragment {

    private String from = getString(R.string.title_home);

    public CommonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_common, container, false);

        from = getArguments().getString("from");

        if(from.equals(getString(R.string.title_home))){
            Log.e("FROM", from);
        }
        else if(from.equals(getString(R.string.title_explore))){
            Log.e("FROM", from);
        }
        else if(from.equals(getString(R.string.your_feeds))){
            Log.e("FROM", from);
        }

        return v;
    }

}
