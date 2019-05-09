package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by MaShiZhao on 2018/4/20.
 */
public class TestClass2
{

    String string =  "good";
    char ch[] = {'1', '2'};

    public static void main(String[] args)
    {


        Set<Integer> set =    new HashSet<>();
        set.add(null);
        set.add(0);
        set.add(null);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(null);

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);
        hashMap.put(2,2);
        hashMap.put(null,2);
        hashMap.put(null,4);
        hashMap.put(4,null);

        System.out.println(hashMap.size());

    }

    private void change(String string, char[] ch)
    {
        string = "g";
        ch[0] = '2';
    }

    private static int water = 100;

    private static void hxy(int count)
    {
        if (count < 2)
        {
            return;
        }

        int i = count / 2;
        int j = count % 2;

        water = water + i;

        hxy(i + j);
    }


    /**
     * @param x 总钱数
     * @param y 每瓶水的价格
     * @param k 几个瓶盖可以兑换
     * @return count 总共水的瓶水
     */
    private static int hxy2(int x, int y, int k)
    {
        int count = x / y;

        int j = count; //当前的瓶盖

        while (j > k - 1)
        {
            count += j / k;
            j = j % k + j / k;
        }

        return count;
    }
}
