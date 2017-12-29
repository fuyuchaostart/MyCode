package com.fuyuchao;

import java.util.LinkedList;

/**
 * @author fycstart 邮箱: fycstart@126.com
 * @version 2017年12月29
 *          天变不足畏，祖宗不足法，人言不足恤
 */
class MyLinkedList<AnyType> {

    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    private int theSize;
    private int modCount;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    public MyLinkedList() {
        clear();
    }

    public void clear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
    }

    public int size() {
        return theSize;
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        addBefore(getNode(idx), x);
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }

    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private Node<AnyType> getNode(int idx) {
        Node<AnyType> p;

        if (idx < 0 || idx > size()) {
            System.out.println("IndexOutOfBoundsException");
        }

        if (idx <= size() / 2) {
            System.out.println(idx);
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }

        return p;

    }

    public boolean find(AnyType x) {
        Node<AnyType> p = beginMarker.next;
        for (int i = 0; i < size(); i++) {
            if (p.data == x) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    /**
     * 这个方法还有点问题，打印前面多了个null，昨天实在太困了，还没来得及完善，待续......
     **/
    public String toString() {
        String s = null;
        Node<AnyType> p = beginMarker.next;
        for (int i = 0; i < size(); i++) {
            s += p.data + ",";
            p = p.next;
        }
        return s;
    }


}