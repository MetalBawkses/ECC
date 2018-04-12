CREATE TABLE "product" (
  "id" integer NOT NULL,
  "product_name" VARCHAR(255) NOT NULL,
  "amount" integer NOT NULL,
  CONSTRAINT product_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "worker" (
  "id" integer NOT NULL,
  "name" VARCHAR(255) NOT NULL,
  "place_id" integer NOT NULL,
  CONSTRAINT worker_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "place" (
  "id" integer NOT NULL,
  "name" integer NOT NULL,
  CONSTRAINT place_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "worksheet_cost" (
  "product_id" integer NOT NULL,
  "worker_id" integer NOT NULL,
  "hour" integer NOT NULL,
  "date" integer NOT NULL
) WITH (
OIDS=FALSE
);



CREATE TABLE "material_cost" (
  "product_id" integer NOT NULL,
  "material_cost" integer NOT NULL,
  "self_produced_material_cost" integer NOT NULL,
  "self_produced_finished" integer NOT NULL,
  "date" integer NOT NULL
) WITH (
OIDS=FALSE
);



CREATE TABLE "lease_work" (
  "product_id" integer NOT NULL,
  "bill_number" integer NOT NULL,
  "lease_work_cost" integer NOT NULL,
  "date" integer NOT NULL
) WITH (
OIDS=FALSE
);



CREATE TABLE "board" (
  "product_id" integer NOT NULL
) WITH (
OIDS=FALSE
);



CREATE TABLE "worker_monthly" (
  "worker_id" integer NOT NULL,
  "social_contribution" integer NOT NULL,
  "social_contribution_preference" integer NOT NULL,
  "vocational_training_contribution" integer NOT NULL,
  "vocational_training_contribution_preference" integer NOT NULL,
  "date" integer NOT NULL
) WITH (
OIDS=FALSE
);



CREATE TABLE "product_into_stock" (
  "product_id" integer NOT NULL,
  "date" integer NOT NULL,
  "amount" integer NOT NULL,
  "voucher_number" integer NOT NULL
) WITH (
OIDS=FALSE
);



CREATE TABLE "packaging_order" (
  "id" integer NOT NULL,
  CONSTRAINT packaging_order_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "invoice" (
  "id" integer NOT NULL,
  "direction" VARCHAR(255) NOT NULL,
  "date" integer NOT NULL,
  CONSTRAINT invoice_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "packaging_order_content" (
  "packaging_order_id" integer NOT NULL,
  "product_id" integer NOT NULL,
  "amount" integer NOT NULL
) WITH (
OIDS=FALSE
);




ALTER TABLE "worker" ADD CONSTRAINT "worker_fk0" FOREIGN KEY ("place_id") REFERENCES "place"("id");


ALTER TABLE "worksheet_cost" ADD CONSTRAINT "worksheet_cost_fk0" FOREIGN KEY ("product_id") REFERENCES "product"("id");
ALTER TABLE "worksheet_cost" ADD CONSTRAINT "worksheet_cost_fk1" FOREIGN KEY ("worker_id") REFERENCES "worker"("id");

ALTER TABLE "material_cost" ADD CONSTRAINT "material_cost_fk0" FOREIGN KEY ("product_id") REFERENCES "product"("id");

ALTER TABLE "lease_work" ADD CONSTRAINT "lease_work_fk0" FOREIGN KEY ("product_id") REFERENCES "product"("id");

ALTER TABLE "board" ADD CONSTRAINT "board_fk0" FOREIGN KEY ("product_id") REFERENCES "product"("id");

ALTER TABLE "worker_monthly" ADD CONSTRAINT "worker_monthly_fk0" FOREIGN KEY ("worker_id") REFERENCES "worker"("id");

ALTER TABLE "product_into_stock" ADD CONSTRAINT "product_into_stock_fk0" FOREIGN KEY ("product_id") REFERENCES "product"("id");



ALTER TABLE "packaging_order_content" ADD CONSTRAINT "packaging_order_content_fk0" FOREIGN KEY ("packaging_order_id") REFERENCES "packaging_order"("id");
ALTER TABLE "packaging_order_content" ADD CONSTRAINT "packaging_order_content_fk1" FOREIGN KEY ("product_id") REFERENCES "product"("id");

