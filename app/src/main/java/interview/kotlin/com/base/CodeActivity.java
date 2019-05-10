package interview.kotlin.com.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by MaShiZhao on 2018/3/27.
 */
public class CodeActivity extends BaseActivity
{

    public static void startActivity(Context context, String content)
    {
        context.startActivity(new Intent(context, CodeActivity.class).putExtra(CODE, content));
    }

    public static String CODE = "CODE";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("源码");
        setShowMenu(false);

        final String contentString = getIntent().getExtras().getString(CODE);
        if (contentString != null)
        {
            setContentTextView(contentString);
        }

        getContentTextView().setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (contentString.toLowerCase().startsWith("http"))
                {
                    Intent intent= new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    Uri content_url = Uri.parse(contentString);
                    intent.setData(content_url);
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public void gotoActivity(String c)
    {
//        super.startActivity();
    }
}
