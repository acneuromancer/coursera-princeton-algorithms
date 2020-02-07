package _01_unionfind;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    /**
     * @param  args The name of the file containing the number of the elements and the connected elements
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No file name given as an argument.");
            return;
        }

        try (Scanner scanner = new Scanner(new FileReader(args[0]))) {
            int n = scanner.nextInt();
            QuickFind qf = new QuickFind(n);
            QuickUnion qu = new QuickUnion(n);
            WeightedQuickUnion wqu = new WeightedQuickUnion(n);
            System.out.println("Quick find = " + qf);
            System.out.println("Quick union = " + qu);
            System.out.println("Weighted quick union = " + wqu);

            System.out.println("\nReading data and connecting the elements...");
            while(scanner.hasNext()) {
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                qf.union(p, q);
                qu.union(p, q);
                wqu.union(p, q);
            }

            System.out.println("\nQuick find = " + qf);
            System.out.println("Quick union = " + qu);
            System.out.println("Weighted quick union = " + wqu);

            int p = 0;
            int q = 1;
            System.out.format("\nconnected(%d, %d) = %b\n", p, q, qf.connected(p, q));
            System.out.format("connected(%d, %d) = %b\n", p, q, qu.connected(p, q));

            p = 3;
            q = 9;
            System.out.format("connected(%d, %d) = %b\n", p, q, qf.connected(p, q));
            System.out.format("connected(%d, %d) = %b\n", p, q, qu.connected(p, q));

            p = 4;
            q = 7;
            System.out.format("connected(%d, %d) = %b\n", p, q, qf.connected(p, q));
            System.out.format("connected(%d, %d) = %b\n", p, q, qu.connected(p, q));

            p = 1;
            q = 10;
            System.out.format("connected(%d, %d) = %b\n", p, q, qf.connected(p, q));
            System.out.format("connected(%d, %d) = %b\n", p, q, qu.connected(p, q));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
