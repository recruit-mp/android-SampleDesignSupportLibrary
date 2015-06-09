package recruit_mp.co.jp.sample.design_support_library.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import recruit_mp.co.jp.sample.design_support_library.R;
import recruit_mp.co.jp.sample.design_support_library.SampleFragment;


public class TabsViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_viewpager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mViewPager = (ViewPager) findViewById(R.id.view_pager);


        initTabLayout();
    }

    private void initTabLayout() {

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.bg_brand));

        PagerAdapter pagerAdapter = new PagerAdapter(TabsViewPagerActivity.this, mViewPager);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    static class PagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

        private static final int PAGE_COUNT = 10;

        private ViewPager mViewPager;

        public PagerAdapter(AppCompatActivity activity, ViewPager viewPager) {
            super(activity.getSupportFragmentManager());
            mViewPager = viewPager;
            mViewPager.setAdapter(this);
            mViewPager.addOnPageChangeListener(this);
        }


        @Override
        public Fragment getItem(int position) {
            SampleFragment sampleFragment = SampleFragment.newInstance(position);
            return sampleFragment;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Title " + position;
        }
    }
}
