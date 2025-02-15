package ru.bazhanov.services.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, LocalDateTime> date;
	public static volatile SingularAttribute<Order, OurService> service;
	public static volatile SingularAttribute<Order, Client> client;
	public static volatile SingularAttribute<Order, Double> discount;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile SingularAttribute<Order, Employee> employee;
	public static volatile SingularAttribute<Order, TypeOfOrder> type;
	public static volatile SingularAttribute<Order, OrderStatus> status;

	public static final String DATE = "date";
	public static final String SERVICE = "service";
	public static final String CLIENT = "client";
	public static final String DISCOUNT = "discount";
	public static final String ID = "id";
	public static final String EMPLOYEE = "employee";
	public static final String TYPE = "type";
	public static final String STATUS = "status";

}

