INSERT INTO market.category(id, "name")
VALUES ('43558142-8251-4282-b392-8a0a84473697'::uuid, 'A');

INSERT INTO market.category(id, "name")
VALUES ('43558142-8251-4282-b392-8a0a84473698'::uuid, 'B');

INSERT INTO market.category(id, "name")
VALUES ('43558142-8251-4282-b392-8a0a84473699'::uuid, 'C');

INSERT INTO market.product
(id, "name", price, description, full_description, is_active, user_id, create_date, update_date, category_id)
VALUES('e8dec9eb-edc2-4ed7-8e4a-539cc9ed6c61'::uuid, 'A', 255, 'string', 'string', true, 'f67551a5-ee7c-4b75-a9f7-a2dacc7e01bf'::uuid, '2023-03-13 23:39:19.420', '2023-03-13 23:39:19.420', '43558142-8251-4282-b392-8a0a84473697'::uuid);

INSERT INTO market.product
(id, "name", price, description, full_description, is_active, user_id, create_date, update_date, category_id)
VALUES('e8dec9eb-edc2-4ed7-8e4a-539cc9ed6c62'::uuid, 'B', 255, 'string', 'string', true, 'f67551a5-ee7c-4b75-a9f7-a2dacc7e01bf'::uuid, '2023-03-13 23:39:19.420', '2023-03-13 23:39:19.420', '43558142-8251-4282-b392-8a0a84473697'::uuid);

