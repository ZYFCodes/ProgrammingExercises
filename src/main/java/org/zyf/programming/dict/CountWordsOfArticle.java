package org.zyf.programming.dict;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * 描述：统计文件中单词出现次数前50的单词
 *
 * @author yanfengzhang
 * @date 2020-04-30 17:55
 */
public class CountWordsOfArticle {

    public static List countWordsOfArticle(String fileName) throws Exception {
        ArrayList<Map.Entry<String, Integer>> resultList = null;
        try {
            /*读取文件*/
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            /*建一个存放读入数据的集合*/
            HashMap<String, Integer> CountWordsMap = new HashMap<String, Integer>();
            /*每次读取一行*/
            String line = br.readLine();
            while (null != line) {
                /*循环读入并进行切分*/
                String[] split = line.split(" ");
                for (String word : split) {
                    /*遍历字符串数组*/
                    if (0 != word.length()) {
                        /*判断对象不为空*/
                        if (CountWordsMap.containsKey(word)) {
                            /*判断集合中是否包括目标单词*/
                            /*如果包括，value值+1，如果不包括，将新单词放入集合中*/
                            CountWordsMap.put(word, CountWordsMap.get(word) + 1);
                        } else {
                            CountWordsMap.put(word, 1);
                        }
                    }
                }
            }
            /*集合中的元素以k,v形式取出*/
            Set<Map.Entry<String, Integer>> entrySet = CountWordsMap.entrySet();
            /*放入List集合中*/
            resultList = new ArrayList<Map.Entry<String, Integer>>(entrySet);
            Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
                /*进行降序排序*/
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    /*重写比较器*/
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            /*返回列表的前50项*/
            if (resultList.size() >= 50) {
                return resultList.subList(0, 50);
            }
            return resultList;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "/Users/yanfengzhang/zyftest/thanosx.sh";
        System.out.println(countWordsOfArticle(fileName));
    }
}
