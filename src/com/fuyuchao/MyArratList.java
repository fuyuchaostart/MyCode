package com.fuyuchao;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月29
 *          天变不足畏，祖宗不足法，人言不足恤
 */

class MyArrayList<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private AnyType[] theItems;

    /**
     * 返回ArrayList的长度
     *
     * @return
     */
    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 集合的扩容
     *
     * @param newCapacity
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size()) {
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public MyArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx >= size()) {
            return null;
        } else {
            return theItems[idx];
        }
    }

    /**
     * 修改值
     *
     * @param idx
     * @param newVal
     * @return
     */
    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx >= size()) {
            return null;
        } else {
            AnyType old = theItems[idx];
            theItems[idx] = newVal;
            return old;
        }

    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        //需要扩容了
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i++) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    public AnyType remove(int idx) {
        AnyType removedItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++) { //为什么不是size()
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removedItem;
    }


}