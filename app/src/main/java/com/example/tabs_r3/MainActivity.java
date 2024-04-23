package com.example.tabs_r3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // hooks
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MyTabAdapter myTabAdapter;

    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager2);
        myTabAdapter = new MyTabAdapter(this);

        viewPager2.setAdapter(myTabAdapter);

        TabLayoutMediator TLM =
                new TabLayoutMediator(
                        tabLayout,
                        viewPager2,
                        new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position)
                        {
                            case 0:
                                tab.setText("Calls");
                                tab.setIcon(R.drawable.ic_calls);
                                BadgeDrawable bd = tab.getOrCreateBadge();
                                bd.setNumber(122);
                                bd.setMaxCharacterCount(3);

                                bd.setVisible(true);

                                break;
                            case 1:
                                tab.setText("Chats");
                                tab.setIcon(R.drawable.ic_chats);
                                BadgeDrawable bd1 = tab.getOrCreateBadge();
                                bd1.setNumber(45);
                                bd1.setMaxCharacterCount(3);
                                break;
                            default:
                                tab.setText("Contacts");
                                tab.setIcon(R.drawable.ic_contacts);
                                BadgeDrawable bd2 = tab.getOrCreateBadge();
                                bd2.setNumber(122);
                                bd2.setMaxCharacterCount(3);
                        }
                    }
                });

        TLM.attach();



        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                if(position==0)
                {
                    if(count==1) {
                        BadgeDrawable bd = Objects.requireNonNull(tabLayout.getTabAt(position)).getOrCreateBadge();
                        bd.setVisible(false);
                        bd.setNumber(0);
                    }
                    count++;


                }else{
                BadgeDrawable bd = Objects.requireNonNull(tabLayout.getTabAt(position)).getOrCreateBadge();
                bd.setVisible(false);
                bd.setNumber(0);
                }
            }
        });

    }
}