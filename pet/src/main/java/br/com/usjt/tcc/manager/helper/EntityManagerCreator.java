package br.com.usjt.tcc.manager.helper;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

//@Component
public class EntityManagerCreator{ //implements ComponentFactory<EntityManager> {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public EntityManagerCreator(EntityManagerFactory entityManagerFactory) {
		//this.entityManagerFactory = entityManagerFactory;
	}

	//@Override
	public EntityManager getInstance() {

		return this.entityManager;
	}

	@PostConstruct
	public void abre() {
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	@PreDestroy
	public void fecha() {
		this.entityManager.close();
	}

}