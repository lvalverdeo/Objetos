CREATE DEFINER=`root`@`localhost` PROCEDURE `traer_distritos`(in cant varchar(50))
BEGIN
	declare idCanton int(3) default (select id from cantones where cant=canton);
    select distrito from distritos where idCanton = Cantones_id;
END