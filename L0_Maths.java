import java.util.*;

public class L0_Maths {

    public static void getDigits(int num) {
        while (num!=0) {
            int digit = num%10;
            System.out.println(digit);
            num = num/10;
        }
    }

    public static int gcd(int num1, int num2) {
        while (num1!=0) {
            num1 = num2 % (num2 = num1);
        }

        return num2;
    }

    public static List<Integer> divisors(int num) {
        List<Integer> ans = new ArrayList<>();

        for (int div=1; div<=Math.sqrt(num); div++) {
            if (num%div!=0) continue;

            ans.add(div);
            
            if (div!=num/div)
                ans.add(num/div);
        }

        return ans;
    }

    public static boolean checkPrime(int num) {
        // common base cases
        if (num<=1) return false;
        if (num<=3) return true;
        if (num%2==0 || num%3==0) return false;

        // check for divisibility from 5 to Sqrt(num)
        for (int i=5; i<(int)Math.sqrt(num); i++) {
            if (num % i==0) return false;
        }

        return true;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        System.out.println(checkPrime(num));

        sc.close();
    }

}
