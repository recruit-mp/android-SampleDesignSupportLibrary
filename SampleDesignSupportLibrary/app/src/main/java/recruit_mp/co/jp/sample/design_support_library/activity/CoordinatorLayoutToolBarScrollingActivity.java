package recruit_mp.co.jp.sample.design_support_library.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import recruit_mp.co.jp.sample.design_support_library.R;
import recruit_mp.co.jp.sample.design_support_library.SimpleRecyclerAdapter;


public class CoordinatorLayoutToolBarScrollingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_toolbar_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        initRecyclerView();

    }

    private void initRecyclerView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add("index : " + i);
        }

        SimpleRecyclerAdapter adapter = new SimpleRecyclerAdapter(this, list);
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
