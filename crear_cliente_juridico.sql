CREATE DEFINER=`root`@`localhost` PROCEDURE `crear_cliente_juridico`(in ced varchar(45),
in nom varchar(45), in aUno varchar(45),
in aDos varchar(45),in tel varchar(45),in tip varchar(45),in prov varchar(45), 
in cant varchar (45),in dist varchar(45),in empresa varchar(45),in idEmp varchar(45))
BEGIN
	declare idCliente int(11) default(0);
    call crearIDCliente(idCliente);
    insert into contactos(cedula,nombre,apellidoUno,apellidoDos,telefono)
    values(ced,nom,aUno,aDos,tel);
    insert into clientes(idClientes,tipo,provincia,canton,distrito,telefono,Contactos_cedula1)
    values(idCliente,tip,prov,cant,dist,tel,ced);
    
    set idCliente = (select idClientes from clientes where Contactos_cedula1=ced);
    
    insert into clientesjuridicos(identificacion,nombre,Clientes_idClientes)
    values(idEmp,empresa,idCliente);
END