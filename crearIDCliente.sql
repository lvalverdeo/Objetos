CREATE DEFINER=`root`@`localhost` PROCEDURE `crearIDCliente`(out id int)
BEGIN
	declare tmpID int 
		default(select coalesce((select idClientes from clientes order by idClientes desc limit 1),0));
	set id = 0;
	
    if tmpID = id then set id = 1;
    elseif tmpID>0 then set id = tmpID+1;
	end if;
END