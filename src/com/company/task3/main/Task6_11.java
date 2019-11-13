package com.company.task3.main;

import java.util.Arrays;

public class Task6_11 {
    public static void solveTask6() {
        //6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
        // Делается это следующим образом: сравниваются два соседних элемента ai иai+1.Если ai ai+1,топродвигаютсянаодинэлементвперед.
        // Если ai ai+1,топроизводится
        //перестановка и сдвигаются на один элемент назад. Составить алгоритм этой сортировки.
        int[] arr = {7,0,0,12,3,4,4,2,0};

        sheelSorting(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sheelSorting(int[] arr)
    {
        int j;
        int step = arr.length / 2;
        while (step > 0) {
            for (int i = 0; i < (arr.length - step); i++) {
                j = i;
                while ((j >= 0) && (arr[j] > arr[j + step])) {
                    Task1_5.swap(arr, j, j + step);
                    j = j - step;
                }
            }
            step = step / 2;
        }
    }

    //7. Пусть даны две неубывающие последовательности действительных чисел
    //a  a  a и b  b  b . Требуется указать те места, на которые нужно вставлять 12n12m
    //элементы последовательности b  b    b в первую последовательность так, чтобы новая 12m
    //последовательность оставалась возрастающей.

    public static void solveTask7() {
        int[] arr1 = {1, 2, 3, 5, 6};
        int[] arr2 = {4, 7, 8};
        int k = 3;

        arr1 = Arrays.copyOf(arr1, arr1.length + arr2.length);


        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

    //9. Алгоритм фон Неймана. Упорядочить массив a1,a2,,an по неубыванию с помощью алгоритма сортировки слияниями:
    public static void solveTask9() {
        int[] arr = {7,0,0,12,3,4,4,2,0};
        sortUnsorted(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    private static void sortUnsorted(int[] a, int lo, int hi) {

        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sortUnsorted(a, lo, mid);
        sortUnsorted(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);

        for (int k = lo; k <= hi; k++)
            buf[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
    }


    //10. Сортировка подсчетом. Выходной массив заполняется значениями -1.
    // Затем для каждого элемента определяется его место в выходном массиве путем подсчета количества элементов строго меньших данного.
    // Естественно, что все одинаковые элементы попадают на одну позицию, за которой следует ряд значений -1.
    // После этого оставшиеся в выходном массиве позиции со значением -1 заполняются копией предыдущего значения.
    public static void solveTask10(){
        int[] arr = {7,0,0,12,3,4,4,2,0};
        arr = countingSort(arr, 12);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] countingSort(int[] theArray, int maxValue) {
        // Массив со "счётчиками" размером от 0 до максимального значения
        int numCounts[] = new int[maxValue + 1];
        // В соответствующей ячейке (индекс = значение) увеличиваем счётчик
        for (int num : theArray) {
            numCounts[num]++;
        }
        // Подготавливаем массив для отсортированного результата
        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;
        // идём по массиву со "счётчиками"
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            // идём по количеству значений
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }

}
