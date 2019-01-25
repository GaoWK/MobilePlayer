package base;

import android.content.Context;
import android.view.View;

/**
 * Created by GaoWK on 2019/1/23.
 * 公共类 本地视频 网络视频 本地音乐 网络音乐的公共类
 */

public abstract class BasePager {

    public Context context;//上下文
    public View rootView;//视图 由各个子页面实例化的结果

    public BasePager(Context context) {
        this.context = context;
        rootView = initView();
    }

    /**
     * 强制孩子实现该方法 实现特定的效果
     * @return
     */
    public abstract View initView();

    /**
     * 当孩子需要初始化数据的时候，重写该方法用于请求数据
     */
    public void initData(){

    }
}
