package com.spideriot.kkt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.spideriot.kkt.fragment.HomeExchangeFragment;
import com.spideriot.kkt.fragment.HomeMineFragment;
import com.spideriot.kkt.fragment.HomeProfitFragment;
import com.spideriot.kkt.fragment.HomePromoteFragment;

public class MainActivity extends AppCompatActivity {

    private final Fragment[] fragments = {
            HomeProfitFragment.newInstance(),
            HomePromoteFragment.newInstance(),
            HomeExchangeFragment.newInstance(),
            HomeMineFragment.newInstance()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((RadioButton) findViewById(R.id.profit)).setChecked(true);

//        final ViewPager viewPager = findViewById(R.id.viewPager);
//        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @Override
//            public int getCount() {
//                return titles.length;
//            }
//
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return titles[position];
//            }
//
//            @Override
//            public Fragment getItem(int position) {
//                return fragments[position];
//            }
//        });
//
//        ((TabLayout) findViewById(R.id.title_tab)).setupWithViewPager(viewPager);

        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
//        boolean hide = false;
        for (Fragment fragment : fragments) {
            fm.add(R.id.fragment, fragment);
            fm.hide(fragment);
        }
        fm.show(fragments[0]).commit();

        ((RadioGroup) findViewById(R.id.home_bottom)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
//                for (Fragment fragment : fragments) {
//                    fm.hide(fragment);
//                }
//                fm.show(fragments[group.indexOfChild(group.findViewById(checkedId))]).commit();
                fm.replace(R.id.fragment, fragments[group.indexOfChild(group.findViewById(checkedId))]).commit();
//                Toast.makeText(MainActivity.this, "" + group.indexOfChild(group.findViewById(checkedId)), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
