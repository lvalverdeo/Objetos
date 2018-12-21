CREATE DEFINER=`root`@`localhost` PROCEDURE `infoClienteID`(in id int(11))
BEGIN
	select tipo,provincia,canton,distrito,telefono,Contactos_cedula1
    from clientes
    where idClientes = id;
END