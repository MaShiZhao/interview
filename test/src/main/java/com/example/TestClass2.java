package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by MaShiZhao on 2018/4/20.
 */
public class TestClass2 {

    public static void main(String[] args) {
//        int result =2;
//        int digit =2;
//        result -= digit;
//        String s = "2";
//        System.out.println(Character.digit(s.charAt(0),10));


//        Parent parent = new Child();
//        Child child = new Child();
////        parent.getName();
//
//        System.out.println(parent.Num);
//        System.out.println(child.Num);
//        Child child = new Child();
//        child.getName();

//        String string = new String("11");
//        String string2 = string;
//        System.out.println(string == string2);

        int[] ints = {2,6,1,3,9,34,27,18,28,87,2,90};
        quickSort(ints, 0, ints.length - 1);

        System.out.println(getStepNumber(3));
    }
    public static long getStepNumber(int n)  {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 4;
        }

        if (n > 3) {
            return getStepNumber(n - 1) + getStepNumber(n - 2) + getStepNumber(n - 3);
        }
        return 0;
    }
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


}
