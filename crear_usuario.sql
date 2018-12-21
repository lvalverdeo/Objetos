CREATE DEFINER=`root`@`localhost` PROCEDURE `crear_usuario`(in ced varchar(45), in nom varchar(45),
in apellUno varchar(45),in apellDos varchar(45), in correo varchar(45), in gen char)
BEGIN
	insert into usuario(cedula,nombre,apellidoUno,apellidoDos,correo,genero)
    values(ced,nom,apellUno,apellDos,correo,gen);
END