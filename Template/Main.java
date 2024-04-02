import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int cases;
        try {
            cases = Integer.parseInt(br.readLine().trim());
            Solver solver = new Solver();
            for (int i = 0; i < cases; i++) {
                int n = Integer.parseInt(br.readLine().trim());
                solver.solve(n);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}class Solver {
    public void solve(int n ) {
        //logic goes here...
    }
}
