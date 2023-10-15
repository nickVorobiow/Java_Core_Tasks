package com.company.collections;

import java.util.*;

public class Main {

    private static final int size = 1000;
    private static long before, after;

    public static void main(String[] args) {

        List<Integer> integerArrayList = new ArrayList<>();
        List<Integer> integerLinkedList = new LinkedList<>();
        Set<Integer> integerTreeSet = new TreeSet<>();
        Set<Integer> integerHashSet = new HashSet<>();

        System.out.println("Время добавления в ArrayList (ms):" + collectionAddBenchmark(integerArrayList)
                + "\nЭлементов добавлено:" + integerArrayList.size());

        System.out.println("Время добавления в LinkedList (ms):" + collectionAddBenchmark(integerLinkedList)
                + "\nЭлементов добавлено:" + integerLinkedList.size());

        System.out.println("Время добавления в TreeSet (ms):" + collectionAddBenchmark(integerTreeSet)
                + "\nЭлементов добавлено:" + integerTreeSet.size());

        System.out.println("Время добавления в HashSet (ms):" + collectionAddBenchmark(integerHashSet)
                + "\nЭлементов добавлено:" + integerHashSet.size() +
                "\n---------------------------------------------------------------------------");

        System.out.println("Время удаления в ArrayList (ms):" + collectionDeleteBenchmark(integerArrayList)
                + "\nЭлементов:" + integerArrayList.size());

        System.out.println("Время удаления в LinkedList (ms):" + collectionDeleteBenchmark(integerLinkedList)
                + "\nЭлементов:" + integerLinkedList.size());

        System.out.println("Время удаления в TreeSet (ms):" + collectionDeleteBenchmark(integerTreeSet)
                + "\nЭлементов:" + integerTreeSet.size());

        System.out.println("Время удаления в HashSet (ms):" + collectionDeleteBenchmark(integerHashSet)
                + "\nЭлементов:" + integerHashSet.size() +
                "\n---------------------------------------------------------------------------");

        System.out.println("Время поиска элемента из середины в ArrayList (ms):" +
                collectionSearchBenchmark(integerArrayList));

        System.out.println("Время поиска элемента из середины в LinkedList (ms):" +
                collectionSearchBenchmark(integerLinkedList));

        System.out.println("Время поиска элемента из середины в HashSet (ms):" +
                collectionSearchBenchmark(integerHashSet));

        System.out.println("Время поиска элемента из середины в TreeSet (ms):" +
                binarySearchBenchmark(integerTreeSet));
    }

    static long collectionAddBenchmark(Collection<Integer> collection) {
        before = System.currentTimeMillis();

        for (int elem = 0; elem < size; elem++) {
            collection.add(elem);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after = System.currentTimeMillis();

        return after - before - size * 2;
    }

    static long collectionDeleteBenchmark(Collection<Integer> collection) {
        before = System.currentTimeMillis();

        for (int elem = 0; elem < size; elem++) {
            collection.remove(elem);
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after = System.currentTimeMillis();

        return after - before - 2 * size;
    }

    static long collectionSearchBenchmark(Collection<Integer> collection) {
        before = System.currentTimeMillis();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        collection.contains(size / 2);

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        after = System.currentTimeMillis();

        return after - before - 4;
    }

    static long binarySearchBenchmark(Set<Integer> treeSet) {
        before = System.currentTimeMillis();

        List<Integer> arrayList = new ArrayList<>(treeSet);
        Collections.binarySearch(arrayList, size / 2);
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        after = System.currentTimeMillis();

        return after - before - 2;
    }
}


