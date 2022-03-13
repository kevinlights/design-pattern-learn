package sample;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) {
        ScoreOperation operation = new OperationAdapter();
        int scores[] = {84,76,50,69,90,91,88,96}; //定义成绩数组
        int result[];
        int score;
        System.out.println("成绩排序结果：");
        result = operation.sort(scores);
        //遍历输出成绩
        for(int i : scores) {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("查找成绩90：");
        score = operation.search(result,90);
        if (score != -1) {
            System.out.println("找到成绩90。");
        }
        else {
            System.out.println("没有找到成绩90。");
        }
        System.out.println("查找成绩92：");
        score = operation.search(result,92);
        if (score != -1) {
            System.out.println("找到成绩92。");
        }
        else {
            System.out.println("没有找到成绩92。");
        }
    }
}

public interface ScoreOperation {
    public int[] sort(int[] a);

    public int search(int[] a, int key);
}

class OperationAdapter implements ScoreOperation {
    private QuickSort sortObj = new QuickSort();
    private BinarySearch searchObj = new BinarySearch();

    @Override
    public int[] sort(int[] a) {
        return sortObj.quickSort(a);
    }

    @Override
    public int search(int[] a, int key) {
        return searchObj.binarySearch(a, key);
    }
}

class QuickSort {
    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int partition(int[] a, int p, int r) {
        int x = a[r];
        int j = p - 1;
        for (int i = p; i <= r - 1; i++) {
            if (a[i] <= x) {
                j++;
                swap(a, j, i);
            }
        }
        swap(a, j + 1, r);
        return j + 1;
    }

    public void sort(int[] a, int p, int r) {
        int q = 0;
        if (p < r) {
            q = partition(a, p, r);
            sort(a, p, q - 1);
            sort(a, q + 1, r);
        }
    }

    public int[] quickSort(int[] a) {
        sort(a, 0, a.length - 1);
        return a;
    }
}

class BinarySearch {
    public int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return 1;
            }
        }
        return -1;
    }
}
