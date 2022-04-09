package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ViewPagerAdapter;
import com.example.myapplication.model.SecondModel;

public class ItemFragment extends Fragment {
    private View view;
    private TextView tvItemViewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.item_view_pager,container,false);
        initViews();
        return view;
    }


    private void initViews() {
        tvItemViewPager = view.findViewById(R.id.tv_item_view_pager);

        Bundle bundleReceive = getArguments();
        if(bundleReceive != null){
            SecondModel secondModel = (SecondModel) bundleReceive.get(ViewPagerAdapter.KEY_VIEW_PAGER);
            tvItemViewPager.setText(secondModel.getNameFragment());
        }
    }
}
