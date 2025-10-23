package ru.bazhanov.project.model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contact.class)
public abstract class Contact_ {

	public static volatile SingularAttribute<Contact, String> phone;
	public static volatile SingularAttribute<Contact, String> name;
	public static volatile SingularAttribute<Contact, Client> client;
	public static volatile SingularAttribute<Contact, Integer> id;

	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String CLIENT = "client";
	public static final String ID = "id";

}

