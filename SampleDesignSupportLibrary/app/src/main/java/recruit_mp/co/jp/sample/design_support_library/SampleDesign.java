package recruit_mp.co.jp.sample.design_support_library;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import recruit_mp.co.jp.sample.design_support_library.activity.CoordinatorLayout;
import recruit_mp.co.jp.sample.design_support_library.activity.CoordinatorLayoutCollapsingToolbarActivity;
import recruit_mp.co.jp.sample.design_support_library.activity.CoordinatorLayoutFABScrollingActivity;
import recruit_mp.co.jp.sample.design_support_library.activity.CoordinatorLayoutToolBarScrollingActivity;
import recruit_mp.co.jp.sample.design_support_library.activity.FloatingActionButtonActivity;
import recruit_mp.co.jp.sample.design_support_library.activity.NavigationViewActivity;
import recruit_mp.co.jp.sample.design_support_library.activity.SnackbarActivity;
import recruit_mp.co.jp.sample.design_support_library.activity.TabsActivity;
import recruit_mp.co.jp.sample.design_support_library.activity.TabsViewPagerActivity;
import recruit_mp.co.jp.sample.design_support_library.activity.TextInputLayoutActivity;


/**
 * Created by tazawakenji on 15/06/02.
 */
public enum SampleDesign {

    NavigationView(R.string.navigation_view, NavigationViewActivity.class),
    TextInputLayout(R.string.text_input_layout, TextInputLayoutActivity.class),
    FloatingActionButton(R.string.floating_action_button, FloatingActionButtonActivity.class),
    Snackbar(R.string.snackbar, SnackbarActivity.class),
    Tab(R.string.tabLayout, TabsActivity.class),
    TabViewPager(R.string.tabLayout_viewpager, TabsViewPagerActivity.class),
    CoordinatorLayout(R.string.coordinator_layout, CoordinatorLayout.class),
    CoordinatorLayoutFAB(R.string.coordinator_layout_fab, CoordinatorLayoutFABScrollingActivity.class),
    CoordinatorLayoutToolBar(R.string.coordinator_layout_toolbar_scrolling, CoordinatorLayoutToolBarScrollingActivity.class),
    CoordinatorLayoutToolbarScrolling(R.string.coordinator_layout_collapsing_toolbar, CoordinatorLayoutCollapsingToolbarActivity.class);

    private int mNameResourceId;

    private Class<?> mNextActivity;

    SampleDesign(int nameResourceId, Class<?> nextActivity) {
        mNameResourceId = nameResourceId;
        mNextActivity = nextActivity;
    }

    private int getNameResourceId() {
        return mNameResourceId;
    }

    private Intent createIntent(Activity activity) {
        return new Intent(activity, mNextActivity);
    }

    public String getName(Context context) {
        return context.getResources().getString(getNameResourceId());
    }

    public void transition(Activity activity) {
        activity.startActivity(createIntent(activity));
    }


}
