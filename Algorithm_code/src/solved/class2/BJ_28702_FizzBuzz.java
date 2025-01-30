package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_28702_FizzBuzz {

    static String first, second, third;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine();
        second = br.readLine();
        third = br.readLine();

        int next;

        if (!first.equals("Fizz") && !first.equals("Buzz") && !first.equals("FizzBuzz"))
            next = Integer.parseInt(first) + 3;
        else if (!second.equals("Fizz") && !second.equals("Buzz") && !second.equals("FizzBuzz"))
            next = Integer.parseInt(second) + 2;
        else
            next = Integer.parseInt(third) + 1;

        if (next % 3 == 0 && next % 5 == 0)
            System.out.println("FizzBuzz");
        else if (next % 3 == 0)
            System.out.println("Fizz");
        else if (next % 5 == 0)
            System.out.println("Buzz");
        else
            System.out.println(next);

    }

}

// 참고 : https://mwzz6.tistory.com/entry/%EB%B0%B1%EC%A4%80-28702%EB%B2%88-FizzBuzz-Java