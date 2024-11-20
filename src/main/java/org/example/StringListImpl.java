package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringListImpl implements StringList {
    private List<String> items;

    public StringListImpl() {
        this.items = new ArrayList<>();
    }

    @Override
    public String add(String item) {
        items.add(item);
        return item;
    }

    @Override
    public String add(int index, String item) {
        if(index < 0 || index > items.size()) {
            throw new IndexOutOfBoundsException();
        }
        items.add(index, item);
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        return items.set(index, item);
    }

    @Override
    public String remove(String item) {
        if (!items.contains(item)) {
            throw new IllegalArgumentException("Элемент отсутствует в списке");
        }
        items.remove(item);
        return item;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        return items.remove(index);
    }

    @Override
    public boolean contains(String item) {
        return items.contains(item);
    }

    @Override
    public int indexOf(String item) {
        return items.indexOf(item);
    }

    @Override
    public int lastIndexOf(String item) {
        return items.lastIndexOf(item);
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        return items.get(index);
    }

    @Override
    public boolean equals(StringList otherList) {
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
    public String[] toArray() {
        return items.toArray(new String[0]);
    }
}
