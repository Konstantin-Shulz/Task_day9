import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

    //    System.out.println("Введите целое число х размер массива");
    //    Scanner sc = new Scanner(System.in);
    //    int x = sc.nextInt();
    //    int[] arr = new int[x];
    //    System.out.println(x);

    //    System.out.println("Введите массив целых чисел " +x+" раз(a)");
    //    for (int i=0; i< arr.length; i++ ){
    //        arr[i] = sc.nextInt();
    //    }
    //    System.out.println(Arrays.toString(arr));

        //double sum = calcSumm(arr); //расчет суммы элементов массива
        //System.out.println("Сумма элементов массива = " +sum);
        //System.out.println("Среднее арифметическое массива = " +sum/x);

        //bubbleSort(arr);
        //sortByMax(arr);
        //sortByMin(arr);
        //System.out.println(Arrays.toString(arr));

        //double mediana = calcMedian(arr); //расчет медианы после любой сортировки
        //System.out.println("Медиана = " +mediana);


        //int[] arr= readArrayFromFile("input_array");
        int[] arr= readArrayFromFile("tr.txt");
        int countD = countUniqValue(arr);
        //System.out.println("Количество уникальных = " +countD);
        //System.out.println("Количество уникальных = " +countDistinctWithStream(arr));
        System.out.println("Количество повторов = " +countRepeatsValue(arr)*2);
        System.out.println("в массиве "+countD+" разных чисел");
        System.out.println(Arrays.toString(arr));
        System.out.println("Периметр треугольника = "+ calcPerimeter(arr));


        int perim = calcPerimeter(arr);

        String outputName ="perimeter";
        String s = String.valueOf(perim);
        Files.writeString(Path.of(outputName),s);

    }


    public static int calcPerimeter(int[] arr) {
        int p= 0;
        for (int i = 0; i < arr.length; i++) {
            p = p + arr[i];
        }
        return p;
    }
    private static int[] readArrayFromFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
    int n = sc.nextInt();
    int[] mas = new int[n];
    for (int i=0; i< mas.length; i++ ){
        mas[i] = sc.nextInt();
    }
        return mas;
    }

    public static int countUniqValue(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int y= arr[i];
            if (!isPresent(y,arr,0,i-1))//вызов функции и передача ей параметров
                                                //параметр №1 х получает значение у,
                                                //параметр №2 получает адрес массива: arr
                                                //параметр №3 от какого значения искать:  0
                                                //параметр №4 до какого значения искать: i-1
                count++;
        }
        return count;
    }

    public static int countRepeatsValue(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int y= arr[i];
            if (isPresent(y,arr,0,i-1))
                count++;
        }
        return count;
    }
    public static int countDistinctWithStream(int[] mas) {
        return (int) Arrays.stream(mas).distinct().count();
    }

    public static boolean isPresent(int x, int[] arr, int from, int to){

        for (int i = from; i <= to; i++){
            if (arr[i] == x) {
                return true;
            }
        }
            return false;
    }

    public static void bubbleSort(double[] arr) {
        for (int i=0; i< arr.length-1; i++ )        {
            for (int k=0; k< arr.length-1-i; k++)            {
                if( arr[k] > arr[k+1])
                {
                    double tmp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = tmp;
                }
            }
        }
    }
    public static void sortByMax(double[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            if (max != i) {
                double temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
    }

    public static void sortByMin(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            double m = arr[i];
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < m) {
                    m = arr[j];
                    min = j;
                }
            }
            double temp = arr[i];
            arr[i] = m;
            arr[min] = temp;
        }
    }

    public static double calcMedian(double[] arr) {
        double mediana = 0;
        if (arr.length % 2 == 0)
            mediana = (arr[arr.length/2] + arr[arr.length/2 - 1])/2;
        else
            mediana = arr[arr.length/2];
        return mediana;
    }
    public static double calcSumm(double[] arr) {
        double sum = 0;
        for (int i=0; i< arr.length; i++ ){
            sum = sum + arr[i];
        }
        return sum;
    }

}
