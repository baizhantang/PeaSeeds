package cc.jethro.peaseeds;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jethro on 2017/1/5.
 */

public class ActivityCollector {
    public static List<Activity> activityList= new ArrayList<>();

    public static void addActivity(Activity activity){
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity){
        activityList.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity: activityList) {
            activity.finish();
        }
    }
}
