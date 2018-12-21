CREATE DEFINER=`root`@`localhost` PROCEDURE `traer_cantones`(in prov varchar(20))
BEGIN
	declare idProvincia int(2) default(select id from provincias where prov=provincia);
    select canton from cantones where idProvincia = Provincias_id;
END