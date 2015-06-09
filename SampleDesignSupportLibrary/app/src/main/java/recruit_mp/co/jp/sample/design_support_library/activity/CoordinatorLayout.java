package recruit_mp.co.jp.sample.design_support_library.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import recruit_mp.co.jp.sample.design_support_library.R;


public class CoordinatorLayout extends AppCompatActivity {

    private View mView;
    private float mMoveDistance;
    private float mScaleValue = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mView = findViewById(R.id.square_view);
        findViewById(R.id.move_right_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoveDistance += 50f;
                move();
            }
        });
        findViewById(R.id.move_left_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoveDistance -= 50f;
                move();
            }
        });
        findViewById(R.id.scale_up_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScaleValue += 0.1f;
                scale();
            }
        });
        findViewById(R.id.scale_down_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScaleValue -= 0.1f;
                scale();
            }
        });
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void move() {
        mView.setTranslationX(mMoveDistance);
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void scale() {
        mView.setScaleY(mScaleValue);
        mView.setScaleX(mScaleValue);
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
