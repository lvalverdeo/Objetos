CREATE DEFINER=`root`@`localhost` PROCEDURE `infoContactoCed`(in ced varchar(45))
BEGIN
	select nombre,apellidosUno,apellidoDos,telefono 
    from contactos 
    where cedula = ced;
END