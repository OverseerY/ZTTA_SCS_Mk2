package xyz.yaroslav.scs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TagItem {
    private String uid;
    private String payload;
    private String sTime;

    public TagItem() {}

    public TagItem(String uid, String payload, String sTime) {
        this.uid = uid;
        this.payload = payload;
        this.sTime = sTime;
    }

    public TagItem(String uid, String payload) {
        this.uid = uid;
        this.payload = payload;
    }

    public String getUid() {
        return uid;
    }

    public String getPayload() {
        return payload;
    }

    public String getsTime() {
        return sTime;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("tag_id", getUid());
        result.put("tag_name", getPayload());
        result.put("tag_time", getsTime());

        return result;
    }

    public Map<String, Object> toWhiteListMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("tag_id", getUid());
        result.put("tag_data", getPayload());

        return result;
    }

    public static Comparator<TagItem> TagComparator = (item1, item2) -> {
        String tagTime1 = item1.getsTime().toUpperCase();
        String tagTime2 = item2.getsTime().toUpperCase();
        return tagTime2.compareTo(tagTime1);
    };

    public static Comparator<TagItem> WhitelistComparator = (item1, item2) -> {
        String tagName1 = item1.getPayload().toUpperCase();
        String tagName2 = item2.getPayload().toUpperCase();
        return tagName1.compareTo(tagName2);
    };
}
