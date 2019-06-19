package com.alysoft.algobooks.ch3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
that type). They cannot select which specific animal they would like. Create the data structures to
maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
and dequeueCat. You may use the built-in Linkedlist data structure.
 * @author ymohammad
 *
 */
public class AnimalShelter
{
	private Queue<Dog> dogQueue = new LinkedList<Dog>();
	private Queue<Cat> catQueue = new LinkedList<Cat>();
	private int order = 0; // acts as timestamp
	
	public Animal dequeueAny() {
		
	}
	public boolean enqueue(Animal animal) {
		Queue<? extends Animal> animalQueue = null;
		if (animal instanceof Dog) {
			animalQueue = dogQueue;
		
		} else if (animal instanceof Cat) {
			animalQueue = catQueue;
		}
		
		if (animalQueue != null) {
			order++;
			animal.setOrder(order);
			return animalQueue.add(animal);
		}
		return false;
	}
	public static void main(String[] args)
	{

	}
	class Dog extends Animal {
		Dog(){
			super("Dog");
		}
	}
	class Cat extends Animal {
		Cat(){
			super("Cat");
		}
	}
	abstract class Animal {
		private int order;
		private String name;
		
		Animal(String n) {
			this.name = n;
		}
		public String getType() {
			return this.name;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public int getOrder() {
			return this.order;
		}
		public boolean isOlderThan(Animal a) {
			return this.order < a.order;
		}
	}
}
