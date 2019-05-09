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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by MaShiZhao on 2018/4/19.
 */

public class TestClass
{

    public static void main(String[] args)
    {

//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        hashMap.put(1,1);
//        hashMap.put(2,2);
//        hashMap.put(3,3);
//        hashMap.put(4,4);
//        hashMap.put(5,5);
//        hashMap.put(6,6);
//        hashMap.put(7,7);
//        hashMap.put(8,8);
//        hashMap.put(9,9);
//        hashMap.put(10,10);
//        hashMap.put(11,11);
//        hashMap.put(12,12);
//        hashMap.put(13,13);
//        hashMap.put(14,14);
//         final Set<Integer> integers = hashMap.keySet();
//        for (int i: integers)
//        {
//            System.out.println(i);
//        }

        for (int i = 0; i < 10; ++i)
        {
            System.out.println(1 ^ i);
        }

        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update("2".getBytes());
            byte messageDigest[] = digest.digest();

            System.out.println(toHexString(messageDigest));;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    private static String toHexString(byte[] b) { // String to byte
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 0x0f]);
        }
        return sb.toString();
    }


    private static void quickSort(int[] num, int left, int right)
    {
        if (left >= right) return;

        int i = left;
        int j = right;
        int temp = num[left];

        while (i < j)
        {

            while (i < j && num[j] >= temp)
            {
                j--;
            }

            if (j > i)
            {
                num[i] = num[j];
            }

            while (i < j && num[i] < temp)
            {
                i++;
            }

            if (j > i)
            {
                num[j] = num[i];
            }

        }

        num[i] = temp;

        quickSort(num, left, i - 1);
        quickSort(num, i + 1, right);

    }
}
