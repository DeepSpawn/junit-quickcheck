/*
 The MIT License

 Copyright (c) 2010-2016 Paul R. Holser, Jr.

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.pholser.junit.quickcheck.runner;

import java.util.Arrays;

class PropertyFalsified {
    private PropertyFalsified() {
        throw new UnsupportedOperationException();
    }

    static AssertionError counterexampleFound(
        String propertyName,
        Object[] args,
        long[] seeds,
        AssertionError e) {

        return new AssertionError(
            String.format(
                "Property %s falsified.%n"
                    + "Original failure message: [%s]%n"
                    + "Args: %s%n"
                    + "Seeds: %s%n",
                propertyName,
                e.getMessage(),
                Arrays.deepToString(args),
                Arrays.toString(seeds)),
            e);
    }

    static AssertionError smallerCounterexampleFound(
        String propertyName,
        Object[] originalArgs,
        Object[] args,
        long[] seeds,
        AssertionError originalFailure) {

        return new AssertionError(
            String.format(
                "Property %s falsified.%n"
                    + "Original failure message: [%s]%n"
                    + "Original args: %s%n"
                    + "Args shrunken to: %s%n"
                    + "Seeds: %s%n",
                propertyName,
                originalFailure.getMessage(),
                Arrays.deepToString(originalArgs),
                Arrays.deepToString(args),
                Arrays.toString(seeds)),
            originalFailure);
    }
}
