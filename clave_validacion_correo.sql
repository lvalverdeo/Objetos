CREATE DEFINER=`root`@`localhost` PROCEDURE `clave_validacion_correo`(in email varchar(45),out existe boolean)
BEGIN
	declare emailValidado varchar(45) default (select idUsuarios from usuarios where email=correo);
    if emailValidado=0 then set existe=false;
    else set existe=true;
    end if;
END