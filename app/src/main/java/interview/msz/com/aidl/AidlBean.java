package interview.msz.com.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MaShiZhao on 2018/4/9.
 */
public class AidlBean implements Parcelable
{
    private String name;
    private String description;


    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.name);
        dest.writeString(this.description);
    }

    public AidlBean()
    {
    }

    public AidlBean(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    protected AidlBean(Parcel in)
    {
        this.name = in.readString();
        this.description = in.readString();
    }

    public static final Creator<AidlBean> CREATOR = new Creator<AidlBean>()
    {
        @Override
        public AidlBean createFromParcel(Parcel source)
        {
            return new AidlBean(source);
        }

        @Override
        public AidlBean[] newArray(int size)
        {
            return new AidlBean[size];
        }
    };
}
