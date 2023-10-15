package com.company.exceptions;

public class Main {

    public static void main(String[] args) {
        try {
            MyArrayList<Integer> arrayList = new MyArrayList<>(11);
        } catch (ArrayListSizeException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            e.printStackTrace();
        }
    }

}
