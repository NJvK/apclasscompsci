public class Count {
    public int getTotal(int total) {
        int num = 2;
        int sum = 0;
        while (num <= total) {
            sum += num;
            num += 2;
        }
        return sum;
    }
}