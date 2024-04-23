package com.example.tabs_r3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyTabAdapter extends FragmentStateAdapter {

    public MyTabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new CallFragment();
            case 1:
                return new ChatFragment();
            default:
                return new ContactFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
