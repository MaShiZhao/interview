package interview.msz.com.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import interview.msz.com.interview.R;

/**
 * Created by MaShiZhao on 2018/4/9.
 */
public class AidlClientActivity extends FragmentActivity
{

    private MyAidl myAidl;

    private ServiceConnection serviceConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            myAidl = MyAidl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            myAidl = null;
        }
    };

    private Button btn;
    private TextView content;

    AidlBean aidlBean = new AidlBean("姓名", "简介");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_aidl);

        btn = (Button) findViewById(R.id.btn);
        content = (TextView) findViewById(R.id.receiver_content);

        bindService(new Intent(AidlClientActivity.this, MyAidlService.class), serviceConnection, BIND_AUTO_CREATE);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    myAidl.addPerson(aidlBean);

                    content.setText(myAidl.getPersons().toString());

                } catch (RemoteException e)
                {
                    e.printStackTrace();
                }

            }
        });

    }
}
