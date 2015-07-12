package chen.com.cherish.myapplication;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.view.View;

/**
 * Created by cherish on 2015/7/12.
 */
public class GetView {

    private Intent intent;
    private View view;
    private int count = 1;

    public View getView(Activity mainAct, Activity childAct,
                        LocalActivityManager localActivityManager) {
        count++;
        intent = new Intent(mainAct, childAct.getClass());
        view = localActivityManager.startActivity("page" + count, intent)
                .getDecorView();
        return view;
    }
}
