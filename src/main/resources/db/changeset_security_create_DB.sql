-- drops

DROP TABLE IF EXISTS public.users_roles;

DROP SEQUENCE IF EXISTS public.users_roles_id_seq;

DROP TABLE IF EXISTS public.users CASCADE;

DROP SEQUENCE IF EXISTS public.users_id_seq;

DROP TABLE IF EXISTS public.roles;

DROP SEQUENCE IF EXISTS public.roles_id_seq;

DROP TABLE IF EXISTS public.persons;

DROP SEQUENCE IF EXISTS public.persons_id_seq;

-- creates

CREATE SEQUENCE public.users_id_seq
    INCREMENT 1
    START WITH 1;

CREATE TABLE IF NOT EXISTS public.users
(
    user_id integer NOT NULL DEFAULT nextval('users_id_seq'),
    login varchar NOT NULL,
    password varchar NOT NULL DEFAULT 'password',
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

CREATE SEQUENCE IF NOT EXISTS public.roles_id_seq
    INCREMENT 1
    START WITH 1;

CREATE TABLE IF NOT EXISTS public.roles
(
    role_id integer NOT NULL DEFAULT nextval('roles_id_seq'),
    name varchar NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (role_id)
);

CREATE SEQUENCE IF NOT EXISTS public.users_roles_id_seq
    INCREMENT 1
    START WITH 1;

CREATE TABLE IF NOT EXISTS public.users_roles
(
    user_role_id integer NOT NULL DEFAULT nextval('users_roles_id_seq'),
    user_id integer NOT NULL,
    role_id integer NOT NULL,
    CONSTRAINT users_roles_pkey PRIMARY KEY (user_role_id),
    CONSTRAINT users_roles_roles_fkey
          FOREIGN KEY(role_id)
    	  REFERENCES public.roles(role_id)ON DELETE CASCADE,
    CONSTRAINT users_roles_users_fkey
              FOREIGN KEY(user_id)
        	  REFERENCES public.users(user_id)ON DELETE CASCADE
);

CREATE SEQUENCE public.persons_id_seq
    INCREMENT 1
    START WITH 1;
CREATE TABLE IF NOT EXISTS public.persons
(
    person_id integer NOT NULL  DEFAULT nextval('persons_id_seq'),
    user_id integer NOT NULL,
	name varchar NOT NULL,
	CONSTRAINT persons_pkey PRIMARY KEY (person_id),
	  CONSTRAINT person_user_fkey
          FOREIGN KEY(user_id)
    	  REFERENCES public.users(user_id)
    	  ON DELETE CASCADE
);
-- //---------------------------------------------------------------------------------


