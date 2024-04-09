package org.example;
import java.util.*;
public class CollectionsDemo {
    //1
    public static int countStartingWith(ArrayList<String> list, char c) {
        int result = 0;
        for (String string : list) {
            if (string.charAt(0) == c) result++;
        }
        return result;
    }
    //2
    public static List<Human> getNamesakes(ArrayList<Human> list, Human h) {
        List<Human> result = new ArrayList<>(list.size());
        for (Human human : list) {
            if (human.getLastName().equals(h.getLastName())) result.add(human);
        }
        return result;
    }
    //3
    public static List<Human> copy(ArrayList<Human> list, Human h) {
        List<Human> result = new ArrayList<>(list.size()-1);
        for (Human human : list) {
            if (!human.equals(h)) result.add(human);
        }
        return result;
    }
    //4
    public static List<Set<Integer>> intersections(List<Set<Integer>> list, Set<Integer> set) {
        List<Set<Integer>> result = new ArrayList<>();
        boolean test;
        for (Set<Integer> i : list) {
            test = true;
            for (Integer in : set) {
                if (i.contains(in)) {
                    test = false;
                    break;
                }
            }
            if (test) { result.add(i); }
        }
        return result;
    }
    //5
    public static Set<Human> maxAge(ArrayList<? extends Human> list) {
        Set<Human> result = new HashSet<>();
        int maxi = 0;
        for (Human h : list) {
            if (h.getAge() > maxi) { maxi = h.getAge(); }
        }
        for (Human hi : list) {
            if (hi.getAge() == maxi) { result.add(hi); }
        }
        return result;
    }
    //7
    public static Set<Human> key(Map<Integer, Human> map, Set<Integer> set) {
        Set<Human> result = new HashSet<>();
        for (Integer i : set) {
            if (map.containsKey(i)) {
                result.add(map.get(i));
            }
        }
        return result;
    }
    //8
    public static List<Integer> age(Map<Integer, Human> map) {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Human> i : map.entrySet()) {
            if (i.getValue().getAge() >= 18) {
                result.add(i.getKey());
            }
        }
        return result;
    }
    //9
    public static Map<Integer, Integer> newMap(Map<Integer, Human> map) {
        Map<Integer, Integer> result = new HashMap<>();
        for(Map.Entry<Integer, Human> i : map.entrySet()) {
            result.put(i.getKey(), i.getValue().getAge());
        }
        return result;
    }
    //10
    public static Map<Integer, List<Human>> setMap(Set<Human> set) {
        Map<Integer, List<Human>> result = new HashMap<>();
        int age = 0;
        for (Human human : set) {
            age = human.getAge();
            if (result.containsKey(age)) {
                result.get(age).add(human);
            }
            else {
                List<Human> list = new ArrayList<>();
                list.add(human);
                result.put(age, list);
            }
        }
        return result;
    }
    //11
//    public static Map<Integer, Map<Character, List<Human>>> maps(Set<Human> set) {
//        Map<Integer, Map<Character, List<Human>>> result = new HashMap<>();
//        int age = 0;
//        char firstChar;
//        for (Human human : set) { //перебор людей
//            age = human.getAge(); //берем возраст человека
//            firstChar = human.lastName.charAt(0); //берем первую букву фамилии человека
//            if (result.containsKey(age)) { //если в Map есть такой возраст
//                if (result.get(age).containsKey(firstChar)) { //если во внутреннем Map есть такая буква
//                    result.get(age).get(firstChar).add(human); //добавляем к этому возрасту и букве в List человека
//                }
//                else { //есть возраст, но нет буквы
//                    List<Human> list1 = new ArrayList<>();
//                    list1.add(human);
//                    result.get(age).put(firstChar, list1); //во внутренний мап добавляем букву и List с человеком
//                }
//            }
//            else { //если в Map нет такого возраста
//                List<Human> list2 = new ArrayList<>();
//                list2.add(human);
//                Map<Character, List<Human>> map = new HashMap<>();
//                map.put(firstChar, list2);
//                result.put(age, map); //создаем внутренний мап и туда добавляем букву и List с человеком
//            }
//        }
//        for (Map<Character, List<Human>> i : result.values()){
//            for (List<Human> j : i.values()){
//                j.sort(Collections.reverseOrder());//Сортировка по убыванию ФИО
//            }
//        }
//        return result;
//    }
    public static Map<Integer, Map<Character, List<Human>>> maps(Set<Human> set) {
        Map<Integer, Map<Character, List<Human>>> result = new HashMap<>();
        char firstChar;
        Map<Integer, List<Human>> result1 = setMap(set); //получаем результат из 10 задачи
        for (Map.Entry<Integer, List<Human>> entry: result1.entrySet()){
            for (Human human: entry.getValue()) {
                firstChar = human.lastName.charAt(0); //берем первую букву фамилии человека
                if (!result.containsKey(entry.getKey())) { //если в Map нет такого возраста
                    List<Human> list2 = new ArrayList<>();
                    list2.add(human);
                    Map<Character, List<Human>> map = new HashMap<>();
                    map.put(firstChar, list2);
                    result.put(entry.getKey(), map); //создаем внутренний мап и туда добавляем букву и List с человеком
                }
                else { //если в Map есть такой возраст
                    if (result.get(entry.getKey()).containsKey(firstChar)) { //если во внутреннем Map есть такая буква
                        result.get(entry.getKey()).get(firstChar).add(human); //добавляем к этому возрасту и букве в List человека
                    }
                    else { //есть возраст, но нет буквы
                    List<Human> list1 = new ArrayList<>();
                    list1.add(human);
                    result.get(entry.getKey()).put(firstChar, list1); //во внутренний мап добавляем букву и List с человеком
                    }
                }
            }
        }
        for (Map<Character, List<Human>> i : result.values()){
            for (List<Human> j : i.values()){
                j.sort(Collections.reverseOrder());//Сортировка по убыванию ФИО
            }
        }
        return result;
    }
}