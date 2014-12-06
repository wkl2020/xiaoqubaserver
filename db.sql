-- Table 1: userentity
CREATE TABLE userentity
(
  id serial NOT NULL,
  confirm_password character varying(255),
  email character varying(255),
  enable boolean NOT NULL DEFAULT FALSE,
  firstname character varying(255),
  lastname character varying(255),
  username character varying(255),
  password character varying(255),
  phone character varying(255),
  role character varying(255),
  token character varying(255),
  nickname character varying(255),
  address character varying(255),
  xiaoqu_id bigint, 
  company_name character varying(255),
  deleted boolean NOT NULL DEFAULT FALSE,
  version bigint NOT NULL DEFAULT 0,
  create_date timestamp without time zone,
  update_date timestamp without time zone,
  
  CONSTRAINT userentity_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE userentity
  OWNER TO postgres;
  
  
-- Table 2: xiaoqu 
CREATE TABLE xiaoqu
(
  id serial NOT NULL,
  city character varying(255),
  address character varying(255),
  name character varying(255),
  description character varying(1000),
  build_company character varying(255),
  manage_company character varying(255),
  owner character varying(255),
  x numeric,
  y numeric,
  creator_id bigint,
  updator_id bigint,
  deleted boolean NOT NULL DEFAULT FALSE,
  version bigint NOT NULL DEFAULT 0,
  create_date timestamp without time zone,
  update_date timestamp without time zone,
  
  CONSTRAINT xiaoqu_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE xiaoqu
  OWNER TO postgres;  
  

-- Table 3: document
CREATE TABLE document
(
  id serial NOT NULL,
  xiaoqu_id bigint NOT NULL, 
  document_type character varying(255),
  owner character varying(255),
  manage_company character varying(255),
  title character varying(255),
  content text,
  replay_count bigint NOT NULL DEFAULT 0, 
  creator_id bigint,
  updator_id bigint,
  deleted boolean NOT NULL DEFAULT FALSE,
  version bigint NOT NULL DEFAULT 0,
  create_date timestamp without time zone,
  update_date timestamp without time zone,
  publish_date timestamp without time zone,
  expire_date timestamp without time zone,
  
  CONSTRAINT document_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE document
  OWNER TO postgres;  
  
  
-- Table 4: document_comment
CREATE TABLE document_comment
(
  id serial NOT NULL,
  document_id bigint NOT NULL, 
  document_type character varying(255),
  content character varying(1000),
  nickname character varying(255),
  creator_id bigint,
  updator_id bigint,
  deleted boolean NOT NULL DEFAULT FALSE,
  version bigint NOT NULL DEFAULT 0,
  create_date timestamp without time zone,
  update_date timestamp without time zone,
  
  CONSTRAINT document_comment_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE document_comment
  OWNER TO postgres;    
  

-- Table 4: document_evaluation
CREATE TABLE document_evaluation
(
  id serial NOT NULL,
  document_id bigint NOT NULL, 
  document_type character varying(255),
  evaluation_type character varying(255),
  nickname character varying(255),
  deleted boolean NOT NULL DEFAULT FALSE,
  version bigint NOT NULL DEFAULT 0,
  create_date timestamp without time zone,
  
  CONSTRAINT document_evaluation_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE document_evaluation
  OWNER TO postgres;     
