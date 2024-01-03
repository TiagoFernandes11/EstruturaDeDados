package org.example.hashtable;

import java.util.ArrayList;

public class HashTable {
    private Integer size = 7;
    private Node[] dataMap;

    public HashTable() {
        this.dataMap = new Node[size];
    }

    public void set(String key, Integer value){
        Integer index = hash(key);
        Node newNode = new Node(key, value);
        insert(newNode, index);
    }

    private void insert(Node newNode, Integer index) {
        if(dataMap[index] == null) dataMap[index] = newNode;
        else {
            Node temp = dataMap[index];
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public Integer get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.getKey() == key) return temp.getValue();
            temp = temp.getNext();
        }
        return 0;
    }

    private Integer hash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for(int i = 0; i < keyChars.length; i++){
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for(int i = 0; i < dataMap.length; i ++){
            Node temp = dataMap[i];
            if(temp != null) allKeys.add(temp.getKey());
            while(temp != null && temp.getNext() != null){
                temp = temp.getNext();
                allKeys.add(temp.getKey());
            }
        }
        return allKeys;
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if(dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.getKey() + ", " + temp.getValue() + "}");
                    temp = temp.getNext();
                }
            }
        }
    }
}
