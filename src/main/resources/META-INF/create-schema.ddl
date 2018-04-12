create table lease_work (id  bigserial not null, workCost int4 not null, product_id int4, primary key (id))
create table Product (id int4 not null, amount int4 not null, name varchar(255) not null, primary key (id))
alter table if exists lease_work add constraint FKjtrpvmvjnsgbo9nl1lxrrf6j1 foreign key (product_id) references Product
create table lease_work (id  bigserial not null, billNumber int4 not null, date timestamp not null, workCost int4 not null, product_id int4, primary key (id))
create table Product (id int4 not null, amount int4 not null, name varchar(255) not null, primary key (id))
alter table if exists lease_work add constraint FKjtrpvmvjnsgbo9nl1lxrrf6j1 foreign key (product_id) references Product
create table lease_work (id  bigserial not null, billNumber int4 not null, workCost int4 not null, yearMonth int4 not null, product_id int4, primary key (id))
create table Product (id int4 not null, amount int4 not null, name varchar(255) not null, primary key (id))
alter table if exists lease_work add constraint FKjtrpvmvjnsgbo9nl1lxrrf6j1 foreign key (product_id) references Product
create table lease_work_cost (id  bigserial not null, billNumber int4 not null, workCost int4 not null, yearMonth int4 not null, product_id int4, primary key (id))
create table Product (id int4 not null, amount int4 not null, name varchar(255) not null, primary key (id))
alter table if exists lease_work_cost add constraint FKi9dv2wb4lajnewblsqhip1nau foreign key (product_id) references Product
create table lease_work_cost (id  bigserial not null, billNumber int4 not null, workCost int4 not null, yearMonth int4 not null, product_id int4, primary key (id))
create table Product (id int4 not null, amount int4 not null, name varchar(255) not null, primary key (id))
alter table if exists lease_work_cost add constraint FKi9dv2wb4lajnewblsqhip1nau foreign key (product_id) references Product
create table lease_work_cost (id  bigserial not null, billNumber int4 not null, workCost int4 not null, yearMonth int4 not null, product_id int4, primary key (id))
create table Product (id int4 not null, amount int4 not null, name varchar(255) not null, primary key (id))
alter table if exists lease_work_cost add constraint FKi9dv2wb4lajnewblsqhip1nau foreign key (product_id) references Product
create table lease_work_cost (id  bigserial not null, billNumber int4 not null, workCost int4 not null, yearMonth int4 not null, product_id int4, primary key (id))
create table Product (id int4 not null, amount int4 not null, name varchar(255) not null, primary key (id))
alter table if exists lease_work_cost add constraint FKi9dv2wb4lajnewblsqhip1nau foreign key (product_id) references Product
create table lease_work_cost (id  bigserial not null, billNumber int4 not null, workCost int4 not null, yearMonth int4 not null, product_id int4, primary key (id))
create table Product (id int4 not null, amount int4 not null, name varchar(255) not null, primary key (id))
alter table if exists lease_work_cost add constraint FKi9dv2wb4lajnewblsqhip1nau foreign key (product_id) references Product
create table lease_work_cost (id  bigserial not null, billNumber int4 not null, cost int4 not null, yearMonth int4 not null, product_id int4, primary key (id))
create table material_cost (id  bigserial not null, cost int4 not null, selfProducedMaterialCost int4 not null, yearMonth int4 not null, product_id int4, primary key (id))
create table Product (id int4 not null, amount int4 not null, name varchar(255) not null, primary key (id))
alter table if exists lease_work_cost add constraint FKi9dv2wb4lajnewblsqhip1nau foreign key (product_id) references Product
alter table if exists material_cost add constraint FKot6nru0ksynmhw0skb2x7n7bf foreign key (product_id) references Product
