package com.appbusters.robinkamboj.masteringsimplerlayouts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction fragmentTransaction;
    private String from = "HOME";

    @BindView(R.id.conditional)
    LinearLayout conditional;
    @BindView(R.id.container)
    FrameLayout container;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:{
                    from = "HOME";
                    addFragment(from);
                    showConditional();
                    return true;
                }
                case R.id.navigation_guru:{
                    hideConditional();
                    return true;
                }
                case R.id.navigation_explore:{
                    from = "EXPLORE";
                    addFragment(from);
                    showConditional();
                    return true;
                }
                case R.id.navigation_your_feeds:{
                    from = "YOUR FEEDS";
                    addFragment(from);
                    showConditional();
                    return true;
                }
                case R.id.navigation_profile:{
                    hideConditional();
                    return true;
                }
            }
            return false;
        }

    };

    private void hideConditional(){
        if(conditional.getVisibility()== View.VISIBLE){
            conditional.setVisibility(View.INVISIBLE);
        }
    }
    private void showConditional(){
        if(conditional.getVisibility()== View.INVISIBLE){
            conditional.setVisibility(View.VISIBLE);
        }
    }

    private void addFragment(String from){
        CommonFragment commonFragment = new CommonFragment();
        Bundle args = new Bundle();
        args.putString("from", from);
        commonFragment.setArguments(args);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, commonFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
