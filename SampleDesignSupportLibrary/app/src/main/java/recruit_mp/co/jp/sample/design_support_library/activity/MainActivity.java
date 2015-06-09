package recruit_mp.co.jp.sample.design_support_library.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import recruit_mp.co.jp.sample.design_support_library.R;
import recruit_mp.co.jp.sample.design_support_library.SampleDesign;


public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<SampleDesign> mSampleList = Arrays.asList(SampleDesign.values());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.main_list);
        SampleAdapter sampleAdapter = new SampleAdapter(MainActivity.this, android.R.layout.simple_list_item_1, mSampleList);
        mListView.setAdapter(sampleAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SampleDesign sampleDesign = (SampleDesign) parent.getItemAtPosition(position);
                sampleDesign.transition(MainActivity.this);
            }
        });
    }


    private class SampleAdapter extends ArrayAdapter<SampleDesign> {

        private LayoutInflater mInflater;

        public SampleAdapter(Context context, int resource, List<SampleDesign> objects) {
            super(context, resource, objects);
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;
            View view = convertView;

            if (view == null) {
                view = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            SampleDesign sampleDesign = getItem(position);
            viewHolder.text.setText(sampleDesign.getName(getContext()));

            return view;
        }
    }

    static class ViewHolder {

        TextView text;

        public ViewHolder(View view) {

            text = (TextView) view.findViewById(android.R.id.text1);
        }
    }

}
