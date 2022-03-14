drop schema if exists market cascade;

create schema market;

create table market.manufacturer (
	Id		serial primary key,
	name	text not null
);

create table market.category (
	Id		serial primary key,
	name	text not null
);

create table market.product (
	Id				serial primary key,
	name			text not null,
	description		text,
	manufacturerId	int,
	categoryId		int,
	
	constraint product_manufacturer_fk
		foreign key (manufacturerId)
		references market.manufacturer (Id)
			on delete cascade,
			
	constraint product_category_fk
		foreign key (categoryId)
		references market.category (Id)
			on delete cascade
);

insert into market.manufacturer (name) values ('Lacticínios Tirol');
insert into market.manufacturer (name) values ('Ambev');
insert into market.manufacturer (name) values ('Procter & Gamble');

insert into market.category (name) values ('Lácteos');
insert into market.category (name) values ('Bebidas');
insert into market.category (name) values ('Higiene pessoal');

insert into market.product (name, description, manufacturerId, categoryId) values ('Nata', 'Nata Tirol Pote 300g', 1, 1);
insert into market.product (name, description, manufacturerId, categoryId) values ('Leite desnatado', 'Leite UHT Tirol Desnatado 1L', 1, 1);
insert into market.product (name, description, manufacturerId, categoryId) values ('Iorgute', 'Iogurte Tirol 160g Natural Integral', 1, 1);
insert into market.product (name, description, manufacturerId, categoryId) values ('Queijo mussarela', 'Queijo Mussarela Fatiado Tirol Pacote 150g', 1, 1);
insert into market.product (name, description, manufacturerId, categoryId) values ('Ceveja Patagonia', 'Cerveja Patagonia Amber Lager Garrafa 740ml', 2, 2);
insert into market.product (name, description, manufacturerId, categoryId) values ('Cerveja Skol', 'Cerveja Skol Lata 350ml', 2, 2);
insert into market.product (name, description, manufacturerId, categoryId) values ('Ceveja Bohemia', 'Cerveja Puro Malte Bohemia Lata Sleek 350ml', 2, 2);
insert into market.product (name, description, manufacturerId, categoryId) values ('Cerveja Colorado', 'Bebida Alcoólica Mista Colorado Appia Garrafa 600ml', 2, 2);
insert into market.product (name, description, manufacturerId, categoryId) values ('Creme dental', 'Creme Dental Menta Refrescante Oral-B Caixa 70g', 3, 3);
insert into market.product (name, description, manufacturerId, categoryId) values ('Shampoo', 'Shampoo Anticoceira Head & Shoulders Frasco 200ml', 3, 3);
insert into market.product (name, description, manufacturerId, categoryId) values ('Absorvente', 'Protetor Diário sem Abas Always Pacote 15 Unidades', 3, 3);
insert into market.product (name, description, manufacturerId, categoryId) values ('Fralda', 'Fraldas Descartáveis XXG Supersec Pampers Pacotão 20 Unidades', 3, 3);

