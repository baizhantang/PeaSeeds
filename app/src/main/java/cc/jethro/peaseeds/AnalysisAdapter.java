package cc.jethro.peaseeds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jethro on 2016/12/13.
 */

public class AnalysisAdapter extends ArrayAdapter<AnalysisData> {
    List<AnalysisData> mAnalysisDataList;
    private int resourceId;
    //获取数据集合以及item的ID
    public AnalysisAdapter(Context context, int resource, List<AnalysisData> objects) {
        super(context, resource, objects);
        resourceId=resource;
        mAnalysisDataList = objects;
    }

    /**
     * 将数据绑定到itemView中
     * @param position 指针，表示现在读取第几条数据
     * @param convertView itemView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        AnalysisData analysisData = getItem(position);
        ViewHolder viewHolder ;
        //如果view是空的，就初始化视图，把视图缓存到ViewHolder中
        //这个避免了程序重复读取view的ID
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) view.findViewById(R.id.title_item);
            viewHolder.text = (TextView) view.findViewById(R.id.data_item);
            view.setTag(viewHolder);
        }else {
            //如果view不是空的，从缓存中取出来
            view=convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //绑定数据
        viewHolder.title.setText(analysisData.getTitle());
        //因为数据是int类型的，这里要转化为String才能传进.setText()
        String data = ""+analysisData.getData();
        viewHolder.text.setText(data);
        return view;
    }

    //缓存视图中控件的ID
    class ViewHolder{
        TextView title;
        TextView text;
    }
}
