public class BSTScheduler {

    Process root;
    int currentTime = 0;
    double totalWT = 0;
    double totalTAT = 0;
    int count = 0;

    public void insert(int pid, int arrival, int burst) {
        root = insertRec(root, pid, arrival, burst);
    }

    private Process insertRec(Process node, int pid, int arrival, int burst) {
        if (node == null)
            return new Process(pid, arrival, burst);

        if (arrival < node.arrival)
            node.left = insertRec(node.left, pid, arrival, burst);
        else
            node.right = insertRec(node.right, pid, arrival, burst);

        return node;
    }

    public void schedule() {
        System.out.println("\nPID  AT  BT  ST  CT  WT  TAT");
        inorder(root);
    }

    private void inorder(Process node) {
        if (node == null)
            return;

        inorder(node.left);

        int start = Math.max(currentTime, node.arrival);
        int completion = start + node.burst;
        int waiting = start - node.arrival;
        int turnaround = completion - node.arrival;

        System.out.println("P" + node.pid + "   " +
                node.arrival + "   " +
                node.burst + "   " +
                start + "   " +
                completion + "   " +
                waiting + "   " +
                turnaround);

        totalWT += waiting;
        totalTAT += turnaround;
        count++;
        currentTime = completion;

        inorder(node.right);
    }

    public void printAverageTimes() {
        System.out.println("\nAverage Waiting Time = " + (totalWT / count));
        System.out.println("Average Turnaround Time = " + (totalTAT / count));
    }
}
