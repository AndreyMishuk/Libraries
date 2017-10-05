package com.dsu.librarySort.sortarraylist;

import java.util.ArrayList;

public class Sort {

    public void swap(ArrayList<String> arrList, int left, int right) {
        if (left < right) {
            String temp = arrList.get(left);
            arrList.set(left, arrList.get(right));
            arrList.set(right, temp);
        }
    }

    public ArrayList<String> sort(ArrayList<String> arrList) {

        boolean swapped;

        do {

            swapped = false;
            for (int i = 0; i < arrList.size() - 1; i++) {
                for (int j = 0; j < arrList.size() - 1; j++) {
                    if (arrList.get(j).compareTo(arrList.get(j + 1)) >= 0) {
                        swap(arrList, j, j + 1);
                        swapped = true;
                    }
                }
            }

        } while (!swapped);

        return arrList;
    }



}
