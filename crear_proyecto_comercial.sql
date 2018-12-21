CREATE DEFINER=`root`@`localhost` PROCEDURE `crear_proyecto_comercial`(
in id varchar(45),in nom varchar(45),in descr varchar(65),
in fechaIn date, in fechaF date,in tip varchar(45),in email varchar(45),
in idClient int)
BEGIN
	declare idUsuario int(11) default(select idUsuarios from usuarios where email=correo);
    
    insert into proyectos (idProyectos,nombre,descripcion,fechaInicio,fechaFin,tipo,Usuarios_idUsuarios)
    values(id,nom,descr,fechaIn,fechaF,tip,idUsuario,idClient);
END