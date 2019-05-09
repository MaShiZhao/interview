package interview.msz.com.baseActivity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MaShiZhao on 2018/4/9.
 */
public class DemoBean implements Parcelable
{
    private String name;
    private String number;
    private int age;


    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.name);
        dest.writeString(this.number);
        dest.writeInt(this.age);
    }

    public DemoBean()
    {
    }

    protected DemoBean(Parcel in)
    {
        this.name = in.readString();
        this.number = in.readString();
        this.age = in.readInt();
    }

    public static final Creator<DemoBean> CREATOR = new Creator<DemoBean>()
    {
        @Override
        public DemoBean createFromParcel(Parcel source)
        {
            return new DemoBean(source);
        }

        @Override
        public DemoBean[] newArray(int size)
        {
            return new DemoBean[size];
        }
    };
}
