-- public.categoria definition

-- Drop table

-- DROP TABLE public.categoria;

CREATE TABLE public.categoria (
	id_categoria serial4 NOT NULL,
	nome_categoria varchar(255) NULL,
	imagem varchar(100) NULL,
	CONSTRAINT categoria_pkey PRIMARY KEY (id_categoria)
);


-- public.estoque definition

-- Drop table

-- DROP TABLE public.estoque;

CREATE TABLE public.estoque (
	id_estoque serial4 NOT NULL,
	id_produto int8 NULL,
	quantidade int8 NULL,
	CONSTRAINT estoque_pkey PRIMARY KEY (id_estoque)
);


-- public.fornecedor definition

-- Drop table

-- DROP TABLE public.fornecedor;

CREATE TABLE public.fornecedor (
	id_fornecedor serial4 NOT NULL,
	tipo varchar(255) NULL,
	razao_social varchar(255) NULL,
	cnpj varchar(14) NOT NULL,
	uf varchar(2) NULL,
	telefone varchar(100) NULL,
	email varchar(255) NULL,
	nome_fantasia varchar(255) NULL,
	status_situacao varchar(100) NULL,
	bairro varchar(255) NULL,
	logradouro varchar(255) NULL,
	numero int8 NULL,
	complemento varchar(100) NULL,
	cep varchar(10) NULL,
	municipio varchar(255) NULL,
	data_abertura timestamp NULL,
	CONSTRAINT fornecedor_pkey PRIMARY KEY (id_fornecedor)
);


-- public.perfil definition

-- Drop table

-- DROP TABLE public.perfil;

CREATE TABLE public.perfil (
	id_perfil serial4 NOT NULL,
	nome_perfil varchar(100) NULL,
	CONSTRAINT perfil_pkey PRIMARY KEY (id_perfil)
);


-- public.usuario definition

-- Drop table

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario (
	id_usuario serial4 NOT NULL,
	nome_usuario varchar(100) NULL,
	email varchar(100) NULL,
	senha varchar(255) NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario)
);


-- public.produto definition

-- Drop table

-- DROP TABLE public.produto;

CREATE TABLE public.produto (
	id_produto serial4 NOT NULL,
	sku varchar(255) NULL,
	nome_produto varchar(255) NULL,
	id_fornecedor int8 NOT NULL,
	id_categoria int8 NOT NULL,
	imagem_produto varchar(255) NULL,
	CONSTRAINT produto_pkey PRIMARY KEY (id_produto),
	CONSTRAINT produto_id_categoria_fkey FOREIGN KEY (id_categoria) REFERENCES public.categoria(id_categoria),
	CONSTRAINT produto_id_fornecedor_fkey FOREIGN KEY (id_fornecedor) REFERENCES public.fornecedor(id_fornecedor)
);


-- public.usuario_rel_perfil definition

-- Drop table

-- DROP TABLE public.usuario_rel_perfil;

CREATE TABLE public.usuario_rel_perfil (
	id_usuario int8 NULL,
	id_perfil int8 NULL,
	CONSTRAINT usuario_rel_perfil_id_perfil_fkey FOREIGN KEY (id_perfil) REFERENCES public.perfil(id_perfil),
	CONSTRAINT usuario_rel_perfil_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario)
);


INSERT INTO "PUBLIC"."CATEGORIA" (NOME_CATEGORIA,IMAGEM) VALUES
	 ('Camisaria',NULL),
	 ('Categoria Com Foto','2_camisetas-pack.webp'),
	 ('Categoria Com Foto','3_camisetas-pack.webp'),
	 ('Categoria Com Foto','4_camisetas-pack.webp'),
	 ('Categoria Com Foto','5_camisetas-pack.webp'),
	 ('Nova Categoria com Foto','6_calca-sarja.jpg'),
	 ('Categoria Email','7_camisetas-pack.webp'),
	 ('Categoria Email 2','8_camisetas-pack.webp');
INSERT INTO "PUBLIC"."ESTOQUE" (ID_PRODUTO,QUANTIDADE) VALUES
	 (1,10),
	 (3,30);
INSERT INTO "PUBLIC"."FORNECEDOR" (TIPO,RAZAO_SOCIAL,CNPJ,UF,TELEFONE,EMAIL,NOME_FANTASIA,STATUS_SITUACAO,BAIRRO,LOGRADOURO,NUMERO,COMPLEMENTO,CEP,MUNICIPIO,DATA_ABERTURA) VALUES
	 ('Matriz','Primeiro Fornecedor','01111222000100','RJ','2125874125','email@mail.com','Nome Fantasia','Ativo','Centro','Rua Principal',10,'','25600000','Petrópolis','2022-05-27 09:23:36.461');
INSERT INTO "PUBLIC"."PERFIL" (NOME_PERFIL) VALUES
	 ('ROLE_USER');
INSERT INTO "PUBLIC"."PRODUTO" (SKU,NOME_PRODUTO,ID_FORNECEDOR,ID_CATEGORIA,IMAGEM_PRODUTO) VALUES
	 ('C1','Camiseta Star Wars',1,1,NULL),
	 ('CL1','Calça Sarja',1,1,'3_calca-sarja.jpg'),
	 ('BM1','Bermuda Azul',1,1,'4_bermuda.webp');
INSERT INTO "PUBLIC"."USUARIO" (NOME_USUARIO,EMAIL,SENHA) VALUES
	 ('usuario','usuario@mail.com','$2a$12$3COb/LHNYO/JeLWy1ExGFe6U2iyFczP70/kBUEHbf9miQ4Vp64A42');
INSERT INTO "PUBLIC"."USUARIO_REL_PERFIL" (ID_USUARIO,ID_PERFIL) VALUES
	 (1,1);
