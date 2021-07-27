package com.example.myandroidviewingnevs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class ActivitiNevs extends AppCompatActivity {
    public static final String KEY_NEVS_INDEX = "ImageActivity.fruit_idx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nevs);

        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            int imageIdx = getIntent().getIntExtra(KEY_NEVS_INDEX, -1);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.Set_Text_Container,
                    SetTextFragment.newInstance(imageIdx));
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        }
    }
}
//}
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//
//import android.content.res.Configuration;
//import android.os.Bundle;
//
//public class ActivitiNevs extends AppCompatActivity {
//    public static final String KEY_NEVS_INDEX = "";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_set_text);
//
//
//        if (savedInstanceState == null) {
//            int nevsIdx = getIntent().getIntExtra(KEY_NEVS_INDEX, -1);
//
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            FragmentTransaction transaction = fragmentManager.beginTransaction();
//            transaction.replace(R.id.Set_Text_Container,SetTextFragment.newInstance(nevsIdx));
//            transaction.commit();
//        }
//    }
//}