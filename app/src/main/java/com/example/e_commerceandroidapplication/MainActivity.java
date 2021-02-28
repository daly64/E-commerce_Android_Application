package com.example.e_commerceandroidapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.e_commerceandroidapplication.adapters.PagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager VpList;
    BottomNavigationView BnvBar;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VpList = findViewById(R.id.pager);
        BnvBar = findViewById(R.id.bottomNavBar);

        setting_up_toolbar();
        setting_up_viewpager();
        link_viewpager_and_navbar();


    }

    private void setting_up_toolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_caddy) {
            Toast.makeText(MainActivity.this, "Action caddy clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_search) {
            Toast.makeText(MainActivity.this, "Action search clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setting_up_viewpager() {
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 0);
        VpList.setAdapter(pagerAdapter);
        VpList.setCurrentItem(0);
    }

    private void link_viewpager_and_navbar() {

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