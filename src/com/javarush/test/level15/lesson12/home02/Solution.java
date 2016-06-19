package com.javarush.test.level15.lesson12.home02;

/* ���������� �����
����� ���������� ������: ����� doAction � ���������� ���������� Movable ������ �������� "moving".
��������� ������, ��� ������������� �������� (�������������) ��������� Movable.
��������� ������ � ������� ������ ����:
flying
moving
*/

public class Solution {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }

    public static class Duck implements Flyable, Movable {
        @Override
        public void doAction() {
            System.out.println("flying");
        }
    }

    public static class Util {
        static void fly(Flyable animal) {
            animal.doAction();
        }

        static void move(Movable animal) {
//            animal.doAction();
            System.out.println("moving");

        }
    }

    public static interface Flyable {
        void doAction();
    }

    public static interface Movable {
        void doAction();
    }
}

