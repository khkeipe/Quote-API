INSERT INTO APP_USERS (EMAIL, PASSWORD, ROLE) VALUES ('admin@email.com', 'password', 'ADMIN')
INSERT INTO APP_USERS (EMAIL, PASSWORD, ROLE) VALUES ('test@user.com', 'secure', 'USER')
INSERT INTO APP_USERS (EMAIL, PASSWORD, ROLE) VALUES ('krstice@gmail.com', 'password', 'USER')

INSERT INTO POOL_SIZES (DEPTH, LENGTH, WIDTH) VALUES (8, 60, 40)
INSERT INTO POOL_SIZES (DEPTH, LENGTH, WIDTH) VALUES (8, 42, 20)
INSERT INTO POOL_SIZES (DEPTH, LENGTH, WIDTH) VALUES (6, 28, 16)

INSERT INTO POOLS (POOL_TYPE, POOL_CODE, POOL_METRIC, METRIC_CODE, SIZE_ID) VALUES ('EMERALD', 'EM', 'METRIC EMERALD', 'METEM', 1)
INSERT INTO POOLS (POOL_TYPE, POOL_CODE, POOL_METRIC, METRIC_CODE, SIZE_ID) VALUES ('EMERALD', 'EM', 'METRIC EMERALD', 'METEM', 2)
INSERT INTO POOLS (POOL_TYPE, POOL_CODE, POOL_METRIC, METRIC_CODE, SIZE_ID) VALUES ('BLUE LAGOON', 'BL', 'METRIC BLUI LAGOON', 'METBL', 3)

INSERT INTO DEALERS (DEALER_NAME, DEALER_CODE) VALUES ('Southeast Leisure Reps, Inc', '4-ALL-YOUR-POOL')
INSERT INTO DEALERS (DEALER_NAME, DEALER_CODE) VALUES ('Allen Pools', 'ALLENPOOLS')
INSERT INTO DEALERS (DEALER_NAME, DEALER_CODE) VALUES ('Alpine Pools', 'ALPINEPOOLS')
INSERT INTO DEALERS (DEALER_NAME, DEALER_CODE) VALUES ('Backyard Leisure', 'BACKYARDLEISURE')
INSERT INTO DEALERS (DEALER_NAME, DEALER_CODE) VALUES ('B&B Pools LLC', 'BANDBPOOLS')
INSERT INTO DEALERS (DEALER_NAME, DEALER_CODE) VALUES ('Burnett Pools, Inc.', 'BURNETTPOOLS')
INSERT INTO DEALERS (DEALER_NAME, DEALER_CODE) VALUES ('Central Iowa Pool & Spa', 'CENTRALIOWA')
INSERT INTO DEALERS (DEALER_NAME, DEALER_CODE) VALUES ('Clearwater Pool & Spa of Keene, Inc.', 'CLEARWATER')
INSERT INTO DEALERS (DEALER_NAME, DEALER_CODE) VALUES ('Complete Pool & Spa Care', 'COMPLETEPOOL')

