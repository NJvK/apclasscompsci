public class ForTest2 {
    public void printCount1(int end) {
        for (int i = 1; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printCount2(int start, int end) {
        int i = start;
        while (i <= end) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
    }

    public int getSum1(int end) {
        int sum = 0;
        for (int i = 1; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public int getSum2(int end) {
        int sum = 0;
        int i = 1;
        while (i <= end) {
            sum += i;
            i++;
        }
        return sum;
    }
}
