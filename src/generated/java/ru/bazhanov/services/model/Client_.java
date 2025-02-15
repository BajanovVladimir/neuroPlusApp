package ru.bazhanov.services.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ {

	public static volatile SingularAttribute<Client, Boolean> deleted;
	public static volatile SingularAttribute<Client, String> phone;
	public static volatile SetAttribute<Client, Order> orderSet;
	public static volatile SingularAttribute<Client, String> name;
	public static volatile SingularAttribute<Client, Integer> id;
	public static volatile SetAttribute<Client, OurService> serviceSet;

	public static final String DELETED = "deleted";
	public static final String PHONE = "phone";
	public static final String ORDER_SET = "orderSet";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SERVICE_SET = "serviceSet";

}

