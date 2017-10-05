package com.dsu.librarySort.sortarraylist;

import java.util.ArrayList;

public class SortArrayList {

    private final ArrayList<String> arrayList;
    private ArrayList<String> firstPartArray;
    private ArrayList<String> secondPartArray;

    public SortArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<String> getFirstPartArray() {
        return firstPartArray;
    }

    public ArrayList<String> getSecondPartArray() {
        return secondPartArray;
    }

    private void arrayDivision2Thread() throws InterruptedException {

        int low = 0;
        int hight = arrayList.size();
        int mid = hight / 2;

        this.firstPartArray = new ArrayList<>(mid);
        this.secondPartArray = new ArrayList<>(hight - mid);

        this.firstPartArray = copyListLenght(firstPartArray, mid, low);
        this.secondPartArray = copyListLenght(secondPartArray, hight, mid);

        final Thread firstPart = new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }

                firstPartArray = new Sort().sort(firstPartArray);

            }
        };

        firstPart.start();

        final Thread secondPart = new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
                
                secondPartArray = new Sort().sort(secondPartArray);

            }
        };

        secondPart.start();

        firstPart.join();
        secondPart.join();
    }

    private ArrayList<String> copyListLenght(ArrayList<String> arr, int lenght, int position) {

        for (int i = position; i < lenght; i++) {
            arr.add(arrayList.get(i));
        }

        return arr;
    }

    public ArrayList<String> getSortedArrayList() {

        Marger marger = new Marger();

        try {
            arrayDivision2Thread();
        } catch (InterruptedException ex) {
            System.out.println("Error" + ex);
        }

        return marger.margerArrayList(firstPartArray, secondPartArray);
    }

}
