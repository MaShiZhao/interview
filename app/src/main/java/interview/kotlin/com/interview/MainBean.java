package interview.kotlin.com.interview;

/**
 * Created by MaShiZhao on 2018/3/26.
 *
 */
public class MainBean
{
    private String name; //展示的名称
    private Class newClass; // 跳转的activity
    private String url; //跳转地址


    public MainBean(String name, Class newClass)
    {
        this.name = name;
        this.newClass = newClass;
    }

    public MainBean(String name, String url)
    {
        this.name = name;
        this.url = url;
    }

    public Class getNewClass()
    {
        return newClass;
    }

    public void setNewClass(Class newClass)
    {
        this.newClass = newClass;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
