import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    int size;
    double sum;
    Queue<Integer> queue;

    public MovingAverage(int size) {
        this.sum = 0;
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        sum += val;
        queue.add(val);

        while (queue.size() > size) {
            sum -= queue.poll();
        }

        return sum / queue.size();
    }
}