package interview.kotlin.com.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MaShiZhao on 2018/4/9.
 */
public class MyAidlService extends Service
{

    private List<AidlBean> aidlBean;

    /**
     * 客户端与服务端绑定时的回调，返回 mIBinder 后客户端就可以通过它远程调用服务端的方法，即实现了通讯
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        aidlBean = new ArrayList<>();
        return mIBinder;
    }


    /**
     * 创建生成的本地 Binder 对象，实现 AIDL 制定的方法
     */
    private IBinder mIBinder = new MyAidl.Stub()
    {
        @Override
        public void addPerson(AidlBean bean) throws RemoteException
        {
            if (aidlBean != null)
            {
                aidlBean.add(bean);
            }
        }

        @Override
        public List<AidlBean> getPersons() throws RemoteException
        {
            return aidlBean;
        }
    };

}
