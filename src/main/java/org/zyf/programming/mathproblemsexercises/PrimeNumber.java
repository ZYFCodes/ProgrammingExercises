package org.zyf.programming.mathproblemsexercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * 描述：输入n，返回小于n的所有素数，要求性能最佳，使用stream操作并通过修改源码优化
 *
 * @author yanfengzhang
 * @date 2020-05-18 10:59
 */
public class PrimeNumber {

    public List<Integer> getPrimes(int n) {
        List<Integer> result = new ArrayList<Integer>();

        IntStream.range(1, n).filter(this::isPrime).forEach(result::add);

        return result;
    }


    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeCollector());
    }

    class PrimeCollector implements Collector<Integer,
            List<Integer>,
            List<Integer>> {

        @Override
        public Supplier<List<Integer>> supplier() {
            return () -> new ArrayList<Integer>();
        }

        @Override
        public BiConsumer<List<Integer>, Integer> accumulator() {

            return List<Integer>::add;

        }

        @Override
        public BinaryOperator<List<Integer>> combiner() {
            return null;
        }

        @Override
        public Function<List<Integer>, List<Integer>> finisher() {
            return null;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return null;
        }

    }

    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        System.out.println(primeNumber.getPrimes(10));
    }
}
