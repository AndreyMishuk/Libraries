package com.dsu.librarySort.sortarraylist;

import java.util.ArrayList;

public class Marger {

    public ArrayList<String> margerArrayList(ArrayList<String> firstArray, ArrayList<String> secondArray) {

        ArrayList<String> temp = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (temp.size() < firstArray.size() + secondArray.size()) {

            if (i >= firstArray.size() && j < secondArray.size()) {
                temp.add(secondArray.get(j));
                j++;
            }

            if (j >= secondArray.size() && i < firstArray.size()) {
                temp.add(firstArray.get(i));
                i++;
            }

            if (i < firstArray.size() && j < secondArray.size() && firstArray.get(i).compareTo(secondArray.get(j)) < 0) {
                temp.add(firstArray.get(i));
                i++;
            }

            if (j < secondArray.size() && i < firstArray.size() && secondArray.get(j).compareTo(firstArray.get(i)) < 0) {
                temp.add(secondArray.get(j));
                j++;

            }
            if (j < secondArray.size() && i < firstArray.size() && firstArray.get(i).equals(secondArray.get(j))) {
                temp.add(firstArray.get(i));
                temp.add(secondArray.get(j));
                i++;
                j++;
            }

        }
        return temp;
    }
    
    
   
}
