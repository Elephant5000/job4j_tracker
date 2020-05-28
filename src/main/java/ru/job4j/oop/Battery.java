package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int charge) {
        this.load = charge;
    }

    public void exchange(Battery another){
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(10);
        Battery battery2 = new Battery(15);
        System.out.println("Заряд батереи 1 - " + battery1.load + " Заряд батереи 2 -  " + battery2.load);
        battery1.exchange(battery2);
        System.out.println("Заряд батереи 1 - " + battery1.load + " Заряд батереи 2 -  " + battery2.load);
    }
}
