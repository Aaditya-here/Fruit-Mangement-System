package com.FruitMangementSystem.SpringBootCURDwithdatabase.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.FruitMangementSystem.SpringBootCURDwithdatabase.model.Fruit;


@RestController
public class Contoller {

	@Autowired
	SessionFactory sf;

	@GetMapping("get")
	// GET Single Record
	public Fruit getRecord() {
		Session ss = sf.openSession();
		Fruit fruit = ss.get(Fruit.class, 2);
		System.out.println(fruit);
		return fruit;
	}
	
	@GetMapping("get/{id}")
	// GET Single Record by link
	public Fruit getRecord(@PathVariable int id) {
		Session ss = sf.openSession();
		Fruit fruit = ss.get(Fruit.class, id);
		System.out.println(fruit);
		return fruit;
	}

	@GetMapping("getAllRecord")
	// GET Multiple Single Record
	public List<Fruit> getMultipleRecord() {
		Session ss = sf.openSession();
		Query query = ss.createQuery("from Fruit");
		List<Fruit> li = query.list();
		for (Fruit fruit : li) {
			System.out.println(fruit.getId());
			System.out.println(fruit.getFruit());
			System.out.println(fruit.getPrice());
		}
		return li;
	}

	@PostMapping("insert")
	public Fruit insertRecord(@RequestBody Fruit fruit) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		// Fruit fruit = new Fruit(4, "Strwberry", "800");
		ss.save(fruit);
		tx.commit();
		return fruit;
	}

	@PutMapping("update")
	public Fruit updateRecord(@RequestBody Fruit fruit) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		// Fruit fruit = new Fruit(4, "Strawberry", "800");
		ss.update(fruit);
		tx.commit();
		return fruit;
	}

	@DeleteMapping("delete/{id}")
	public Fruit deleteRecord(@PathVariable int id) {
		org.hibernate.Session ss = sf.openSession();
		org.hibernate.Transaction tx = ss.beginTransaction();
		Fruit fruit = ss.get(Fruit.class, id);
		ss.delete(fruit);
		tx.commit();
		return fruit;
	}
}
