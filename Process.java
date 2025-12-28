public class Process {
    int pid;
    int arrival;
    int burst;
    Process left, right;

    public Process(int pid, int arrival, int burst) {
        this.pid = pid;
        this.arrival = arrival;
        this.burst = burst;
        this.left = null;
        this.right = null;
    }
}
