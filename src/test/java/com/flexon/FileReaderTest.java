package com.flexon;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FileReaderTest {
    @Test
    public void readTestSpace() {
        FileReader fr = new FileReader();
        ArrayList<String> wl = fr.readRaw("C:\\Users\\RichardZhou\\Documents\\Flexon\\FileReader\\src\\main\\java\\com\\flexon\\text.txt");
        assertEquals("This", wl.get(0));
        assertEquals("is", wl.get(1));
        assertEquals("a", wl.get(2));
        assertEquals("simple", wl.get(3));
        assertEquals("text", wl.get(4));
        assertEquals("file", wl.get(5));
    }

    @Test
    public void readTestComma() {
        FileReader fr = new FileReader();
        ArrayList<String> wl = fr.readRaw("C:\\Users\\RichardZhou\\Documents\\Flexon\\FileReader\\src\\main\\java\\com\\flexon\\text2.txt");
        assertEquals("This", wl.get(0));
        assertEquals("is", wl.get(1));
        assertEquals("a", wl.get(2));
        assertEquals("simple", wl.get(3));
        assertEquals("text", wl.get(4));
        assertEquals("file", wl.get(5));
    }

    @Test
    public void reversedTest() {
        FileReader fr = new FileReader();
        ArrayList<String> wl = fr.reverse("C:\\Users\\RichardZhou\\Documents\\Flexon\\FileReader\\src\\main\\java\\com\\flexon\\text3.txt");
        assertEquals("noxelf", wl.get(0));
    }

    @Test
    public void frequencyTest() {
        FileReader fr = new FileReader();
        ArrayList<String> wl = fr.readRaw("C:\\Users\\RichardZhou\\Documents\\Flexon\\FileReader\\src\\main\\java\\com\\flexon\\text3.txt");
        HashMap<String, Integer> wordMap = fr.toHashMap(wl);
        Integer actual = wordMap.get("flexon");
        Integer expected = 7;
        assertEquals(expected, actual);
        Integer actual2 = wordMap.get("word");
        Integer expected2 = 3;
        assertEquals(expected2, actual2);
    }

    @Test
    public void printTest() {
        FileReader fr = new FileReader();
        fr.print("C:\\Users\\RichardZhou\\Documents\\Flexon\\FileReader\\src\\main\\java\\com\\flexon\\text3.txt");
        fr.reversePrint("C:\\Users\\RichardZhou\\Documents\\Flexon\\FileReader\\src\\main\\java\\com\\flexon\\text3.txt");
    }
}
