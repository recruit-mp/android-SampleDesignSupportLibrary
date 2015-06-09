package recruit_mp.co.jp.sample.design_support_library.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import recruit_mp.co.jp.sample.design_support_library.R;


public class SnackbarActivity extends AppCompatActivity {

    private RelativeLayout mParentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mParentLayout = (RelativeLayout) findViewById(R.id.snackbar_layout);
        findViewById(R.id.show_snack_bar_no_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbarNoAction();
            }
        });

        findViewById(R.id.show_snack_bar_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackAction();
            }
        });

        findViewById(R.id.show_custom_snack_bar_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomSnackbarAction();
            }
        });
    }

    private void showSnackbarNoAction() {
        Snackbar.make(mParentLayout, "Test", Snackbar.LENGTH_SHORT).show();
    }


    private void showSnackAction() {
        Snackbar.make(mParentLayout, "Action Test", Snackbar.LENGTH_LONG).
                setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Action", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    private void showCustomSnackbarAction() {
        Snackbar snackbar = Snackbar.make(mParentLayout, "Test", Snackbar.LENGTH_SHORT).
                setActionTextColor(getResources().getColor(android.R.color.holo_red_dark));
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.bg_brand));
        snackbar.setAction("Action", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Action", Toast.LENGTH_SHORT).show();
            }
        }).show();
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
