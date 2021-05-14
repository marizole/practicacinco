use bd_blogg
create table posts(
 id int(11) not null auto_increment primary key,
 fecha date,
 titulo varchar(100),
 contenido text
);
create table usuarios(
 id int(11) not null auto_increment primary key,
 usuario varchar(20),
 password varchar (255)
);

select * from posts;
select * from usuarios;

insert into posts (fecha,titulo,contenido) 
		values ("10/05/20","Modelo computacinal que puso al mundo en cuarentena",
				"Autoedicion y editores  de paginas web usan el Lorem Ipsum como su 
				texto  por defecto , y al hacer una busqueda de Lorem Ipsum va a
				 dar por resultado  muchos sitios  web que usan este texto  si se 
				encuentra  en estado de desarrollo");
insert into usuarios (usuario,password) values ("admin","admin");
			
			
			
insert into posts (fecha,titulo,contenido) values ("17/09/19","¿Tesoro mesoamericano o falsificacion? Los enigmas del penacho de Cuauhtemoc","Expertos franceses y mexicanos investigan la pieza, que esta en Paris, para determinar su origen y funcion, aunque ya tienen algunas pistas: no es un tocado y nada apunta a que haya pertenecido al ultimo emperador mexica");




DELETE FROM bd_blogg.posts WHERE id=4;