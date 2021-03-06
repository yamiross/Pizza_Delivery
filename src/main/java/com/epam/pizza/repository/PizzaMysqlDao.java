package com.epam.pizza.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.epam.pizza.domain.Pizza;

@Repository("pizzaRepository")
public class PizzaMysqlDao implements PizzaRepository {
	@PersistenceContext
	private EntityManager em;

	public Pizza getPizzaById(Integer id) {
		return em.find(Pizza.class, id);
	}

	public List<Pizza> findAll() {
		TypedQuery<Pizza> pizzas = em.createNamedQuery("findAll",  Pizza.class);
		return pizzas.getResultList();
	}

	@Override
	public void modify(Pizza pizza) {
		em.merge(pizza);
	}

	public void save(Pizza pizza) {
		em.persist(pizza);
	}
}
