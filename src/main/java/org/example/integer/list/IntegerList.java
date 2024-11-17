package org.example.integer.list;

import org.example.StringList;

import java.util.ArrayList;
import java.util.List;

public interface IntegerList {

    Integer add(int index, Integer item);

    Integer add(Integer item);

    Integer set(int index, Integer item);

    Integer remove(Integer item);

    Integer remove(int index);

    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer get(int index);

    boolean equals(IntegerListImpl otherList);

    int size();

    boolean isEmpty();

    void clear();

    Integer[] toArray();


    void sort(Integer[] arr);

    boolean binarySearch(Integer[] arr, Integer item);
}
