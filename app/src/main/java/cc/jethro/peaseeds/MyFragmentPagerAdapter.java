package cc.jethro.peaseeds;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by jethro on 2016/11/19.
 */


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    Activity activity = ActivityCollector.activityList.get(ActivityCollector.activityList.size() - 1);

    private String[] mTitles = new String[]{activity.getString(R.string.tab_recording), activity.getString(R.string.tab_analysis)};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RecordingFragment();
            case 1://选中第二个标签时创建一个Fragment对象返回给ViewPager，这个对象是那个分析界面
                return new AnalysisFragment();
            default:
                return new RecordingFragment();
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}