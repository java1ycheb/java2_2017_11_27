package Javaapp9;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Javaaap9 {
	
	public static void main(String[] args) {
		
	
	ArrayList<Person> simpleList = new ArrayList<>();
	simpleList.add(new Person("Name1",20));
	simpleList.add(new Person("Name2",30));
	
	
	ObservableList<Person> fxList = FXCollections.observableArrayList(simpleList);
	
	fxList.addListener (new ListChangeListener<Person>() {

		@Override
		public void onChanged(ListChangeListener.Change<? extends Person> c) {
			while(c.next()) {
				if(c.wasAdded()) {
					for (Person p: c.getAddedSubList()) {
						System.out.println("Added: " + p);
					}
					
				}
				else if(c.wasRemoved()) {
					for (Person p: c.getRemoved()) {
						System.out.println("Deleted: " + p);
					}
				}
			}
			
		}
		
	});
	
	
	
	simpleList.add(new Person("Name3",20));
	fxList.add(new Person("Name3",20));
	for (Person person : fxList) {
		person.age.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observer, Number oldValue, Number newValue) {
			 System.out.println("Old value: " +oldValue + ", new value " +newValue);
			}
		});
	
	fxList.remove(0);
	//fxList.get(0).age.setValue(fxList.get(0).age.get() +1 );
	
	for (Person p : simpleList) {
		System.out.println(p);
	}
	for (Person p :fxList) {
		System.out.println(p);
	}
	
	}

		
}
}

class Person {
	//int age;
	String name;
	IntegerProperty age = new SimpleIntegerProperty();
	
	public Person  (String name, int age) {
		this.age.set(age); 
		this.name = name;
	}
	@Override
	public String toString() {
		
		return "person : "+ name +" " + age.get();
	}
	

}