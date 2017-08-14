package com.dublick.dotindicator;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    PageAdapter pageAdapter;
    DotIndicator dotIndicator;
    Button btnNext;

    private int countDescriptionScannerPage = 3;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setTypeface(SingletonFonts.getInstance(this).getFont1());
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(++currentPage, true);
                pageAdapter.notifyDataSetChanged();
            }
        });

        showDescriptionScannerPageViewer();
    }

    private void showDescriptionScannerPageViewer() {
        if (pager == null) {
            dotIndicator = (DotIndicator) findViewById(R.id.dotIndicator);
            dotIndicator.setNumberOfItems(countDescriptionScannerPage);

            pager = (ViewPager) findViewById(R.id.pager);
            pageAdapter = new PageAdapter(getSupportFragmentManager());
            pager.setAdapter(pageAdapter);
            pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

                @Override
                public void onPageSelected(int position) {
                    dotIndicator.setSelectedItem(position, true);
                    currentPage = position;
                    if (currentPage == (countDescriptionScannerPage - 1)) {
                        btnNext.setVisibility(View.GONE);
                    }
                    else {
                        btnNext.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {}
            });
        }
        dotIndicator.setVisibility(View.VISIBLE);
        pager.setVisibility(View.VISIBLE);
    }


    public class PageAdapter extends FragmentStatePagerAdapter {

        public PageAdapter(android.support.v4.app.FragmentManager mgr) {
            super(mgr);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return (FragmentPager.newInstance(position));
        }

        @Override
        public int getCount() {
            return countDescriptionScannerPage;
        }
    }

}
