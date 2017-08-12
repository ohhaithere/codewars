package com.frostmaster.Katas.PerimeterFib;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Kata {

    public static BigInteger perimeter(BigInteger n) {

        Supplier<BigInteger> fib = new Supplier() {
            private BigInteger previous = BigInteger.valueOf(0);
            private BigInteger current = BigInteger.valueOf(1);

            @Override
            public BigInteger get() {
                BigInteger nextValue = this.previous.add(this.current);
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };

        BigInteger fibSum = Stream.generate(fib)
                .limit(n.intValue() + 1)
                .reduce(BigInteger.ZERO, BigInteger::add);

        return BigInteger.valueOf(4).multiply(fibSum);
    }

}