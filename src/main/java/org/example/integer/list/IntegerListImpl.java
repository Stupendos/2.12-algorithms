package org.example.integer.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerListImpl implements IntegerList {

    private Integer[] items;
    private int size;

    public IntegerListImpl() {
        this.items = new Integer[10];
        this.size = 0;
    }

    @Override
    public Integer add(Integer item) {
        ensureCapacity();
        items[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        ensureCapacity();
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        Integer oldValue = items[index];
        items[index] = item;
        return oldValue;
    }

    @Override
    public Integer remove(Integer item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new IllegalArgumentException("Элемент отсутствует в списке");
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        Integer removedItem = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[--size] = null;
        return removedItem;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        return items[index];
    }

    @Override
    public boolean equals(IntegerListImpl otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Сравниваемый список не должен быть null");
        }
        if (this.size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.items[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        Arrays.fill(items, 0, size, null);
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(items, size);
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
    private void ensureCapacity() {
        if (size == items.length) {
            grow();
        }
    }
    private void grow() {
        items = Arrays.copyOf(items, size + size / 2);
    }

    private void growIfNeeded() {
        if (size == items.length) {
            grow();
        }
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }
    private int partition(int low, int high) {
        Integer pivot = items[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (items[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }
    private void swap(int i, int j) {
        Integer temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}
