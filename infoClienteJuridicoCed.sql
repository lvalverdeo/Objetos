CREATE DEFINER=`root`@`localhost` PROCEDURE `infoClienteJuridicoCed`(
in ced varchar(45))
BEGIN
	declare idClient int(11) default(select idClientes from clientes 
		where Contactos_cedula1=ced);
    select identificacion,nombre 
    from clientesjuridicos 
    where idClient = Clientes_idClientes;
END