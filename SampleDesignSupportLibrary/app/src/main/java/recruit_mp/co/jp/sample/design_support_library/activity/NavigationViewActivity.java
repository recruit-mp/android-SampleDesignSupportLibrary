package recruit_mp.co.jp.sample.design_support_library.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import recruit_mp.co.jp.sample.design_support_library.R;

/**
 * Created by tazawakenji on 15/06/02.
 */
public class NavigationViewActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);


        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int itemId = menuItem.getItemId();

                if (itemId == R.id.navigation_item_1 || itemId == R.id.navigation_item_2) {
                    Toast.makeText(getApplicationContext(), menuItem.getTitle() + "が選択中になりました", Toast.LENGTH_SHORT).show();
                    menuItem.setChecked(true);
                    mDrawerLayout.closeDrawers();
                    return true;
                }

                if (itemId == R.id.navigation_sub_item_1 || itemId == R.id.navigation_sub_item_2) {
                    Toast.makeText(getApplicationContext(), menuItem.getTitle() + "を選択しました", Toast.LENGTH_SHORT).show();
                    mDrawerLayout.closeDrawers();
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
