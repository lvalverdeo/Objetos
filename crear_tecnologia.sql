CREATE DEFINER=`root`@`localhost` PROCEDURE `crear_tecnologia`(in cod varchar(45), idProy varchar(45),in nom varchar(45))
BEGIN
	insert into tecnologias(codigo,nombre,Proyectos_idProyectos)
    values(cod,nom,idProy);
END