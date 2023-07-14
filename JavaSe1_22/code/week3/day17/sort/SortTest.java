package org.example.week3.day17.sort;

//排序
public class SortTest {
    public static void main(String[] args) {
        int[] ary = {3, 6, 2, 4, 1};
        selectSort(ary); // 选择排序
        bubbleSort(ary); // 冒泡排序
        insertSort(ary); // 插入排序
    }

    // 插入排序
    private static void insertSort(int[] data) {
        int current;
        for (int i = 1; i < data.length; i++) {
            current = data[i];
            for (int j = i - 1; j >= 0; j--) {
                if (current < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    data[j + 1] = current;
                    break;
                }
                if (j == 0) {
                    data[j] = current;
                }
            }
        }

        for (int i : data) {
            System.out.print(i + "\t");
        }
    }

    // 冒泡
    private static void bubbleSort(int[] ary) {
        // 外层循环 n-1趟排序 ，每一趟排序，都有一个最大或者最小数沉底
        for (int i = 0; i < ary.length - 1; i++) {
            // 每趟是n-1-i(除去每次排序沉底的数)次比较
            for (int j = 0; j < ary.length - i - 1; j++) {
                // 两个两个比较并交换
                if (ary[j] > ary[j + 1]) {
                    // 交换 红墨水和黑墨水互换
                    int temp = ary[j]; // 当前的数据赋值给temp临时变量
                    ary[j] = ary[j + 1]; // 后一个数赋值给当前
                    ary[j + 1] = temp; // temp临时变量里的值赋值给后一个数
                }
            }
        }

        for (int i : ary) {
            System.out.println(i);
        }
    }

    // 选择排序
    private static void selectSort(int[] ary) {
        int smaller; // 保存较小的数的位置
        for (int i = 0; i < ary.length - 1; i++) { // 外层循环 n-1趟排序 每一趟排序 ，找到一个最小值，放到有序区域
            smaller = i; // 初始默认i为较小的数的位置
            for (int j = i + 1; j < ary.length; j++) { // 无序区域的循环 目的是找最小值的位置(下标)
                if (ary[smaller] > ary[j]) { // 找比smaller更小的数
                    smaller = j; // 把更小的数的位置赋值给了smaller
                }
            }
            if (smaller != i) { // 如果最小值的下标已经不是i了，证明最小值是其它的数，交换 ;
                // 交换 i smaller
                int temp = ary[smaller];
                ary[smaller] = ary[i];
                ary[i] = temp;
            }
        }

        // 排序好的数组进行遍历
        for (int i : ary) {
            System.out.println(i);
        }
    }
}
