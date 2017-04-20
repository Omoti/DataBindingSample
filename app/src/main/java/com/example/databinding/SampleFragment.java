package com.example.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databinding.databinding.FragmentSampleBinding;

/**
 * Fragment
 */

public class SampleFragment extends Fragment implements SampleEventHandlers {
    public static SampleFragment newInstance(){
        return new SampleFragment();
    }

    private User mUser = new User("Sabro");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentSampleBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sample, container, false);
        binding.setUser(mUser);
        binding.setHandlers(this);

        return binding.getRoot();
    }

    @Override
    public void onChangeClick(View view) {
        Log.d("DEBUG", "Change User Name");

        mUser.setName("Shiro");
        Log.d("DEBUG", mUser.getName());


    }
}
