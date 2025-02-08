package ru.bazhanov.services.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, Boolean> deleted;
	public static volatile SetAttribute<Employee, Order> orderSet;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SetAttribute<Employee, Service> serviceSet;

	public static final String DELETED = "deleted";
	public static final String ORDER_SET = "orderSet";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SERVICE_SET = "serviceSet";

}

