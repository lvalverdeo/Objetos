CREATE DEFINER=`root`@`localhost` PROCEDURE `listarClientes`()
BEGIN
	select 
concat('ID - ',idClientes,' - ', clientes.tipo,' ',contactos.cedula,' ',
contactos.nombre,' ',
contactos.apellidoUno,' ',
contactos.apellidoDos) as cliente
from (clientes
inner join contactos on clientes.Contactos_cedula1=contactos.cedula
);
    
END