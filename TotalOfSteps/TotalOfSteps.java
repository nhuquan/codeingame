import java.util.*;

class TotalOfSteps {
  public static void main(String[] args) {
     int n = 1000000;
     int[] step = new int[n];
     step[0] = 1; // n = 1
     step[1] = -2; // n = 2
     for (int i= 2; i < n ; i++) {
       step[i] = step[i-1] - step[i-2];
     }
     int total = Arrays.stream(step).sum();
     System.out.println(total);
  }
}
