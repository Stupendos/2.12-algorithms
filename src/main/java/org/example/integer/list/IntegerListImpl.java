package org.example.integer.list;

import java.util.ArrayList;
import java.util.List;

public class IntegerListImpl implements IntegerList {

    private List<Integer> items;

    public IntegerListImpl() {
        this.items = new ArrayList<>();
    }

    @Override
    public Integer add(Integer item) {
        items.add(item);
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if(index < 0 || index > items.size()) {
            throw new IndexOutOfBoundsException();
        }
        items.add(index, item);
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        return items.set(index, item);
    }

    @Override
    public Integer remove(Integer item) {
        if (!items.contains(item)) {
            throw new IllegalArgumentException("Элемент отсутствует в списке");
        }
        items.remove(item);
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        return items.remove(index);
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sort(storageCopy);
        return binarySearch(storageCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        return items.indexOf(item);
    }

    @Override
    public int lastIndexOf(Integer item) {
        return items.lastIndexOf(item);
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        return items.get(index);
    }

    @Override
    public boolean equals(IntegerListImpl otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Сравниваемый список не должен быть null");
        }
        if (otherList.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public Integer[] toArray() {
        return items.toArray(new Integer[0]);
    }

    @Override
    public void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    @Override
    public boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
