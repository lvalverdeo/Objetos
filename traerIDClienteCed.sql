CREATE DEFINER=`root`@`localhost` PROCEDURE `traerIDClienteCed`(in ced varchar(45),out id int(11))
BEGIN
	set id = (select idClientes from clientes where Contactos_cedula1 = ced);
END