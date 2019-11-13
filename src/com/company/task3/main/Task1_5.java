package com.company.task3.main;


import java.util.Arrays;

public class Task1_5 {
    //1. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
    // Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами первого,
    // при этом не используя дополнительный массив.

    public static void solveTask1() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8};
        int k = 3;

        arr1 = Arrays.copyOf(arr1, arr1.length + arr2.length);

        System.arraycopy(arr1, k, arr1, k + arr2.length, arr1.length - 2 * arr2.length);
        System.arraycopy(arr2, 0, arr1, k, arr2.length);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

    //2. Даны две последовательности a  a  a и b  b  b . Образовать из них новую 12n12m
    //последовательность чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
    public static void solveTask2() {
        int[] arr1 = {1, 3, 5, 6, 7};
        int[] arr2 = {6, 7, 9, 8};

        arr1 = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, arr1, arr1.length - arr2.length, arr2.length);
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

    //3. Сортировка выбором. Дана последовательность чисел a1  a2  an .Требуется
    //переставить элементы так, чтобы они были расположены по убыванию.
    // Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится на первое место, а первый - на место наибольшего.
    // Затем, начиная со второго, эта процедура повторяется. Написать алгоритм сортировки выбором.
    public static void solveTask3() {
        int[] arr = {8, 1, 6};

        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void selectionSort(int[] arr) {

    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < arr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min_i = i;

        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i + 1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < arr[min_i]) {
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            swap(arr, i, min_i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //4. Сортировка обменами. Дана последовательность чисел a1  a2    an .Требуется переставить числа в порядке возрастания.
    // Для этого сравниваются два соседних числа
    //ai и ai+1. Если ai ai+1, то делается перестановка.
    // Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания. Составить алгоритм сортировки,
    //подсчитывая при этом количества перестановок.

    public static void solveTask4(){
        int[] arr = {7,0,0,12,3,4,4,2,0};
        int counter = changeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.print(counter);

    }

    public static int changeSort(int[] arr) {
        int changeCount = 0;
        int currentChangeCount = 0;
        do {
            currentChangeCount = changeCount;
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i+1]) {
                    swap(arr, i, i + 1);
                    changeCount++;
                }
            }
        } while (currentChangeCount != changeCount);
        return  changeCount;
    }

    public static void solveTask5() {
        //5. Сортировка вставками. Дана последовательность чисел a1,a2,,an. Требуется переставить числа в порядке возрастания.
        // Делается это следующим образом. Пусть
        //a1 , a2 ,, ai - упорядоченная последовательность, т. е. a1  a2    an .
        // Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая последовательность была
        //тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n не будут перебраны.
        // Примечание. Место помещения очередного элемента в отсортированную часть производить с помощью двоичного поиска.
        // Двоичный поиск оформить в виде отдельной функции.
        int[] arr = {7,0,0,12,3,4,4,2,0};

        binarnSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            // в этой точке мы вышли, так что j так же -1
            // или в первом элементе, где текущий >= a[j]
            array[j+1] = current;
        }
    }

    public static void binarnSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int location = i - 1;
            int insertPlace;

            if(arr[location] > arr[i]) {
                int tmp = arr[i];
                insertPlace = Arrays.binarySearch(arr, 0, location, arr[i]);
                if(insertPlace < 0){
                    System.arraycopy(arr, ~insertPlace, arr,~insertPlace + 1,  i - ~insertPlace);
                    arr[~insertPlace] = tmp;
                }else{
                    System.arraycopy(arr, insertPlace, arr, insertPlace + 1,  i - insertPlace);
                    arr[insertPlace] = tmp;
                }
            }
        }
    }

}
