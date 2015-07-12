package chen.com.cherish.myapplication;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends ActivityGroup {
    private FrameLayout frameLayout;
    private LocalActivityManager localActivityManager;
    private Intent intent1, intent2;
    private View v1, v2,v3;
    private GetView getViewShow;
    private Map<Integer, View> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.f);

        localActivityManager = getLocalActivityManager();

        getViewShow = new GetView();
        //获取FrameLayout需要添加的View
        v1 = getViewShow.getView(MainActivity.this, new OneActivity(), localActivityManager);
        v2 = getViewShow.getView(MainActivity.this, new TwoActivity(), localActivityManager);
        v3 = getViewShow.getView(MainActivity.this, new ThreeActivity(), localActivityManager);
        //用一个Map存储——→方便后续的操作
        map = new HashMap<>();
        map.put(R.id.btn_Red, v1);
        map.put(R.id.btn_Green, v2);
        map.put(R.id.btn_Blue, v3);
        //添加到FrameLayout中
        FrameLayoutAddView.addView(map, frameLayout);

    }

    public void myclick(View view) {
        Handler.SwitchView(frameLayout, view, map);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
