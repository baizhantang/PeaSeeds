package cc.jethro.peaseeds;

import org.litepal.crud.DataSupport;


/**
 * 记录豌豆的sql数据表
 * Created by jethro on 2017/1/3.
 */

public class Data extends DataSupport{
    private int id;
    private int peaNumber;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeaNumber() {
        return peaNumber;
    }

    public void setPeaNumber(int peaNumber) {
        this.peaNumber = peaNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
