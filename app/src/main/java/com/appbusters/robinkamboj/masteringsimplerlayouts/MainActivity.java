package com.appbusters.robinkamboj.masteringsimplerlayouts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction fragmentTransaction;
    private String from = "HOME";

    @BindView(R.id.conditional)
    LinearLayout conditional;
    @BindView(R.id.fragment_container)
    FrameLayout container;
    @BindView(R.id.header)
    TextView header;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:{
                    from = getString(R.string.title_home);
                    header.setText("Daily Suvichar : Home");
                    addFragment(from);
                    showConditional();
                    return true;
                }
                case R.id.navigation_guru:{
                    header.setText("Daily Suvichar : Guru List");
                    addGuruFragment();
                    hideConditional();
                    return true;
                }
                case R.id.navigation_explore:{
                    header.setText("Daily Suvichar : Explore");
                    from = getString(R.string.title_explore);
                    addFragment(from);
                    showConditional();
                    return true;
                }
                case R.id.navigation_your_feeds:{
                    header.setText("Daily Suvichar : Your Feeds");
                    from = getString(R.string.title_your_feeds);
                    addFragment(from);
                    showConditional();
                    return true;
                }
                case R.id.navigation_profile:{
                    header.setText("Daily Suvichar : Profile");
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

    private void addGuruFragment(){
        GuruFragment guruFragment = new GuruFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, guruFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        addFragment(getResources().getString(R.string.title_home));

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
