package com.example.undoRedoTest;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author chenweijia
 * @version 1.0
 * @date 2022/11/14 6:19 下午
 */
public class BloomFilterCase {

    /**
     * 预计要插入多少数据
     */
    private static int size = 1000000 ;

    /**
     * 期望的误判率
     */
    private static double fpp = 0.01 ;

    /**
     * 布隆过滤器
     */
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),size,fpp);


    private static int total = 1000000 ;


    public static void main(String[] args) {
        //插入10万样本数据
        for (int i = 0; i < total ; i++) {
            bloomFilter.put(i);
        }

        //用另外十万测试数据，测试误判率
        int count = 0 ;
        for (int i = total; i < total + 100000; i++) {
            if(bloomFilter.mightContain(i)){
                count++;
                System.out.println(i+"误判了");
            }

        }
        System.out.println("总共的误判数："+count);

    }





}
