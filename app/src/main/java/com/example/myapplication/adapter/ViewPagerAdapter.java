package com.example.myapplication.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.fragment.ItemFragment;
import com.example.myapplication.model.SecondModel;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public static final String KEY_VIEW_PAGER = "KEY_VIEW_PAGER";
    private List<SecondModel> mListSecond;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior , List<SecondModel> mList) {
        super(fm, behavior);
        this.mListSecond = mList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        SecondModel secondModel = mListSecond.get(position);
        ItemFragment itemFragment = new ItemFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_VIEW_PAGER,secondModel);
        itemFragment.setArguments(bundle);
        return itemFragment;
    }

    @Override
    public int getCount() {
        return mListSecond.size();
    }
}
