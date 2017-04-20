package com.example.databinding;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SampleEventHandlers {
    private User mUser = new User("Taro");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(mUser);
        binding.setHandlers(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, SampleFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void onChangeClick(View view) {
        Log.d("DEBUG", "Change User Name");

        mUser.setName("Jiro");
        Log.d("DEBUG", mUser.getName());
    }
}
