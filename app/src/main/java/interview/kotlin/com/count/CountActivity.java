package interview.kotlin.com.count;

import android.os.Bundle;
import android.support.annotation.Nullable;

import interview.kotlin.com.base.BaseActivity;

/**
 * Created by MaShiZhao on 2018/4/19.
 */
public class CountActivity extends BaseActivity
{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setTitle("算法");


        String quickSort ="把整个序列看做一个数组，把第零个位置看做中轴，和最后一个比，如果比它小交换，比它大不做任何处理；交换了以后再和小的那端比，比它小不交换，比他大交换。这样循环往复，一趟排序完成，左边就是比中轴小的，右边就是比中轴大的，然后再用分治法，分别对这两个独立的数组进行排序。\n" +
                "    private static void quickSort(int[] a, int left, int right)\n" +
                "    {\n" +
                "        if (left >= right) return;\n" +
                "\n" +
                "\n" +
                "        int i = left;\n" +
                "        int j = right;\n" +
                "        int temp = a[left];\n" +
                "\n" +
                "        while (i != j)\n" +
                "        {\n" +
                "            while (a[j] >= temp)\n" +
                "            {\n" +
                "                j--;\n" +
                "            }\n" +
                "\n" +
                "            if (j > i)\n" +
                "            {\n" +
                "                a[i] = a[j];\n" +
                "            }\n" +
                "\n" +
                "            while (a[i] <= temp)\n" +
                "            {\n" +
                "                i++;\n" +
                "            }\n" +
                "            a[j] = a[i];\n" +
                "        }\n" +
                "\n" +
                "        a[i] = temp;\n" +
                "\n" +
                "        quickSort(a, left, i - 1);\n" +
                "        quickSort(a, i + 1, right);\n" +
                "\n" +
                "    }";

        String selectSort =" /**\n" +
                " * 选择排序算法\n" +
                " * 在未排序序列中找到最小元素，存放到排序序列的起始位置  \n" +
                " * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。 \n" +
                " * 以此类推，直到所有元素均排序完毕。 \n" +
                " * @param numbers\n" +
                " */\n" +
                "    private static void selectSort(int[] num)\n" +
                "    {\n" +
                "        int k;\n" +
                "        int temp;\n" +
                "\n" +
                "        for (int i = 0; i < num.length; i++)\n" +
                "        {\n" +
                "\n" +
                "            k = i;\n" +
                "            for (int j = num.length - 1; j > i; j--)\n" +
                "            {\n" +
                "\n" +
                "                if (num[j] < num[k])\n" +
                "                {\n" +
                "                    k = j;\n" +
                "                }\n" +
                "            }\n" +
                "\n" +
                "            temp = num[i];\n" +
                "            num[i] = num[k];\n" +
                "            num[k] = temp;\n" +
                "\n" +
                "        }\n" +
                "    }";

        String BinarySearch ="\n" +
                "    private static int BinarySearch(int[] num, int key)\n" +
                "    {\n" +
                "\n" +
                "\n" +
                "        //查找范围的上下界\n" +
                "        int low = 0;\n" +
                "        int high = num.length - 1;\n" +
                "        //未查找到的返回值\n" +
                "        int notFind = -1;\n" +
                "\n" +
                "        while (low < high)\n" +
                "        {\n" +
                "            int mid = low + (high - low) / 2;\n" +
                "\n" +
                "            if (num[mid] > key)\n" +
                "            {\n" +
                "                high = mid + 1;\n" +
                "            } else if (num[mid] < key)\n" +
                "            {\n" +
                "                low = mid - 1;\n" +
                "            } else\n" +
                "            {\n" +
                "                return mid;\n" +
                "            }\n" +
                "\n" +
                "        }\n" +
                "        return notFind;\n" +
                "        \n" +
                "    }\n";


        String insertSort ="* 插入排序\n" +
                " * \n" +
                " * 从第一个元素开始，该元素可以认为已经被排序\n" +
                " * 取出下一个元素，在已经排序的元素序列中从后向前扫描 \n" +
                " * 如果该元素（已排序）大于新元素，将该元素移到下一位置  \n" +
                " * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置  \n" +
                " * 将新元素插入到该位置中  \n" +
                " * 重复步骤2\n" +
                "\n" +
                "作者：shadow000902\n" +
                "链接：https://www.jianshu.com/p/8c915179fd02\n" +
                "來源：简书\n" +
                "著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。\n" +
                "\n" +
                "    private static void insertSort(int[] numbers)\n" +
                "    {\n" +
                "        int size = numbers.length;\n" +
                "        int temp = 0;\n" +
                "        int j = 0;\n" +
                "\n" +
                "        for (int i = 0; i < size; i++)\n" +
                "        {\n" +
                "\n" +
                "            temp = numbers[i];\n" +
                "\n" +
                "            for (j = i; j > 0 && numbers[j] > numbers[i]; j--)\n" +
                "            {\n" +
                "\n" +
                "                if (numbers[j] > temp)\n" +
                "                {\n" +
                "                    numbers[j] = numbers[j - 1];\n" +
                "                }\n" +
                "\n" +
                "            }\n" +
                "\n" +
                "            numbers[j] = temp;\n" +
                "            \n" +
                "        }\n" +
                "\n" +
                "    }";
        setContentTextView(quickSort+"\n\n\n"+selectSort+"\n\n\n"+BinarySearch+"\n\n\n"+insertSort);

        gotoActivity("https://www.jianshu.com/p/8c915179fd02");
    }
}
