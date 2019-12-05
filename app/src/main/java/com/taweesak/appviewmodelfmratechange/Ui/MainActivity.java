package com.taweesak.appviewmodelfmratechange.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.taweesak.appviewmodelfmratechange.Fragment.AFragment;
import com.taweesak.appviewmodelfmratechange.Fragment.BFragment;
import com.taweesak.appviewmodelfmratechange.R;

public class MainActivity extends AppCompatActivity {

    AFragment aFragment;
    BFragment bFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Use the create MainActivity call fragment
        callAFragment();
    }

    private void callAFragment() {
        aFragment = new AFragment();
        bFragment = new BFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.contentContainer_a,aFragment)
                .add(R.id.contentContainer_b,bFragment).commit();
        Toast.makeText(this,"Main",Toast.LENGTH_SHORT).show();

    }
}
