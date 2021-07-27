package com.example.myandroidviewingnevs;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SetTextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetTextFragment extends Fragment {
    public static final String ARG_TEXT_IDX = "FruitFragment.fruit_idx";

    private int mNevsIdx;

    public SetTextFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mNevsIdx Nevs index.
     * @return A new instance of fragment SetTextFragment
     */
    // TODO: Rename and change types and number of parameters
    public static SetTextFragment newInstance(int mNevsIdx) {
        SetTextFragment fragment = new SetTextFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TEXT_IDX, mNevsIdx);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNevsIdx = getArguments().getInt(ARG_TEXT_IDX, -1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_text, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TypedArray img = getResources().obtainTypedArray(R.array.NameNevsArray);
        AppCompatTextView textView1 = view.findViewById(R.id.textView1);
        textView1.setTextSize(40);
        textView1.setText(img.getResourceId(mNevsIdx, -1));
        img.recycle();

        TypedArray img1 = getResources().obtainTypedArray(R.array.TextNevsArray);
        AppCompatTextView textView2 = view.findViewById(R.id.textView2);
        textView2.setTextSize(40);
        textView2.setText(img.getResourceId(mNevsIdx, -1));
        img1.recycle();
    }
}
