create table "user"
(
    id          uuid      not null,
    email       varchar(255) UNIQUE,
    password    varchar(255),
    phone       varchar(10),
    create_date TIMESTAMP NOT NULL,
    update_date TIMESTAMP NOT NULL,
    CONSTRAINT "user_pk" PRIMARY KEY ("id")
);

CREATE TABLE role
(
    id      uuid not null,
    name    varchar(255),
    user_id uuid,
    CONSTRAINT "role_pk" PRIMARY KEY ("id"),
    CONSTRAINT role_key_user_id_foreign_key FOREIGN KEY (user_id) REFERENCES "user" (id)
);

CREATE TABLE "category"
(
    "id"   uuid         NOT NULL UNIQUE,
    "name" varchar(100) NOT NULL UNIQUE,
    CONSTRAINT "category_pk" PRIMARY KEY ("id")
);

CREATE TABLE "product"
(
    "id"               uuid          NOT NULL UNIQUE,
    "name"             varchar(100)  NOT NULL,
    "price"            integer       NOT NULL,
    "description"      varchar(500)  NOT NULL,
    "full_description" varchar(2000) NOT NULL,
    "is_active"        BOOLEAN       NOT NULL,
    "user_id"          uuid          NOT NULL,
    "create_date"      TIMESTAMP     NOT NULL,
    "update_date"      TIMESTAMP     NOT NULL,
    "category_id"      uuid          NOT NULL,
    CONSTRAINT "product_pk" PRIMARY KEY ("id"),
    CONSTRAINT "product_category_id_key" FOREIGN KEY ("category_id") REFERENCES "category" ("id")
);

CREATE TABLE image
(
    id         uuid         NOT NULL,
    product_id uuid         NOT NULL,
    name       varchar(500) NOT NULL,
    data       bytea        NOT NULL,
    "is_main"  bool         NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id),
    CONSTRAINT "image_product_id_key" FOREIGN KEY ("product_id") REFERENCES "product" ("id")
);

CREATE TABLE "order"
(
    "id"          uuid      NOT NULL,
    "user_id"     uuid      NOT NULL,
    "amount"      integer   NOT NULL,
    "create_date" TIMESTAMP NOT NULL,
    CONSTRAINT "order_pk" PRIMARY KEY ("id"),
    CONSTRAINT "order_user_id_" FOREIGN KEY ("user_id") REFERENCES "user" ("id")
);

CREATE TABLE "purchase"
(
    "id"          uuid      NOT NULL,
    "amount"      integer   NOT NULL,
    "order_id"    uuid      NOT NULL,
    "product_id"  uuid      NOT NULL,
    "create_date" TIMESTAMP NOT NULL,
    CONSTRAINT "purchase_pk" PRIMARY KEY ("id"),
    CONSTRAINT "purchase_product_id_key" FOREIGN KEY ("product_id") REFERENCES "product" ("id"),
    CONSTRAINT "purchase_order_id" FOREIGN KEY ("order_id") REFERENCES "order" ("id")
);


