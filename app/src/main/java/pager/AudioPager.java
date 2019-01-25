package pager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import base.BasePager;

/**
 * Created by GaoWK on 2019/1/23.
 */

public class AudioPager extends BasePager {
    private TextView textView;

    public AudioPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView = new TextView(context);
        return textView;
    }

    @Override
    public void initData() {
        textView.setText("我是本地音频");
    }
}
