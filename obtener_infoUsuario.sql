CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_infoUsuario`(in email varchar(45),out ced varchar(45),
out nom varchar(45),out aUno varchar(45),out aDos varchar(45),out gen varchar(1),
out clave varchar(45))
BEGIN
	declare id int(11) default(select idUsuarios from usuarios where email=correo);
	set ced = (select cedula from usuarios where email=correo);
    set nom = (select nombre from usuarios where email=correo);
    set aUno = (select apellidoUno from usuarios where email=correo);
    set aDos = (select apellidoDos from usuarios where email=correo);
    set gen = (select genero from usuarios where email=correo);
    set clave = (select contrasenna from claves where id=Usuarios_idUsuarios);
    
END