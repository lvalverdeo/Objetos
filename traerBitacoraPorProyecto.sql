CREATE DEFINER=`root`@`localhost` PROCEDURE `traerBitacoraPorProyecto`(in idProy varchar(45))
BEGIN
	declare idBit int(11) default
	(select idBitacora from bitacoras where Proyectos_idProyectos=idProy);
    select fechaInicio,horaInicio,nombre,descripcion 
    from actividades where Bitacoras_idBitacoras=idBit;
END