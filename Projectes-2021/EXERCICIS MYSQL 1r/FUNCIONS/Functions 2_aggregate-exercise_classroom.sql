-- 1. CLIENT					
-- 		1. Quants clients hi han? 	
SELECT count(*) FROM CLIENT;

-- 		2. Quants surn2Cli hi han sense contar els nulls?		
SELECT count(surn2Cli) FROM CLIENT;

-- 		3. Quants surn2Cli diferents de clients hi han ?
SELECT count(DISTINCT surn2Cli) FROM CLIENT;				

-- 		4. Quants phoneNum hi han sense contar els nulls? 		
SELECT count(phoneNum) FROM CLIENT;			

-- 		5. Quants phoneNum diferents de clients hi han ? 	
SELECT count(DISTINCT phoneNum) FROM CLIENT;						

-- 		6. Quants clients hi han de cada ciutat? 		
SELECT count(DISTINCT idCity) FROM CLIENT;			

-- 		7. Quants clients hi han de Palma de Mallorca? 					
SELECT count(idCity) FROM CLIENT WHERE idCity in (SELECT idCity FROM CITY WHERE nameCity = 'Palma de Mallorca');

-- 		8. Quants clients hi han de Valencia? 					
SELECT count(idCity) FROM CLIENT WHERE idCity in (SELECT idCity FROM CITY WHERE nameCity = 'Valencia');

				
					
-- 2. PRODUCT					
-- 		1. Quants productes hi han? 					
SELECT count(*) FROM PRODUCT;

-- 		2. Quantes descripcións de productes hi han sense contar els nulls? 					
SELECT count(descriptPro) FROM PRODUCT;

-- 		3. Quantes descripcións diferents de productes hi han ? 					
SELECT count(DISTINCT descriptPro) FROM PRODUCT;

-- 		4. Quin es el mayor preu de producte?					
SELECT max(pricePro)as result FROM PRODUCT;

-- 		5. Quin es el producte amb mayor preu I quin preu es?					
SELECT max(pricePro) FROM PRODUCT;

-- 		6. Quin es el menor preu de producte?					
SELECT min(pricePro) FROM PRODUCT;

-- 		7. Quin es el producte amb menor preu I quin preu es?					
SELECT min(pricePro) FROM PRODUCT;

-- 		8. Quina es la mitjana de preus?					
SELECT AVG(pricePro) FROM PRODUCT;

-- 		9. Mostra el resultat del punt anterior arodonint automàticament cap amunt o cap a baix amb 2 decimals					
SELECT floor(AVG(pricePro)) FROM PRODUCT;
SELECT ceil(AVG(pricePro)) FROM PRODUCT;

-- 		10. Quina es la desviació tipica dels preus? Mostra-ho amb 2 funcions agregades diferents					
SELECT STD(pricePro) FROM PRODUCT;

-- 		11. Mostra el resultat del punt anterior arodonint automàticament cap amunt o cap a baix amb 2 decimals					
SELECT floor(STD(pricePro)) FROM PRODUCT;
SELECT ceil(STD(pricePro)) FROM PRODUCT;

-- 		12. Quina es suma total dels preus? 					
SELECT SUM(pricePro) FROM PRODUCT;

-- 3. PRODUCT-CLIENT					
-- 		1. Quantes vendes hi han? 		
SELECT count(*), purchaseDT FROM product_client group by purchaseDT;

-- 		2. Quantes purchaseDT diferents. 					
SELECT count(distinct purchaseDT) FROM product_client;

-- 		3. Quantes compres ha fet cada client? 					
SELECT count(idPro), idCli FROM product_client group by idCli;

-- 		3. Quantes compres ha fet el client 1? 					
SELECT count(idPro), idCli FROM product_client where idCli=1;

-- 		3. Quantes compres ha fet el client 2? 					
SELECT count(idPro), idCli FROM product_client where idCli=2;
