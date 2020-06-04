package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Пассажиров - " + passengers);

    }

    @Override
    public float fill(float gas) {
        System.out.println("Топлива - " + gas);
        return 0;
    }
}
