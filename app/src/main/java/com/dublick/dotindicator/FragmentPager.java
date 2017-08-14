package com.dublick.dotindicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 3dium on 14.08.2017.
 */

public class FragmentPager extends Fragment {

    TextView textView1;
    TextView textView2;
    ImageView imageView;

    private static String EXTRA_PAGE = "EXTRA_PAGE";
    private int page;

    public static FragmentPager newInstance(int page) {
        FragmentPager fragment = new FragmentPager();
        Bundle args = new Bundle();
        args.putInt(EXTRA_PAGE, page);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.page = getArguments() != null ? getArguments().getInt(EXTRA_PAGE) : 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.fragment, null);

        imageView = (ImageView) v.findViewById(R.id.img);
        imageView.setImageDrawable(getResources().getDrawable(Locale.getInstance(getActivity()).getDemoPageLocale()[page].img_id));

        textView1 = (TextView) v.findViewById(R.id.text1);
        textView1.setTypeface(SingletonFonts.getInstance(getActivity()).getFont1());
        textView1.setText(Locale.getInstance(getActivity()).getDemoPageLocale()[page].title);

        textView2 = (TextView) v.findViewById(R.id.text2);
        textView2.setTypeface(SingletonFonts.getInstance(getActivity()).getFont1());
        textView2.setText(Locale.getInstance(getActivity()).getDemoPageLocale()[page].body);

        return v;
    }

}
