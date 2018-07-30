package com.w.util;

/**
 * Created by destiny on 2018/6/23/0023.
 */
public class DoPage {
    public static int getTotalPages(int totalRows,int pagesize){
        return totalRows%pagesize==0?totalRows/pagesize :totalRows/pagesize + 1;
    }
}
