package pokerDemo;

/*
 *    洗牌： 洗编号
 *    发牌： 发编号
 */

import java.util.*;

public class PokerDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        ArrayList<Integer> array = new ArrayList<Integer>();

        String[] colors = {"♠", "♦", "♣", "♥"};
        String[] numbers = {"3", "4", "5", "6", "7",
                "8", "9", "10", "J", "Q", "K", "A", "2"};
        int index = 0;

        for (String number : numbers) {
            for (String color : colors) {
                String poker = color.concat(number);
                hm.put(index, poker);
                array.add(index);
                index++;
            }
        }
        hm.put(index, "小王");
        array.add(index);
        index++;
        hm.put(index, "大王");
        array.add(index);

        Collections.shuffle(array);

        System.out.println(array);

        TreeSet<Integer> Jack = new TreeSet<>();
        TreeSet<Integer> Tom  = new TreeSet<>();
        TreeSet<Integer> Young = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet<>();



        for (int x = 0; x < array.size(); x++) {
            if (x >= array.size() - 3) {
                dipai.add(array.get(x));
            } else if (x % 3 == 0) {
                Jack.add(array.get(x)); //return the element at the specified
                                        // position in this list
            } else if (x % 3 == 1) {
                Tom.add(array.get(x));
            } else if (x % 3 == 2) {
                Young.add(array.get(x));
            }
        }

        System.out.println(Jack);




        lookPoker("杀手杰克", Jack, hm);
        lookPoker("老诗人", Tom, hm);
        lookPoker("年轻人", Young, hm);
        lookPoker("底牌", dipai, hm);

    }

    public static void lookPoker(String name, TreeSet<Integer> ts,
                                 HashMap<Integer, String> hm) {
        System.out.println(name + "的牌是：");
        for (Integer key : ts) {
            String value = hm.get(key);
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
