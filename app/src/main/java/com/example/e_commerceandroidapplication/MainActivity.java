package com.example.e_commerceandroidapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.e_commerceandroidapplication.adapters.PagerAdapter;
import com.example.e_commerceandroidapplication.fragments.CategoryFragment;
import com.example.e_commerceandroidapplication.fragments.HelpFragment;
import com.example.e_commerceandroidapplication.fragments.ProfileFragment;
import com.example.e_commerceandroidapplication.fragments.RecentFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager VpList;
    BottomNavigationView BnvBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VpList = findViewById(R.id.pager);
        BnvBar = findViewById(R.id.bottomNavBar);

        settingUp_ViewPager();
        link_NavBar_to_ViewPager();
        link_ViewPager_to_NavBar();


    }

    private void settingUp_ViewPager(){
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 0);
        VpList.setAdapter(pagerAdapter);
        VpList.setCurrentItem(0);
    }
    private void link_NavBar_to_ViewPager(){
        BnvBar.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.page_0:
                            VpList.setCurrentItem(0);
                            break;
                        case R.id.page_1:
                            VpList.setCurrentItem(1);
                            break;
                        case R.id.page_2:
                            VpList.setCurrentItem(2);
                            break;
                        case R.id.page_3:
                            VpList.setCurrentItem(3);
                            break;
                    }
                    return false;
                });

    }
    private void link_ViewPager_to_NavBar(){
        VpList.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //Faites glisser vers une page pour sélectionner la barre de navigation inférieure
                BnvBar.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}