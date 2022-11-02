-- 1. cartesian product between editorial and city							
SELECT nameE, nameCity
from EDITORIAL, CITY;

-- 2. cartesian product between editorial and book							
SELECT EDITORIAL.nameE, BOOK.titleB
from EDITORIAL, BOOK;

-- 3. cartesian product between city and book							
SELECT nameCity, titleB
from CITY, BOOK;

-- 4. inner join between editorial and city. Deliver 2 ways of doing the same							
SELECT EDITORIAL.CityE, CITY.idCity
from EDITORIAL inner join CITY
on EDITORIAL.CityE = CITY.idCity;

-- No es pot fer emprant using perque el nom de les claus no es comú.

-- 5. inner join between editorial and book. Deliver 2 ways of doing the same							
SELECT EDITORIAL.idE, BOOK.idE
from EDITORIAL inner join BOOK
on EDITORIAL.idE = BOOK.idE ;

SELECT EDITORIAL.idE, BOOK.idE
from EDITORIAL inner join BOOK
using (idE);

-- 6. inner join between city and book. Deliver 2 ways of doing the same							
-- No se pot fer perque no tenen elements comuns.

-- 7. What's the difference between cartesian product and inner join?							
-- La diferencia es que el producte cartesià només mos treu el producte cartesià, en canvi,
--  l' inner join mos fa una combinació del producte cartesià amb una selecció.

-- 8. Show the editorial name and the city name where that editorial is Addison							
SELECT nameE, nameCity
from EDITORIAL  inner join CITY on cityE = idCity
where nameE like "Addison";

SELECT nameE, nameCity
from EDITORIAL, CITY where nameE like "Addison";

-- 9.Same than previous point but only for small cities							
select nameE, nameCity from editorial inner join city on cityE = idCity where sizeCity like 'small';

-- 10. How many diferent cities there are editorials in? Show the editorial name and the city name							
select count(distinct idE) as result, nameCity, nameE from CITY 
inner join editorial on cityE = idCity group by idCity ; 

-- 11. How many books of the Addison editorial are? Show result of your functions with the columns name of result and the editorial name 							
SELECT count(idB) as result, nameE
from EDITORIAL  inner join BOOK 
using (idE) where nameE = 'Addison' group by idE;

-- 12. How many books in English language and with more than 100 pages are? Show result of your functions with the columns name of result, the language and the editorial name							
SELECT count(idB) as result, languageB, nameE
from EDITORIAL inner join BOOK using (idE) 
where languageB = 'E' and numPagsB > 100;

-- 13. How many books of each editorial are? Show result of your functions with the columns name of result and the editorial name 							
SELECT count(idB) as result, nameE from EDITORIAL 
inner join BOOK using (idE) group by idE;

-- 14. How many books of each language are? Show result of your functions with the columns name of result, the language and the editorial name							
SELECT count(idB) as result, languageB, nameE
from EDITORIAL inner join BOOK
using (idE) group by languageB, idE;

-- 15. How many books of each language are with more than 100 pages? Show result of your functions with the columns name of result, the language and the editorial name							
SELECT count(idB) as result, languageB, nameE
from EDITORIAL inner join BOOK
using (idE) where numPagsB > 100 group by languageB, idE;

-- 16. How big is the average of the number of pages? Show result of your functions with the columns name of result							
SELECT avg(numPagsB) as result from BOOK;

-- 17. How big is the average of the number of pages by editorial? Show result of your functions with the columns name of result and the editorial name							
SELECT avg(numPagsB) as result, nameE
from EDITORIAL inner join BOOK using (idE) 
group by idE;

-- 18. How big is the average of the number of pages by editorial but only for books with more than 100 pages? Show result of your functions with the columns name of result and the editorial name							
SELECT avg(numPagsB) as result, nameE
from EDITORIAL inner join book using (idE) 
where numPagsB > 100 group by idE;

-- 19. How big is the average of the number of pages by editorial? Show result of your functions with the columns name of result and the editorial name but only when the average is bigger than 110							
SELECT avg(numPagsB) as result, nameE
from EDITORIAL inner join BOOK using (idE) 
where (select avg(numPagsB) from BOOK) > 110 group by idE;

-- 20. How big is the average of the number of pages by editorial but only for books with more than 100 pages? Show result of your functions with the columns name of result and the editorial name but only when the average is bigger than 110							
SELECT avg(numPagsB) as result, nameE
from EDITORIAL inner join BOOK using (idE) 
where numPagsB > 100 and (select avg(numPagsB) from BOOK) > 110 group by idE;