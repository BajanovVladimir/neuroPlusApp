package ru.bazhanov.services.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OurService.class)
public abstract class OurService_ {

	public static volatile SingularAttribute<OurService, Integer> duration;
	public static volatile SingularAttribute<OurService, Boolean> deleted;
	public static volatile SetAttribute<OurService, Order> orderSet;
	public static volatile SingularAttribute<OurService, Double> price;
	public static volatile SetAttribute<OurService, Client> clientSet;
	public static volatile SingularAttribute<OurService, String> name;
	public static volatile SingularAttribute<OurService, Integer> id;
	public static volatile SetAttribute<OurService, Employee> employeeSet;

	public static final String DURATION = "duration";
	public static final String DELETED = "deleted";
	public static final String ORDER_SET = "orderSet";
	public static final String PRICE = "price";
	public static final String CLIENT_SET = "clientSet";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String EMPLOYEE_SET = "employeeSet";

}

