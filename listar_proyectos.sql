CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_proyectos`()
BEGIN
	select idProyectos from proyectos;
END