CREATE DEFINER=`root`@`localhost` PROCEDURE `validacion_acceso`(in email varchar(45),in clave varchar(45),out concuerda boolean)
BEGIN
	declare idUser varchar(45) default (select idUsuarios from usuarios where correo = email);
    
    declare passBueno varchar(45) default (select contrasenna from claves 
					where idUser = Usuarios_idUsuarios);
    
    if passBueno = clave then set concuerda = true;
    else set concuerda = false;
    end if;
END