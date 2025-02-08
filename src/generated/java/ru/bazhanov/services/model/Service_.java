package ru.bazhanov.services.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Service.class)
public abstract class Service_ {

	public static volatile SingularAttribute<Service, Integer> duration;
	public static volatile SingularAttribute<Service, Boolean> deleted;
	public static volatile SetAttribute<Service, Order> orderSet;
	public static volatile SingularAttribute<Service, Double> price;
	public static volatile SetAttribute<Service, Client> clientSet;
	public static volatile SingularAttribute<Service, String> name;
	public static volatile SingularAttribute<Service, Integer> id;
	public static volatile SetAttribute<Service, Employee> employeeSet;

	public static final String DURATION = "duration";
	public static final String DELETED = "deleted";
	public static final String ORDER_SET = "orderSet";
	public static final String PRICE = "price";
	public static final String CLIENT_SET = "clientSet";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String EMPLOYEE_SET = "employeeSet";

}

