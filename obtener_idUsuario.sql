CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_idUsuario`(in email varchar(45),out idUser int)
BEGIN
	set idUser = (select idUsuarios from usuarios
    where correo = email);
    
END