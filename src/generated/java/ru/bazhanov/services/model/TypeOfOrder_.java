package ru.bazhanov.services.model;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TypeOfOrder.class)
public abstract class TypeOfOrder_ {

	public static volatile SetAttribute<TypeOfOrder, Order> orderSet;
	public static volatile SingularAttribute<TypeOfOrder, String> name;
	public static volatile SingularAttribute<TypeOfOrder, Integer> id;

	public static final String ORDER_SET = "orderSet";
	public static final String NAME = "name";
	public static final String ID = "id";

}

