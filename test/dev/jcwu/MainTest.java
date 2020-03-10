package dev.jcwu;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static dev.jcwu.Main.*;

class MainTest {
    @Test
    void testProblem1() {
        assert problem1(10) == 23;
        assert problem1(11) == 33;
        assert problem1(13) == 45;
        assert problem1(16) == 60;
    }

    @Test
    void testProblem2() {
        assert problem2(3)==2;
        assert problem2(10)==10;
        assert problem2(50)==44;
    }

    @Test
    void testProblem3() {
        assert problem3(24)==3;
        assert problem3(7)==7;
        assert problem3(15)==5;
    }

    @Test
    void testIsPalindrome() {
        assert isPalindrome(11);
        assert isPalindrome(111);
        assert isPalindrome(2112);
        assert isPalindrome(1010110101);
    }

    @Test
    void testProblem4() {
        System.out.print(problem4());
    }

    @Test
    void testProblem5() {
        assert problem5(10)==2520;
        assert problem5(20)==232792560;
        assert problem5(22) == problem5(21);
    }

    @Test
    void testPrimeFactors() {
        Map<Integer,Map<Integer,Integer>> lookup =new HashMap<>();
        primeFactors(20);
        for(int k:lookup.get(20).keySet()){
            System.out.println(k +"-"+ lookup.get(20).get(k));
        }

    }
}