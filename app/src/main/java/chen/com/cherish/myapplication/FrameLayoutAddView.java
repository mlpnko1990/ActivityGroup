package chen.com.cherish.myapplication;

import android.view.View;
import android.widget.FrameLayout;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by cherish on 2015/7/12.
 */
public class FrameLayoutAddView {
    public static void addView(Map map, FrameLayout frameLayout) {
        //hashMap的高效遍历
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            frameLayout.addView((View) val);

        }
    }
}
