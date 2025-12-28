import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BSTScheduler scheduler = new BSTScheduler();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Process " + (i + 1));

            System.out.print("Enter Process ID: ");
            int pid = sc.nextInt();

            System.out.print("Enter Arrival Time: ");
            int arrival = sc.nextInt();

            System.out.print("Enter Burst Time: ");
            int burst = sc.nextInt();

            scheduler.insert(pid, arrival, burst);
        }
        scheduler.schedule();
        scheduler.printAverageTimes();
    }
}
