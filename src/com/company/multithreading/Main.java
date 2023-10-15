package com.company.multithreading;

//Реализовать механизм периодического асинхронного выполнения задач.
//        Т.е. механизм, который, не останавливая работу основной программы, раз в 10 секунд делает следующие действия:
//        1. пишет в консоль "Асинхронный привет!"
//        2. ждет (sleep) 5 секунд
//        3. пишет в консоль "Асинхронный пока!"
//        Основная программа при этом должна каждую секунду писать в консоль "Работает основная программа".


public class Main {

    public static void main(String[] args) {
        new Work().main();
    }

}

class Work {
    Object lockRunner = new Object();
    Object lockMain = new Object();

    public void print1(){
        synchronized (lockMain) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Работает основная программа");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void print2() {
        synchronized (lockRunner) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Ассинхронный привет!");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Ассинхронный пока!");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void work() {
        print1();
        print2();
    }

    public void main(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });

        thread1.start();
        thread2.start();
    }
}
