package cc.jethro.peaseeds;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.litepal.crud.DataSupport;


public class MainActivity extends BaseActivity {
    //初始化组件
    private TabLayout mtabLayout;
    private ViewPager mviewPager;
    private MyFragmentPagerAdapter mFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Data data = DataSupport.findLast(Data.class);
        if(data == null){
            DataHandle.add();
        }
        DataHandle.upData();
        //如果analysisDatas里面有数据，就清理一下，以免出现重复的数据
        if(!DataHandle.analysisDatas.isEmpty()){
            DataHandle.analysisDatas.clear();
        }
        DataHandle.queryData();
    }

    public void fail(View view){
        DataHandle.add();
        DataHandle.analysisDatas.clear();
        DataHandle.upData();
        if(!DataHandle.analysisDatas.isEmpty()){
            DataHandle.analysisDatas.clear();
        }
        DataHandle.queryData();

        Toast.makeText(this,getString(R.string.loser), Toast.LENGTH_LONG).show();
    }


    private void initViews() {
        //使用适配器将ViewPager与Fragment绑定在一起
        mviewPager = (ViewPager) findViewById(R.id.viewPager);
        mFragmentPagerAdapter = new MyFragmentPagerAdapter(getFragmentManager());
        mviewPager.setAdapter(mFragmentPagerAdapter);

        //将Tab与ViewPager绑定在一起
        mtabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mtabLayout.setupWithViewPager(mviewPager);

        //获取指定位置的标签对象，页就是Tab，可以通过Tab对象修改标签的名字
        one = mtabLayout.getTabAt(0);
        two = mtabLayout.getTabAt(1);

    }



}
