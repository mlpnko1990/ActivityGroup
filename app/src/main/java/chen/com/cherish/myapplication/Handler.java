package chen.com.cherish.myapplication;

import android.view.View;
import android.widget.FrameLayout;
import java.util.Map;

/**
 * Created by cherish on 2015/7/12.
 */
public class Handler {
    public static void SwitchView(FrameLayout frameLayout, View view
            , Map map) {
        frameLayout.bringChildToFront((View) map.get(new Integer(view.getId())));
        frameLayout.invalidate();
    }
}

