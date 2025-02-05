-- //--------------------DROPS
 DROP TABLE IF EXISTS public.clients CASCADE;
 DROP SEQUENCE IF EXISTS public.clients_id_seq;

 DROP TABLE IF EXISTS public.types_of_order CASCADE;
 DROP SEQUENCE IF EXISTS public.types_of_order_id_seq;

 DROP TABLE IF EXISTS public.oder_statuses;
 DROP SEQUENCE IF EXISTS public.order_statuses_id_seq CASCADE;

 DROP TABLE IF EXISTS public.services CASCADE;
 DROP SEQUENCE IF EXISTS public.services_id_seq;

 DROP TABLE IF EXISTS public.employees CASCADE;
 DROP SEQUENCE IF EXISTS public.employee_id_seq;

 DROP TABLE IF EXISTS public.orders;
 DROP SEQUENCE IF EXISTS public.order_id_seq;

 DROP TABLE IF EXISTS public.services_employees;
 DROP SEQUENCE IF EXISTS public.services_employees_id_seq;

 DROP TABLE IF EXISTS public.clients_services;
 DROP SEQUENCE IF EXISTS public.clients_services_id_seq;
 -- //------------------End Drops

 CREATE SEQUENCE public.clients_id_seq
     INCREMENT 1
     START WITH 1;

 CREATE TABLE IF NOT EXISTS public.clients
 (
     client_id integer NOT NULL DEFAULT nextval('clients_id_seq'),
     client_name varchar NOT NULL,
     client_phone varchar NOT NULL DEFAULT '+70000000000',
 	client_deleted boolean NOT NULL DEFAULT FALSE,
     CONSTRAINT clients_pkey PRIMARY KEY (client_id)
 );

 CREATE SEQUENCE public.types_of_order_id_seq
     INCREMENT 1
     START WITH 1;

 CREATE TABLE IF NOT EXISTS public.types_of_order
 (
     type_id integer NOT NULL DEFAULT nextval('types_of_order_id_seq'),
     type_name varchar NOT NULL,
     CONSTRAINT types_of_order_pkey PRIMARY KEY (type_id)
 );

 CREATE SEQUENCE public.order_statuses_id_seq
     INCREMENT 1
     START WITH 1;

 CREATE TABLE IF NOT EXISTS public.order_statuses
 (
     status_id integer NOT NULL DEFAULT nextval('order_statuses_id_seq'),
     status_name varchar NOT NULL,
     CONSTRAINT order_statuses_pkey PRIMARY KEY (status_id)
 );

 CREATE SEQUENCE public.services_id_seq
     INCREMENT 1
 	START WITH 1;

 CREATE TABLE IF NOT EXISTS public.services
 (
 	service_id integer NOT NULL DEFAULT nextval('services_id_seq'),
 	service_name varchar NOT NULL,
 	service_price decimal NOT NULL DEFAULT 0.0,
 	service_duration integer NOT NULL DEFAULT 60,
 	service_deleted boolean NOT NULL DEFAULT FALSE,
 	CONSTRAINT services_pkey PRIMARY KEY (service_id)
 );

 CREATE SEQUENCE IF NOT EXISTS public.employees_id_seq
     INCREMENT 1
 	START WITH 1;

 CREATE	TABLE IF NOT EXISTS public.employees
 (
 	employee_id integer NOT NULL DEFAULT nextval('employees_id_seq'),
 	employee_name varchar NOT NULL,
 	employee_deleted boolean NOT NULL DEFAULT FALSE,
 	CONSTRAINT emploees_pkey PRIMARY KEY (employee_id)
 );

 CREATE SEQUENCE IF NOT EXISTS public.services_employees_id_seq
     INCREMENT 1
 	START WITH 1;

 CREATE TABLE IF NOT EXISTS public.services_employees
 (
 	service_employee_id integer NOT NULL DEFAULT nextval('services_employees_id_seq'),
 	service_id integer NOT NULL,
 	employee_id integer NOT NULL,
 	CONSTRAINT services_employees_pkey PRIMARY KEY (service_employee_id),
 	CONSTRAINT services_employees_employees_fkey
 	    FOREIGN KEY(employee_id)
 	    REFERENCES public.employees(employee_id)ON DELETE CASCADE,
 	CONSTRAINT services_employees_services_fkey
 	    FOREIGN KEY(service_id)
 	    REFERENCES public.services(service_id)ON DELETE CASCADE
 );

 CREATE SEQUENCE IF NOT EXISTS public.clients_services_id_seq
     INCREMENT 1
 	START WITH 1;

 CREATE TABLE IF NOT EXISTS public.clients_services
 (
 	client_service_id integer NOT NULL DEFAULT nextval('clients_services_id_seq'),
 	client_id integer NOT NULL,
 	service_id integer NOT NULL,
 	CONSTRAINT clients_services_pkey PRIMARY KEY (client_service_id),
 	CONSTRAINT clients_services_client_fkey
 	    FOREIGN KEY(client_id)
 	    REFERENCES public.clients(client_id)ON DELETE CASCADE,
 	CONSTRAINT clients_services_service_fkey
 	    FOREIGN KEY(service_id)
 	    REFERENCES public.services(service_id)ON DELETE CASCADE
 );


 CREATE SEQUENCE IF NOT EXISTS public.orders_id_seq
     INCREMENT 1
 	START WITH 1;

 CREATE TABLE IF NOT EXISTS public.orders
 (
 	order_id integer NOT NULL DEFAULT nextval('orders_id_seq'),
 	order_date timestamp NOT NULL,
 	client_id integer NOT NULL,
 	service_id integer NOT NULL,
 	employee_id integer NOT NULL,
 	order_discount decimal NOT NULL DEFAULT 0.0,
 	type_id integer NOT NULL,
 	status_id integer NOT NULL,
 	CONSTRAINT orders_pkey PRIMARY KEY (order_id),
 	CONSTRAINT orders_clients_fkey
 	    FOREIGN KEY(client_id)
 	    REFERENCES public.clients(client_id)ON DELETE CASCADE,
 	CONSTRAINT orders_services_fkey
 	    FOREIGN KEY(service_id)
 	    REFERENCES public.services(service_id)ON DELETE CASCADE,
 	CONSTRAINT orders_employees_fkey
 	    FOREIGN KEY(employee_id)
 	    REFERENCES public.employees(employee_id)ON DELETE CASCADE,
 	CONSTRAINT orders_types_fkey
 	    FOREIGN KEY(type_id)
 	    REFERENCES public.types_of_order(type_id)ON DELETE CASCADE,
 	CONSTRAINT orders_statuses_fkey
 	    FOREIGN KEY(status_id)
 	    REFERENCES public.order_statuses(status_id)ON DELETE CASCADE
 );