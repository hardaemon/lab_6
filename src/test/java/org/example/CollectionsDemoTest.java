package org.example;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CollectionsDemoTest {
    @Test //1
    public void countStartingWith() {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"qwerty", "qsaxc", "dsfg", "evfrs", "qw", "q", " ");
        assertEquals(4, CollectionsDemo.countStartingWith(list, 'q'));
    }
    @Test //2
    public void getNamesakes() {
        ArrayList<Human> humans = new ArrayList<>(6);
        Human human1 = new Human("a", "a", "a", 1);
        Human human2 = new Human("b", "b", "b", 2);
        Human human3 = new Human("c", "c", "c", 3);
        Human human4 = new Human("a", "d", "d", 4);
        Human human5 = new Human("e", "e", "e", 5);
        Human human6 = new Human("a", "f", "f", 6);
        Collections.addAll(humans, human1, human2, human3, human4, human5, human6);
        List<Human> result = new ArrayList<>(3);
        Collections.addAll(result, human1, human4, human6);
        assertEquals(result, CollectionsDemo.getNamesakes(humans, human1));
    }
    @Test //3
    public void copy() {
        ArrayList<Human> humans = new ArrayList<>(3);
        Human human1 = new Human("a", "a", "a", 1);
        Human human2 = new Human("b", "b", "b", 2);
        Human human3 = new Human("c", "c", "c", 3);
        Collections.addAll(humans, human1, human2, human3);
        List<Human> result = new ArrayList<>(2);
        Collections.addAll(result, human1, human3);
        assertEquals(result, CollectionsDemo.copy(humans, human2));
    }
    @Test //4
    public void intersections() {
        Set<Integer> setTest = new HashSet<>();
        setTest.add(1);
        setTest.add(2);
        Set<Integer> setTest2 = new HashSet<>();
        setTest2.add(10);
        setTest2.add(12);
        Set<Integer> setTest3 = new HashSet<>();
        setTest3.add(2);
        setTest3.add(5);
        setTest3.add(3);
        setTest3.add(7);
        Set<Integer> set1 = new HashSet<>();
        set1.add(5);
        set1.add(2);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(7);
        List<Set<Integer>> list = new ArrayList<>();
        list.add(set1);
        list.add(set2);
        List<Set<Integer>> result = new ArrayList<>();
        result.add(set2);
        List<Set<Integer>> result2 = new ArrayList<>();
        result2.add(set1);
        result2.add(set2);
        List<Set<Integer>> result3 = new ArrayList<>();
        assertEquals(result, CollectionsDemo.intersections(list, setTest));
        assertEquals(result2, CollectionsDemo.intersections(list, setTest2));
        assertEquals(result3, CollectionsDemo.intersections(list, setTest3));
    }
    @Test //5
    public void maxAge() {
        ArrayList<Human> humans = new ArrayList<>(3);
        Human human1 = new Human("a", "a", "a", 1);
        Human human2 = new Human("b", "b", "b", 2);
        Student human3 = new Student("c", "c", "c", 2, "one");
        Collections.addAll(humans, human1, human2, human3);
        Set<Human> result = new HashSet<>();
        Collections.addAll(result, human2, human3);
        assertEquals(result, CollectionsDemo.maxAge(humans));
    }
    @Test //7
    public void key() {
        Set<Integer> testSet = new HashSet<>();
        Collections.addAll(testSet, 111, 222, 333, 444);
        Human human1 = new Human("a", "a", "a", 1);
        Human human2 = new Human("b", "b", "b", 2);
        Human human3 = new Human("c", "c", "c", 3);
        Human human4 = new Human("d", "d", "d", 4);
        Map<Integer, Human> testMap = new HashMap<>();
        testMap.put(111, human1);
        testMap.put(20, human2);
        testMap.put(333, human3);
        testMap.put(40, human4);
        Set<Human> result = new HashSet<>();
        Collections.addAll(result, human1, human3);
        assertEquals(result, CollectionsDemo.key(testMap, testSet));
    }
    @Test //8
    public void age() {
        Map<Integer, Human> test = new HashMap<>();
        Human human1 = new Human("a", "a", "a", 10);
        Human human2 = new Human("b", "b", "b", 18);
        Human human3 = new Human("c", "c", "c", 20);
        Human human4 = new Human("d", "d", "d", 4);
        test.put(111, human1);
        test.put(222, human2);
        test.put(333, human3);
        test.put(444, human4);
        List<Integer> result = new ArrayList<>();
        Collections.addAll(result, 333, 222);
        assertEquals(result, CollectionsDemo.age(test));
    }
    @Test //9
    public void newMap() {
        Map<Integer, Human> test = new HashMap<>();
        Human human1 = new Human("a", "a", "a", 10);
        Human human2 = new Human("b", "b", "b", 18);
        Human human3 = new Human("c", "c", "c", 20);
        Human human4 = new Human("d", "d", "d", 4);
        test.put(111, human1);
        test.put(222, human2);
        test.put(333, human3);
        test.put(444, human4);
        Map<Integer, Integer> result = new HashMap<>();
        result.put(111, 10);
        result.put(222, 18);
        result.put(333, 20);
        result.put(444, 4);
        assertEquals(result, CollectionsDemo.newMap(test));
    }
    @Test //10
    public void setMap() {
        Set<Human> test = new HashSet<>();
        Human human1 = new Human("a", "a", "a", 10);
        Human human2 = new Human("b", "b", "b", 18);
        Human human3 = new Human("c", "c", "c", 20);
        Human human4 = new Human("d", "d", "d", 10);
        Collections.addAll(test, human1, human2, human3, human4);
        Map<Integer, List<Human>> result = new HashMap<>();
        List<Human> resultSet1 = new ArrayList<>();
        Collections.addAll(resultSet1, human1, human4);
        List<Human> resultSet2 = new ArrayList<>();
        resultSet2.add(human2);
        List<Human> resultSet3 = new ArrayList<>();
        resultSet3.add(human3);
        result.put(10, resultSet1);
        result.put(18, resultSet2);
        result.put(20, resultSet3);
        assertEquals(result, CollectionsDemo.setMap(test));
    }
    @Test //11
    public void maps() {
        Set<Human> test = new HashSet<>();
        Human human1 = new Human("a", "a", "a", 10);
        Human human2 = new Human("b", "b", "b", 10);
        Human human3 = new Human("c", "c", "c", 18);
        Human human4 = new Human("b", "d", "d", 10);
        Collections.addAll(test, human1, human2, human3, human4);
        Map<Integer, Map<Character, List<Human>>> result = new HashMap<>();
        Map<Character, List<Human>> resultMap1 = new HashMap<>();
        List<Human> resultList1_1 = new ArrayList<>();
        resultList1_1.add(human1);
        List<Human> resultList1_2 = new ArrayList<>();
        resultList1_2.add(human4);
        resultList1_2.add(human2);
        List<Human> resultList2 = new ArrayList<>();
        resultList2.add(human3);
        resultMap1.put('a', resultList1_1);
        resultMap1.put('b', resultList1_2);
        Map<Character, List<Human>> resultMap2 = new HashMap<>();
        resultMap2.put('c',resultList2);
        result.put(10, resultMap1);
        result.put(18, resultMap2);
        assertEquals(result, CollectionsDemo.maps(test));
    }
}