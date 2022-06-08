package beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

//事件
public class Event {

    private int id;//主键
    private String sTime;//开始事件
    private String eTime;//结束时间
    private String text;//事件内容描述
    private String title;//事件的标题
    private int situation;//事件的状态,1表示正在进行，2表示已结束

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    public String getStartTime() {
        return sTime;
    }

    public void setStartTime(String startTime) {
        this.sTime = startTime;
    }

    public String getEndTime() {
        return eTime;
    }

    public void setEndTime(String endTime) {
        this.eTime = endTime;
    }

    public String getDescription() {
        return text;
    }

    public void setDescription(String description) {
        this.text = description;
    }
}
