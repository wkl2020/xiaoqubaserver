-- Table: userentity

-- DROP TABLE userentity;

CREATE TABLE userentity
(
  id serial NOT NULL,
  confirmpassword character varying(255),
  createdate timestamp without time zone,
  email character varying(255),
  enable boolean NOT NULL,
  firstname character varying(255),
  lastname character varying(255),
  password character varying(255),
  phone character varying(255),
  role character varying(255),
  updatedate timestamp without time zone,
  username character varying(255),
  CONSTRAINT userentity_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE userentity
  OWNER TO postgres;
