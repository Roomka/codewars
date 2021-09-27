package com.roman.procopenco.codewars;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DuplicateEncoderTest extends BenchmarkUtility {

    @Benchmark
    @Test
    public void encodeHashMap() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encodeHashMap("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encodeHashMap("   ()(   "));
        assertEquals(
                ")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))()))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))"
                ,DuplicateEncoder.encodeHashMap("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel efficitur ex, eget dictum turpis. Integer ut nisl diam. Curabitur malesuada justo et sagittis eleifend. Nulla id elementum purus. Aenean quam leo, imperdiet quis tincidunt in, elementum in enim. Curabitur dictum mollis odio lobortis egestas. Sed quis gravida velit, ac sodales felis. Proin sed tincidunt nisl, at tristique sapien. Ut varius semper porttitor. Mauris fringilla purus magna, ut dictum lorem convallis sit amet. Donec mattis arcu a consectetur mattis. Curabitur vel arcu vitae massa dignissim iaculis non in magna. Duis feugiat et leo sed blandit. Praesent feugiat eros sed elit venenatis, quis efficitur erat ornare. Ut pharetra, quam elementum vulputate suscipit, neque eros blandit sem, nec scelerisque elit magna efficitur mi."));
    }

    @Benchmark
    @Test
    public void encodeStream() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encodeStream("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encodeStream("   ()(   "));
        assertEquals(
                ")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))()))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))"
                ,DuplicateEncoder.encodeStream("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel efficitur ex, eget dictum turpis. Integer ut nisl diam. Curabitur malesuada justo et sagittis eleifend. Nulla id elementum purus. Aenean quam leo, imperdiet quis tincidunt in, elementum in enim. Curabitur dictum mollis odio lobortis egestas. Sed quis gravida velit, ac sodales felis. Proin sed tincidunt nisl, at tristique sapien. Ut varius semper porttitor. Mauris fringilla purus magna, ut dictum lorem convallis sit amet. Donec mattis arcu a consectetur mattis. Curabitur vel arcu vitae massa dignissim iaculis non in magna. Duis feugiat et leo sed blandit. Praesent feugiat eros sed elit venenatis, quis efficitur erat ornare. Ut pharetra, quam elementum vulputate suscipit, neque eros blandit sem, nec scelerisque elit magna efficitur mi."));

    }

    @Benchmark
    @Test
    public void encodeHashpMapOptimized() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encodeHashpMapOptimized("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encodeHashpMapOptimized("   ()(   "));
        assertEquals(
                ")))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))()))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))"
                ,DuplicateEncoder.encodeHashpMapOptimized("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vel efficitur ex, eget dictum turpis. Integer ut nisl diam. Curabitur malesuada justo et sagittis eleifend. Nulla id elementum purus. Aenean quam leo, imperdiet quis tincidunt in, elementum in enim. Curabitur dictum mollis odio lobortis egestas. Sed quis gravida velit, ac sodales felis. Proin sed tincidunt nisl, at tristique sapien. Ut varius semper porttitor. Mauris fringilla purus magna, ut dictum lorem convallis sit amet. Donec mattis arcu a consectetur mattis. Curabitur vel arcu vitae massa dignissim iaculis non in magna. Duis feugiat et leo sed blandit. Praesent feugiat eros sed elit venenatis, quis efficitur erat ornare. Ut pharetra, quam elementum vulputate suscipit, neque eros blandit sem, nec scelerisque elit magna efficitur mi."));

    }


    @Test
    public void calculateCharOccurences() {
        char[] characters = "aabbc".toCharArray();
        Map charMap = new HashMap<Character, Integer>();
        Map expectedCharMap = new HashMap<Character, Integer>();
        expectedCharMap.put('a', 2);
        expectedCharMap.put('b', 2);
        expectedCharMap.put('c', 1);

        DuplicateEncoder.calculateCharOccurences(characters, charMap);

        assertEquals(expectedCharMap, charMap);


    }

    @Test
    public void substituteCharacters() {
        char[] characters = "aabbc".toCharArray();
        Map charMap = new HashMap<Character, Integer>();
        charMap.put('a', 2);
        charMap.put('b', 2);
        charMap.put('c', 1);

        char[] substitutedArray = "))))(".toCharArray();

        DuplicateEncoder.substituteCharacters(characters, charMap);

        assertArrayEquals(substitutedArray, characters);

    }
}