package com.aruix.impl.lab.lab4;

public class MyList {
    private int value;
    private MyList next;

    public MyList(int value, MyList next) {
        this.value = value;
        this.next = next;
    }

    // LAB EXERCISE 4.1 MYLIST ITERATIVE SQUARE MUTATE

    /**
     * Square the elements of a MyList. Mutates the MyList.
     * 
     * @param list is a MyList object.
     */
    public static void iterSquareMutList(MyList list) {

    }

    // LAB EXERCISE 4.2 MYLIST RECURSIVE SQUARE MUTATE

    /**
     * Square the elements of a MyList. Mutates the MyList.
     * 
     * @param list is a MyList object.
     */
    public static void recSquareMutList(MyList list) {

        // base case
        if (list == null) {
            return;
        }
        // recursive step
        list.value *= list.value;
        recSquareMutList(list.next);
    }

    // LAB EXERCISE 4.3 MYLIST ITERATIVE SQUARE IMMUTATE

    /**
     * Square the elements of a MyList. Does not mutate the MyList.
     * 
     * @param list is a MyList object.
     * @return another MyList with all of input MyList's element squared.
     */
    public static MyList iterSquareList(MyList list) {
        // 一个新 list
        MyList node = new MyList(0, null);
        // 要返回出去的 header
        MyList header = node;
        // 一般来说都是 list.next 用于循环
        while (list.next != null) {
            // node value 赋值
            node.value = list.value * list.value;
            // node next 赋值
            node.next = new MyList(0, null);
            // 新列表迭代
            node = node.next;
            // 旧列表迭代
            list = list.next;
        }
        // 因为是 list.next 所以最后一个要补充一个值
        node.value = list.value * list.value;
        // 返回 header
        return header;
    }

    // LAB EXERCISE 4.4 MYLIST RECURSIVE SQUARE IMMUTATE

    /**
     * Square the elements of a MyList. Does not mutate the MyList.
     * 
     * @param list is a MyList object.
     * @return another MyList with all of input MyList's element squared.
     */
    public static MyList recSquareList(MyList list) {

        // base case
        if (list == null) {
            return null;
        }
        // recursive step
        return new MyList(list.value * list.value, recSquareList(list.next));

    }

    // EXERCISE 4.1 MYLIST ITERATIVE CATENATE MUTATE

    /**
     * Catenate two MyLists, listA and listB. Mutate listA.
     * 
     * @param listA is a MyList object.
     * @param listB is a MyList object.
     * @return a list consisting of the elements of listA followed by the elements
     *         of listB.
     */
    public static MyList iterCatMutList(MyList listA, MyList listB) {
        if (listA == null) {
            return listB;
        }
        if (listB == null) {
            return listA;
        }
        MyList listANode = listA;
        while (listANode.next != null) {
            listANode = listANode.next;
        }
        listANode.next = listB;
        return listA;
    }

    // EXERCISE 4.2 MYLIST RECURSIVE CATENATE MUTATE

    /**
     * Catenate two MyLists, listA and listB. Mutate listA.
     * 
     * @param listA is a MyList object.
     * @param listB is a MyList object.
     * @return a list consisting of the elements of listA followed by the elements
     *         of listB.
     */
    public static MyList recCatMutList(MyList listA, MyList listB) {

        if (listA == null)
            return listB;

        if (listA.next == null) {
            listA.next = listB;
        } else {
            recCatMutList(listA.next, listB);
        }
        return listA;
        // return new MyList(listA.value, recCatMutList(listA.next, listB));
    }

    // EXERCISE 4.3 MYLIST ITERATIVE CATENATE IMMUTATE

    /**
     * Catenate two MyLists, listA and listB. Does not mutate listA.
     * 
     * @param listA is a MyList object.
     * @param listB is a MyList object.
     * @return a list consisting of the elements of listA followed by the elements
     *         of listB.
     */
    public static MyList iterCatList(MyList listA, MyList listB) {
        // 一个新 list
        MyList node = new MyList(0, null);
        // 要返回出去的 header
        MyList header = node;
        MyList listAheader = listA;
        MyList listBheader = listB;
        while (listA.next != null) {
            node.value = listA.value;
            node.next = new MyList(0, null);
            node = node.next;
            listA = listA.next;
        }
        node.value = listA.value;
        node.next = listB;
        listA = listAheader;
        listB = listBheader;
        return header;
    }

    // EXERCISE 4.4 MYLIST RECURSIVE CATENATE IMMUTATE

    /**
     * Catenate two MyLists, listA and listB. Does not mutate listA.
     * 
     * @param listA is a MyList object.
     * @param listB is a MyList object.
     * @return a list consisting of the elements of listA followed by the elements
     *         of listB.
     */
    public static MyList recCatList(MyList listA, MyList listB) {
        MyList ans = new MyList(0, null);
        return recCatListHelper(ans, listA, listB);
    }

    public static MyList recCatListHelper(MyList ans, MyList listA, MyList listB) {

        // exception
        if (listA == null)
            return listB;

        // base case
        if (listA.next == null) {
            ans.value = listA.value;
            ans.next = listB;
        } else {
            // recursice case
            ans.value = listA.value;
            ans.next = new MyList(0, null);
            recCatListHelper(ans.next, listA.next, listB);
        }
        return ans;
    }

    /*
     *
     ***** Do NOT modify the codes below from the lecture notes! ***** Only for your
     * JUnit Testing purposes! *****
     *
     */

    /**
     * @return the size of the MyList iteratively.
     */
    public int iterSize() {
        MyList p = this;
        int size = 0;
        while (p != null) {
            size += 1;
            p = p.next;
        }
        return size;
    }

    /**
     * @return the size of the MyList recursively.
     */
    public int recSize() {
        // base case
        if (next == null) {
            return 1;
        }
        // recursive step
        return 1 + this.next.recSize();
    }

    /**
     * @param i is a valid index of MyList.
     * @return the ith value of this MyList.
     */
    public int get(int i) {
        // base case
        if (i == 0) {
            return value;
        }
        // recursive step
        return next.get(i - 1);
    }

    /**
     * @param args is a variable number of integers.
     * @return a new MyList containing the integers in args.
     */
    public static MyList ofEntries(Integer... args) {
        MyList result, p;
        if (args.length > 0) {
            result = new MyList(args[0], null);
        } else {
            return null;
        }
        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.next) {
            p.next = new MyList(args[k], null);
        }
        return result;
    }

    /**
     * @param l is a MyList object.
     * @return true iff l is a MyList object containing the same sequence of
     *         integers as this.
     */
    public boolean equals(Object l) {
        if (!(l instanceof MyList)) {
            return false;
        }
        MyList list = (MyList) l;
        MyList p;
        for (p = this; p != null && list != null; p = p.next, list = list.next) {
            if (p.value != list.value) {
                return false;
            }
        }
        if (p != null || list != null) {
            return false;
        }
        return true;
    }

    public String toString() {
        int size = this.recSize();
        String output = "[";
        for (int i = 0; i < size; i++) {
            output = output + this.get(i);
            if (i != size - 1)
                output = output + ", ";
        }
        output = output + "]";
        return output;
    }

}
