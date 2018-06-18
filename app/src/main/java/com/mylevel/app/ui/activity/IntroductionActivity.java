package com.mylevel.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mylevel.app.R;

public class IntroductionActivity extends AppCompatActivity {
    private int[] layouts;
    private Button btnSkip;
    private LinearLayout dotLayout;

    public static Intent getIntent(Context context) {
        return new Intent(context, IntroductionActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        ViewPager viewPager = findViewById(R.id.viewPager);
        dotLayout = findViewById(R.id.viewDots);
        btnSkip = findViewById(R.id.btnSkip);
        btnSkip.setOnClickListener(v -> onSkip());
        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.layout_slide_a,
                R.layout.layout_slide_b,
                R.layout.layout_slide_c,
                R.layout.layout_slide_d};

        //adding bottom dots
        addBottomDots(0);


        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter();
        viewPager.setAdapter(sectionPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


    }

    void onSkip() {
        startActivity(LoginActivity.getIntent(this));
    }


    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btnSkip.setText(getString(R.string.text_start));
            }else{
                btnSkip.setText(getString(R.string.skip));
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void addBottomDots(int currentPage) {
        TextView[] dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }


    class SectionPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        SectionPagerAdapter() {

        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert layoutInflater != null;
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

}
