package com.tensquare.qa.test;

import com.tensquare.qa.Utils.ExcelUtils;

import java.util.List;

/**
 * @author: jiangyong
 * @date: 2019/1/3 16:14
 * @version:
 * @Copyright:
 * @modifier:
 */
public class Test {
    public static void main(String[] args) {
        List<List<String>> lists = ExcelUtils.readExcel("C:\\Users\\身未动心已远o\\Desktop\\美团\\Book1.xlsx");
        System.out.println(lists);
    }
}
