package dev.jcwu;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer,Map<Integer,Integer>> lookup = new HashMap<>();

    public static int problem1(int x){
        //Find the sum of all the multiples of 3 or 5 below x
        int sum=0;
        for(int i=3;i<x;i+=3){
            sum+=i;
        }
        for(int i=5;i<x;i+=5){
            if(i%3!=0){
                sum+=i;
            }
        }
        return sum;
    }

    public static int problem2(int x){
//        By considering the terms in the Fibonacci sequence whose
//        values do not exceed x, find the sum of the
//        even-valued terms.
        int sum=0;
        int n2=1;
        int n1=1;
        int n=2;
        while(n<x){
            if(n%2==0){
                sum+=n;
            }
            n2=n1;
            n1=n;
            n=n2+n1;
        }
        return sum;

    }

    public static boolean isPrime(int x){
        int sqrt = (int)Math.sqrt(x);
        for(int i = sqrt;i>1;i--){
            if(x%i==0)
                return false;
        }
        return true;
    }
    public static int problem3(int x){
        //What is the largest prime factor of x?
        for(int i = x;i>1;i--){
            if(x%i==0 && isPrime(i))
                return i;
        }
        return x;
    }

    public static boolean isPalindrome(int x){
        int y=0;
        for(int i=x;i>0;i=i/10){
            y=y*10+i%10;
        }
        return y==x;

    }

    public static int problem4(){
        //Find the largest palindrome made from the product of two 3-digit numbers.
        int largest=0;
        for(int x=999;x>99;x--){
            for(int y=999;y>99;y--){
                if(isPalindrome(x*y))
                    largest = Math.max(largest,x*y);

            }
        }
        return largest;
    }

    public static Map<Integer,Integer> primeFactors(int x){
        if(lookup.containsKey(x)){
            return lookup.get(x);
        }
        Map<Integer,Integer> allFactors = new HashMap();
        for(int i=(int)Math.sqrt(x);i>1;i--){
            if(x%i==0){
                Map<Integer,Integer> factors1 = primeFactors(i);
                Map<Integer,Integer> factors2 = primeFactors(x/i);
                allFactors.putAll(factors1);
                for(int j : factors2.keySet()){
                    allFactors.compute(j,(k,v)->v==null ? factors2.get(j) : v+factors2.get(j));
                }
                lookup.put(x,allFactors);
                return allFactors;
            }
        }
        allFactors.put(1,1);
        allFactors.put(x,1);
        lookup.put(x,allFactors);
        return allFactors;
    }

    public static int problem5(int x){
        //What is the smallest positive number that is evenly divisible by all of the numbers from 1 to x?
        Map<Integer,Integer> accFactors = new HashMap<>();
        int acc=1;
        for(int i=x;i>1;i--){
            if(acc%i!=0){
                Map<Integer,Integer> factors = primeFactors(i);
                for(int j:factors.keySet()){
                    int old = accFactors.getOrDefault(j,0);
                    if(factors.get(j)>old){
                        acc=acc*(int)Math.pow(j,factors.get(j)-old);
                        accFactors.put(j,factors.get(j));
                    }
                }
            }
        }
        return acc;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
