//package com.example;
//
///**
// * Created by MaShiZhao on 2018/4/19.
// */
//
//public class TestClass
//{
//
//    public static void main(String[] args)
//    {
//
//        int[] t = {2, 1};
//
//
//        quickSort(t, 0, 1);
//
//        for (int i : t)
//        {
//            System.out.println(i + "");
//        }
//
//
//    }
//
//
//    private static void quickSort(int[] num, int left, int right)
//    {
//        if (left >= right) return;
//
//
//        int i = left;
//        int j = right;
//        int temp = num[left];
//
//        while (i != j)
//        {
//            System.out.println(j);
//            while (num[j] >= temp)
//            {
//                j--;
//            }
//
//            if (j > i)
//            {
//                num[i] = num[j];
//            }
//
//            while (num[i] <= temp)
//            {
//                i++;
//            }
//            num[j] = num[i];
//        }
//
//        num[i] = temp;
//
//        quickSort(num, left, i - 1);
//        quickSort(num, i + 1, right);
//
//    }
//
//    private static void selectSort(int[] num)
//    {
//        int k;
//        int temp;
//
//        for (int i = 0; i < num.length; i++)
//        {
//
//            k = i;
//            for (int j = num.length - 1; j > i; j--)
//            {
//
//                if (num[j] < num[k])
//                {
//                    k = j;
//                }
//            }
//
//            temp = num[i];
//            num[i] = num[k];
//            num[k] = temp;
//
//        }
//    }
//
//
//    private static int BinarySearch(int[] num, int key)
//    {
//
//
//        //查找范围的上下界
//        int low = 0;
//        int high = num.length - 1;
//        //未查找到的返回值
//        int notFind = -1;
//
//        while (low < high)
//        {
//            int mid = low + (high - low) / 2;
//
//            if (num[mid] > key)
//            {
//                high = mid + 1;
//            } else if (num[mid] < key)
//            {
//                low = mid - 1;
//            } else
//            {
//                return mid;
//            }
//
//        }
//        return notFind;
//
//    }
//
//
//    private static void insertSort(int[] numbers)
//    {
//        int size = numbers.length;
//        int temp = 0;
//        int j = 0;
//
//        for (int i = 0; i < size; i++)
//        {
//
//            temp = numbers[i];
//
//            for (j = i; j > 0 && numbers[j] > numbers[i]; j--)
//            {
//
//                if (numbers[j] > temp)
//                {
//                    numbers[j] = numbers[j - 1];
//                }
//
//            }
//
//            numbers[j] = temp;
//
//        }
//
//    }
//
//}
package com.example;


/**
 * Created by MaShiZhao on 2018/4/19.
 */

public final class TestClass {

    public static void main(String[] args) {

        new Child();
    }

    public  static class Parent {

        public Parent() {
            System.out.println("parent");
        }
    }

    public static class Child extends Parent {

        public Child() {
            System.out.println("child");
        }
    }

}
