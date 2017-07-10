package org.light4j.concurrency.chapter5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, String> hh = new HashMap<>();
		System.out.println(hh.put("a", "a"));
		System.out.println(hh.put("a", "n"));
		Set<String> keys = hh.keySet();
		System.out.println(keys);
		hh.put("b", "b");
		System.out.println(keys);
		System.out.println(hh.entrySet());

		ConcurrentHashMap<String, String> ch = new ConcurrentHashMap<>();
		ch.put("s", "s");

		ArrayList<String> list = new ArrayList<>();
		Iterator<String> iterator = list.iterator();
		Vector<String> v = new Vector<>();
		Stack<String> stack = new Stack<>();
		Queue<String> q = new PriorityQueue<>();
		Deque<String> d = new ArrayDeque<>();

		HashSet<String> hash = new HashSet<>();
		TreeSet<String> tree = new TreeSet<>();

		LinkedList<String> link = new LinkedList<>();

		CountDownLatch cdl = new CountDownLatch(2);
		
		CyclicBarrier cb =new CyclicBarrier(2);
		
		Semaphore s = new Semaphore(10);
		
		Exchanger<String> e = new Exchanger<>();
	}
}