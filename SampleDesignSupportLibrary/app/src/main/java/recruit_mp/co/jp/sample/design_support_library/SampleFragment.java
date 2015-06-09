package recruit_mp.co.jp.sample.design_support_library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tazawakenji on 15/06/06.
 */
public class SampleFragment extends Fragment {

    private static final String KEY = "hoge";

    private int mHoge;
    private TextView mTextView;

    public static SampleFragment newInstance(int hoge) {

        Bundle bundle = new Bundle();
        bundle.putInt(KEY, hoge);

        SampleFragment sampleFragment = new SampleFragment();
        sampleFragment.setArguments(bundle);

        return sampleFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments.containsKey(KEY)) {
            mHoge = arguments.getInt(KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sample, container, false);
        mTextView = (TextView) view.findViewById(R.id.sample_text);
        mTextView.setText(String.valueOf(mHoge));

        return view;
    }
}
