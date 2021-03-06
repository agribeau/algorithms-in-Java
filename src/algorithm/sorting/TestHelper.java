package algorithm.sorting;

import java.lang.reflect.Method;

/**
 * 测试排序算法的实用方法
 *
 * @author lyn
 */
@SuppressWarnings("unchecked")
public class TestHelper {

    /* 不允许产生实例对象 */
    private TestHelper() {
    }

    /**
     * [rangeL, rangeR]
     * [0, rangeR - rangeL]
     * 0 <= x * (rangeR - rangeL) < rangeR - rangeL
     * 0 <= x * (rangeR - rangeL + 1) <= rangeR -rangeL
     * rangeL <= x * (rangeR - rangeL + 1) + rangeL <= rangeR - rangeL + rangeL
     * rangeL <= x * (rangeR - rangeL + 1) + rangeL <= rangeR
     * <p>
     * 生成含有 n 个元素的随机数组，每个元素的随机范围是：[rangeL, rangeR]
     *
     * @param n      数组长度
     * @param rangeL 随机范围的最小值
     * @param rangeR 随机范围的最大值
     * @return 随机数组
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }

        return arr;
    }

    /**
     * 打印数组
     *
     * @param arr 数组
     */
    public static void printArray(Object[] arr) {
        for (Object anArr : arr) {
            System.out.print(anArr);
            System.out.print(" ");
        }
    }

    /**
     * 判断数组是否有序
     *
     * @param arr 数组
     * @return boolean
     */
    private static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 测试排序算法的性能
     *
     * @param sortClassName 排序算法的类名
     * @param arr           数组
     */
    public static void testSortPerformance(String sortClassName, Comparable[] arr) {
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", Comparable[].class);
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);
            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
