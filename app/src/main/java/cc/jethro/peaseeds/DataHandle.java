package cc.jethro.peaseeds;

import android.app.Activity;
import android.util.Log;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by jethro on 2017/1/4.
 */

public class DataHandle {

    public static List<AnalysisData> analysisDatas = new ArrayList<>();

    //添加一条数据
    public static void add() {
        Connector.getDatabase();
        Data data = new Data();
        data.setPeaNumber(0);
        //将日期格式化
        SimpleDateFormat df = (SimpleDateFormat) DateFormat.getDateInstance();
        df.applyPattern("yyyy-MM-dd");
        String nowDate = df.format(new Date());
        data.setTime(nowDate);
        data.save();
    }

    //更新最新的那条数据
    public static void upData() {
        Data data = DataSupport.findLast(Data.class);
        Date nowDate = new Date();
        Date date;

        //将从数据库中的日期解析成Date
        SimpleDateFormat df = (SimpleDateFormat) DateFormat.getDateInstance();
        df.applyPattern("yyyy-MM-dd");
        try {
            date = df.parse(data.getTime());
        } catch (ParseException e) {
            date = new Date();
            e.printStackTrace();
        }

        //计算现在日期距离上次更新的日期有多少天
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long time = cal.getTimeInMillis();
        cal.setTime(nowDate);
        long nowTime = cal.getTimeInMillis();
        long between_days = (nowTime - time) / (1000 * 3600 * 24);
        int day = Integer.parseInt(String.valueOf(between_days));
        //根据相差的时间可以得出软件距离上次开启软件的时间，也就是软件未启动期间获得的豌豆的数量


        data.setTime(df.format(nowDate));
        //将已获得的豌豆和软件未启动期间获得的豌豆相加
        data.setPeaNumber(data.getPeaNumber() + day);
        String id = "" + data.getId();
        data.updateAll("id=?", id);
    }

    //查询数据
    public static List<AnalysisData> queryData() {
        //获取Activity实例，用于获取String字符串资源
        Activity activity = ActivityCollector.activityList.get(ActivityCollector.activityList.size() - 1);

        //拥有过最多的豌豆
        List<Data> datas = DataSupport.select("peaNumber").order("peaNumber desc").find(Data.class);
        Data data = datas.get(0);
        AnalysisData maxpeaNumber = new AnalysisData(activity.getString(R.string.maxpea_number), data.getPeaNumber());

        //一共获得了多少豌豆
        int allPea = 0;
        for (Data data2 : datas) {
            allPea = allPea + data2.getPeaNumber();
        }
        AnalysisData allPeaNumber = new AnalysisData(activity.getString(R.string.allPea_number), allPea);

        //守护失败的次数
        int failed = datas.size() - 1;
        AnalysisData failedNumber = new AnalysisData(activity.getString(R.string.failed_number), failed);

        //目前拥有的豌豆
        Data data3 = DataSupport.findLast(Data.class);
        AnalysisData nowPeaNumber = new AnalysisData(activity.getString(R.string.now_pea_number), data3.getPeaNumber());

        //上次豌豆保护记录
        AnalysisData lastTimePeaNumber = null;
        if(datas.size() >= 2){
            List<Data> datas1 = DataSupport.order("id desc").find(Data.class);
            Data data4 = datas1.get(1);
            lastTimePeaNumber = new AnalysisData(activity.getString(R.string.last_time_pea_number), data4.getPeaNumber());
        }

        //将拉取到的数据添加到List集合，用于listView适配器
        analysisDatas.add(nowPeaNumber);
        if(lastTimePeaNumber != null){
            analysisDatas.add(lastTimePeaNumber);
        }
        analysisDatas.add(maxpeaNumber);
        analysisDatas.add(failedNumber);
        analysisDatas.add(allPeaNumber);

        return analysisDatas;
    }
}
