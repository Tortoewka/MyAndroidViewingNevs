package com.example.myandroidviewingnevs;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class NevsListFragment extends Fragment {

    private int mCurrentImageIdx = -1;

    public NevsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_nevs_list, container, false);
        String[] nevsNames = getResources().getStringArray(R.array.NameNevsArray);

        int idx = 0;
        for (String nevsName : nevsNames) {
            TextView tv = new TextView(getContext());
            tv.setText(nevsName);
            tv.setTextSize(40);
            final int nevsIdx = idx;
            tv.setOnClickListener((v) -> {
                setCurrentImageIdx( nevsIdx);
                if (getResources().getConfiguration().orientation ==
                        Configuration.ORIENTATION_PORTRAIT) {
                    goToSeparateActivity(nevsIdx);
                } else {
                    showToTheRight(nevsIdx);
                }
            });
            view.addView(tv);
            idx++;
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);

        if (bundle != null) {
            mCurrentImageIdx = bundle.getInt(SetTextFragment.ARG_TEXT_IDX, -1);
            if (mCurrentImageIdx != -1 &&
                    getResources().getConfiguration().orientation ==
                            Configuration.ORIENTATION_LANDSCAPE) {
                showToTheRight(mCurrentImageIdx);
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);

        bundle.putInt(SetTextFragment.ARG_TEXT_IDX, mCurrentImageIdx);
    }

    private void setCurrentImageIdx(int imageIdx) {
        mCurrentImageIdx = imageIdx;
    }

    private void goToSeparateActivity(int imageIdx) {
        Intent intent = new Intent(getActivity(), ActivitiNevs.class);
        intent.putExtra(ActivitiNevs.KEY_NEVS_INDEX, imageIdx);
        startActivity(intent);
    }

    private void showToTheRight(int imageIdx) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.Set_Text_Container, SetTextFragment.newInstance(imageIdx));
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }
}
