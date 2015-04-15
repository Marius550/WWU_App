package com.example.mariuspilgrim.wwuapp;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;


public class MainActivity extends ActionBarActivity {
    private FragmentNavigationDrawer dlDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find our drawer view
        dlDrawer = (FragmentNavigationDrawer) findViewById(R.id.drawer_layout);
        // Setup drawer view
        dlDrawer.setupDrawerConfiguration((ListView) findViewById(R.id.lvDrawer), toolbar,
                R.layout.drawer_nav_item, R.id.flContent);
        // Add nav items
        dlDrawer.addNavItem(getResources().getString(R.string.menu_welcome), R.drawable.ic_one1, getResources().getString(R.string.menu_welcome_title), WelcomeFragment.class);
        dlDrawer.addNavItem(getResources().getString(R.string.menu_administration), R.drawable.ic_two2, getResources().getString(R.string.menu_administration_title), DepartmentFragment.class);
        dlDrawer.addNavItem(getResources().getString(R.string.menu_news), R.drawable.ic_three3, getResources().getString(R.string.menu_News_title), DepartmentFragment.class);
        dlDrawer.addNavItem(getResources().getString(R.string.menu_calendar), R.drawable.ic_one1, getResources().getString(R.string.menu_calendar_title), DepartmentFragment.class);
        dlDrawer.addNavItem(getResources().getString(R.string.menu_directory), R.drawable.ic_two2, getResources().getString(R.string.menu_directory_title), DepartmentFragment.class);
        dlDrawer.addNavItem(getResources().getString(R.string.menu_map), R.drawable.ic_three3, getResources().getString(R.string.menu_map_title), DepartmentFragment.class);
        dlDrawer.addNavItem(getResources().getString(R.string.menu_dining), R.drawable.ic_one1, getResources().getString(R.string.menu_dining_title), DepartmentFragment.class);
        dlDrawer.addNavItem(getResources().getString(R.string.menu_library), R.drawable.ic_one1, getResources().getString(R.string.menu_library_title), DepartmentFragment.class);
        dlDrawer.addNavItem(getResources().getString(R.string.menu_settings), R.drawable.ic_two2, getResources().getString(R.string.menu_settings_title), DepartmentFragment.class);
        dlDrawer.addNavItem(getResources().getString(R.string.menu_about), R.drawable.ic_three3, getResources().getString(R.string.menu_about_title), DepartmentFragment.class);
        dlDrawer.addNavItem(getResources().getString(R.string.menu_feedback), R.drawable.ic_one1, getResources().getString(R.string.menu_feedback_title), ContactFragment.class);
        // Select default
        if (savedInstanceState == null) {
            dlDrawer.selectDrawerItem(0);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content
        if (dlDrawer.isDrawerOpen()) {
            // Uncomment to hide menu items
            // menu.findItem(R.id.mi_test).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Uncomment to inflate menu items to Action Bar
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (dlDrawer.getDrawerToggle().onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        dlDrawer.getDrawerToggle().syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        dlDrawer.getDrawerToggle().onConfigurationChanged(newConfig);
    }
}
