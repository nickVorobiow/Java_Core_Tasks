package com.company.exceptions;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList<T>{
    List<T> arrayList;

    public MyArrayList() {
        this.arrayList = new ArrayList<>();
    }

    public MyArrayList(int size) throws ArrayListSizeException {
        if (size > 10) {
            throw new ArrayListSizeException("Size is more than 10", new IllegalArgumentException());
        }

        arrayList = new ArrayList<>(size);
    }
}
