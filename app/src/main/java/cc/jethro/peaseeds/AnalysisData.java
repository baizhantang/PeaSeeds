package cc.jethro.peaseeds;

/**
 * Created by jethro on 2016/12/13.
 */

public class AnalysisData {
    private String title;  //标题
    private int data; //数据

    public AnalysisData(String title, int data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
