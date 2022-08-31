package pojo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.gs.poi.pojo.POIInfo;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestPoiInfo {
    @Test
    public void te(){
        String[] arr = new String[]{"A","B","B","C"};
        List<String> list = new ArrayList<>();
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])){
                continue;
            }
            list.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println();
        for (String s : list) {
            System.out.print(s+",");
        }
    }

    @Test
    public void tt(){
//        int[] arr = new int[3];
        int temp;
        int[] arr1 = new int[]{1,5,3,0,3};
        for(int i = 0;i<arr1.length;i++){
            for (int j =0;j<arr1.length-1; j++){
                if (arr1[j]>arr1[j+1]){
                    temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                }
            }
        }
//        Arrays.parallelSort(arr1);
        System.out.println(Arrays.toString(arr1));
//        Arrays.sort(arr1);
//        System.out.println(arr1.length);
    }

}
