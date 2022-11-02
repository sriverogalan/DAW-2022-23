select dni, nameCli 
from client
limit 3; -- per limitar
-- per mostrar nomes les dues primeres files seria : where idCli in (1,2);

-- per ordenar de forma ascendent la nameCli
select dni, nameCli 
from client
order by nameCli asc ; -- si vull descendent posarem desc, en vez de asc
-- per posar mes podem possar una coma i seguir posant columnes i asc o desc segons 

select distinct phoneType
from client
where phoneType is not null;

