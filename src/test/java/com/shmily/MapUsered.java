package com.shmily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 统计数组中相同元素的数量
 * Created by Administrator on 2017/3/7.
 */
public class MapUsered {

    public Map<String,Integer> getNum(String[] arr){
        Map<String,Integer> map = new HashMap<>();
        for(String few : arr){
            map.put(few , (null == map.get(few)) ? 1 : (map.get(few)+1));
        }
        return map;
    }


    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        String str = "adgagffuddbbkpll";
        String[] array = str.split("");
        /*for (String i : array){
            System.out.println("--"+i);
        }*/
        map = new MapUsered().getNum(array);
        System.out.println(map);
    }
}
