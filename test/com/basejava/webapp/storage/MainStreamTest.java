package com.basejava.webapp.storage;

import com.basejava.webapp.MainStream;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MainStreamTest {

    @Test
    public void minValueArrayWithCorrectElements() {
        int actual = MainStream.minValue(new int[]{1, 2, 3, 3, 2, 3});
        int expected = 123;
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = NoSuchElementException.class)
    public void minValueEmptyArray() {
        int result = MainStream.minValue(new int[]{});
    }

    @Test
    public void minValueArrayWithOneElement() {
        int actual = MainStream.minValue(new int[]{1});
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minValueArrayWithTwoEqualElements() {
        int actual = MainStream.minValue(new int[]{1, 1});
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minValueArrayWithFewWrongElements() {
        int actual = MainStream.minValue(new int[]{0, 1, 2, 3, 3, 2, 3, 11});
        int expected = 123;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void oddOrEvenWithEvenSum() {
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        integers.add(3);
        integers.add(2);
        integers.add(3);
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(2);
        List<Integer> actual = MainStream.oddOrEven(integers);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void oddOrEvenOddEvenSum() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(3);
        integers.add(2);
        integers.add(3);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(3);
        expected.add(3);
        List<Integer> actual = MainStream.oddOrEven(integers);
        Assert.assertEquals(expected, actual);
    }
}