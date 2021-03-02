package com.example.e_commerceandroidapplication;

import android.annotation.SuppressLint;
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

    ViewPager pager;
    BottomNavigationView navigation_bar;
    Toolbar tool_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        navigation_bar = findViewById(R.id.navigation_bar);

        settingUpToolbar();
        settingUpViewPager();
        linkViewpagerAndNavbar();


    }

    private void settingUpToolbar() {
        tool_bar = findViewById(R.id.tool_bar);
        setSupportActionBar(tool_bar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_cart) {
            Toast.makeText(MainActivity.this, "Action caddy clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_search) {
            Toast.makeText(MainActivity.this, "Action search clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void settingUpViewPager() {
        PagerAdapter pager_adapter = new PagerAdapter(getSupportFragmentManager(), 0);
        pager.setAdapter(pager_adapter);
        pager.setCurrentItem(0);
    }

    private void setToolBarTitle(int resource) {
        getSupportActionBar().setTitle(getString(resource));
    }

    @SuppressLint("NonConstantResourceId")
    private void linkViewpagerAndNavbar() {

        navigation_bar.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.page_0:
                            pager.setCurrentItem(0);
                            setToolBarTitle(R.string.app_name);
                            break;
                        case R.id.page_1:
                            pager.setCurrentItem(1);
                            setToolBarTitle(R.string.category);
                            break;
                        case R.id.page_2:
                            pager.setCurrentItem(2);
                            setToolBarTitle(R.string.help);
                            break;
                        case R.id.page_3:
                            pager.setCurrentItem(3);
                            setToolBarTitle(R.string.profile);
                            break;
                    }
                    return false;
                });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //Faites glisser vers une page pour sélectionner la barre de navigation inférieure
                navigation_bar.getMenu().getItem(position).setChecked(true);

                switch (position) {
                    case 0:
                        setToolBarTitle(R.string.app_name);
                        break;
                    case 1:
                        setToolBarTitle(R.string.category);
                        break;
                    case 2:
                        setToolBarTitle(R.string.help);
                        break;
                    case 3:
                        setToolBarTitle(R.string.profile);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}