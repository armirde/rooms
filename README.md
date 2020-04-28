# Desarrollo del backend con Spring y acceso a datos con Hibernate
### Cátedra Capgemini – Universitat de València - Master TWCAM 
#### Ponente: Armen Mirzoyan Denisov

<br/><br/>

## Índice
* [1. Introducción](https://github.com/armirde/rooms/blob/master/README.md#1-introducci%C3%B3n)<br/>
  * [1.1 Preparación de los entornos](https://github.com/armirde/rooms/blob/master/README.md#11-preparaci%C3%B3n-de-los-entornos)<br/>
  * [1.2 Sinopsis de la Aplicación Web](https://github.com/armirde/rooms/blob/master/README.md#12-sinopsis-de-la-aplicaci%C3%B3n-web)<br/>
  * [1.3 Objetivos](https://github.com/armirde/rooms/blob/master/README.md#13-objetivos)<br/><br/>
* [2. Presentación de la aplicación](https://github.com/armirde/rooms/blob/master/README.md#2-presentaci%C3%B3n-de-la-aplicaci%C3%B3n)<br/>
  * [2.1 Contratos desde frontend a backend](https://github.com/armirde/rooms/blob/master/README.md#21-Contratos-desde-frontend-a-backend)<br/>
    * [2.1.1 Listado de salas](https://github.com/armirde/rooms/blob/master/README.md#211-listado-de-salas)<br/>
    * [2.1.2 Listado de usuarios](https://github.com/armirde/rooms/blob/master/README.md#212-listado-de-usuarios)<br/>
    * [2.1.3 Reservar sala](https://github.com/armirde/rooms/blob/master/README.md#213-reservar-sala)<br/>
    * [2.1.4 Liberar sala](https://github.com/armirde/rooms/blob/master/README.md#214-liberar-sala)<br/><br/>
* [3. Desarrollo](https://github.com/armirde/rooms/blob/master/README.md#3-desarrollo)<br/>
  * [3.1 PASO 1: Modelo de datos](https://github.com/armirde/rooms/blob/master/README.md#31-paso-1-modelo-de-datos)<br/>
  * [3.2 PASO 2: Creación del proyecto](https://github.com/armirde/rooms/blob/master/README.md#32-paso-2-creaci%C3%B3n-del-proyecto)<br/>
    * [3.2.1 Dependencias](https://github.com/armirde/rooms/blob/master/README.md#321-dependencias)<br/>
  * [3.3 PASO 3: Construcción del backend](https://github.com/armirde/rooms/blob/master/README.md#33-paso-3-construcci%C3%B3n-del-backend)<br/>
    * [3.3.1 Funcionalidad básica](https://github.com/armirde/rooms/blob/master/README.md#331-funcionalidad-b%C3%A1sica)<br/>
      * [3.3.1.1 Salas](https://github.com/armirde/rooms/blob/master/README.md#3311-salas)<br/>
        * [3.3.1.1.1 Capa de acceso a datos](https://github.com/armirde/rooms/blob/master/README.md#33111-capa-de-acceso-a-datos)<br/>
        * [3.3.1.1.2 Capa lógica de negocio](https://github.com/armirde/rooms/blob/master/README.md#33112-capa-l%C3%B3gica-de-negocio)<br/>
        * [3.3.1.1.3 Capa de API](https://github.com/armirde/rooms/blob/master/README.md#33113-capa-de-api)<br/>
      * [3.3.1.2 Usuarios](https://github.com/armirde/rooms/blob/master/README.md#3312-usuarios)<br/>
    * [3.3.2 Funcionalidad avanzada](https://github.com/armirde/rooms/blob/master/README.md#332-funcionalidad-avanzada)<br/>
      * [3.3.2.1 Relacionar entidades](https://github.com/armirde/rooms/blob/master/README.md#3321-relacionar-entidades)<br/>
      * [3.3.2.2 Reservar sala](https://github.com/armirde/rooms/blob/master/README.md#3322-reservar-sala)<br/>
      * [3.3.2.3 Liberar sala](https://github.com/armirde/rooms/blob/master/README.md#3323-liberar-sala)<br/><br/>
* [4. Documentación adicional](https://github.com/armirde/rooms/blob/master/README.md#4-documentaci%C3%B3n-adicional)<br/>
<br/><br/>

## 1. Introducción

Se propone una aplicación, basada en el siguiente software de carácter tecnológico:
*	Spring Boot (v2.2.6)
*	Spring Data (v2.2.6)
*	JDK (v1.8)
*	Maven (v3.5.4)
<br/>
Como soporte a dicha tecnología, se hace uso del servidor de aplicaciones embebido en Spring Boot, un IDE de desarrollo STS (v4.6.0) y una BBDD embebida (H2), que permite la publicación de contenidos, el desarrollo y el almacenamiento de la información respectivamente.

Para el presente proyecto se dispone de un repositorio GitHub (https://github.com/armirde/rooms) donde encontrar:
*	El proyecto completo tras realizar todos los pasos.
* Un comprimido con algunas de las aplicaciones necesarias para el desarrollo (JDK, Maven).
<br/>
La estructura del código está orientada a un modelo de Servicios, haciendo que sea posible el aislamiento y modularización de cada parte del desarrollo. Asimismo, se emplea una arquitectura MVC (Modelo-Vista-Controlador) bien diferenciada y permitiendo la centralización en negocio y en arquitectura, pero no en vista.

Se pretende seguir una metodología de desarrollo ordenada y coherente con la programación incremental. Para ello, se presentarán etapas, donde sobre cada una, se establecerá un hito bien definido (Model, Repository, Service y Controller). La conjunción de hitos conllevará la consecución de la práctica.

<br/>

### 1.1 Preparación de los entornos

Los pasos a seguir para la correcta preparación de los entornos son:
*	Descarga del RAR con el JDK y Maven: https://github.com/armirde/rooms/tree/master/resources
*	Descarga del IDE STS(4.6.1): https://spring.io/tools
*	Instalación de Postman(7.22): https://www.postman.com/downloads/
*	Crear directorios "C:\dev\" y dentro "C:\dev\workspace"
* Descomprimir el JDK, Maven y el IDE en "C:\dev\"
*	Añadir las variables de entorno del JDK y Maven en el SO (W10: Configuración avanzada del sistema):
```
Crear variable de entorno: "JAVA_HOME=C:\dev\jdk1.8.0_172"
Añadir a "path": "%JAVA_HOME%\bin"

Crear variable de entorno: "M2_HOME=C:\dev\apache-maven-3.5.4"
Añadir a "path": "%M2_HOME%\bin"
```
* Editar el fichero de arranque del IDE (C:\dev\sts-4.6.1.RELEASE\SpringToolSuite4.ini) añadiendo:
```
...
openFile
-vm
C:\dev\jdk1.8.0_172\bin\javaw.exe
...
```
* Abrir el IDE (seleccionando como ruta de workspace --> "C:\dev\workspace") y comprobar que arranca correctamente

<br/>

### 1.2 Sinopsis de la Aplicación Web

Se presenta una aplicación para la gestión de salas de reunión de una oficina. En ella, se puede encontrar estas opciones:
* __Listado de salas:__ Donde se presentará el listado de salas y su estado.
* __Listado de usuarios:__ Donde se presentará el listado de usuarios.
* __Reservar sala:__ Donde se permite realizar la reserva de una sala para un usuario.
* __Liberar sala:__ Donde se permite realizar liberación de una sala para un usuario.

<br/>

### 1.3 Objetivos

Lograr elaborar parte del Backend, similar al empleado en un modelo corporativo y empresarial, generando para ello las capas de negocio necesarias, gestionando Spring e Hibernate de manera cohesionada y haciendo uso de los contratos de E/S propuestos.

Gracias al seguimiento paso a paso de la práctica, el alumnado debe ser capaz de reconocer el flujo básico de la información en una metodología orientada a Servicios, así como las directivas necesarias para la consecución de un desarrollo MVC completo.

<br/><br/>

## 2. Presentación de la aplicación

Tal como se ha detallado anteriormente, vamos a completar una herramienta para la gestión de salas de reunión. Hoy en día, casi todas las aplicaciones web poseen parte móvil y parte web, pero en este caso, únicamente nos centraremos en el backend, puesto que seguiremos el concepto de centralización de negocio (backend único, sea cual sea el número de fronts).

### 2.1 Contratos desde frontend a backend

#### 2.1.1 Listado de salas
<table>
	<tr>
  		<th>OPERACIÓN REST</th>
		<td>GET</b></td>
	</tr>
	<tr>
  		<th>URL PÚBLICA AL SERVICIO</th>
		<td>localhost:8080/<b>room/findAll</b></td>
	</tr>
	<tr>
  		<th>PARÁMETRO DE ENTRADA</th>
		<td>
		</td>
	</tr>
	<tr>
  		<th>PARÁMETRO DE SALIDA</th>
		<td>
			<i>[ {<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"id": 1,<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"name": "Room 1",<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"user": {<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": 1,<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "John",<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"surname": "Doe"<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;}<br/>
			} ]</i>
		</td>
	</tr>
</table>

<br/>

#### 2.1.2 Listado de usuarios
<table>
	<tr>
  		<th>OPERACIÓN REST</th>
		<td>GET</b></td>
	</tr>
	<tr>
  		<th>URL PÚBLICA AL SERVICIO</th>
		<td>localhost:8080/<b>user/findAll</b></td>
	</tr>
	<tr>
  		<th>PARÁMETRO DE ENTRADA</th>
		<td>
		</td>
	</tr>
	<tr>
  		<th>PARÁMETRO DE SALIDA</th>
		<td>
			<i>[ {<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"id": 1,<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"name": "John",<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"surname": "Doe"<br/>
			} ]</i>
		</td>
	</tr>
</table>

<br/>

#### 2.1.3 Reservar sala
<table>
	<tr>
  		<th>OPERACIÓN REST</th>
		<td>POST</b></td>
	</tr>
	<tr>
  		<th>URL PÚBLICA AL SERVICIO</th>
		<td>localhost:8080/<b>room/book/</b></td>
	</tr>
	<tr>
  		<th>PARÁMETRO DE ENTRADA</th>
		<td>
			<b><i>{<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"room": {<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": Long<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;},<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"user": {<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": Long<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;}<br/>
			}</i></b>
			<br/>Ejemplo:<br/>
			<i>{<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"room": {<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": 3<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;},<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"user": {<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": 1<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;}<br/>
			}</i>
		</td>
	</tr>
	<tr>
  		<th>PARÁMETRO DE SALIDA</th>
		<td>
			<i>[ {<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"id": 3,<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"name": "Room 3",<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"user": {<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": 1,<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "John",<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"surname": "Doe"<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;}<br/>
			} ]</i>
		</td>
	</tr>
</table>

<br/>

#### 2.1.4 Liberar sala
<table>
	<tr>
  		<th>OPERACIÓN REST</th>
		<td>GET</b></td>
	</tr>
	<tr>
  		<th>URL PÚBLICA AL SERVICIO</th>
		<td>localhost:8083/<b>room/free/{id}</b></td>
	</tr>
	<tr>
  		<th>PARÁMETRO DE ENTRADA</th>
		<td>
			<b>id: Long</b><br/>
			Ejemplo: <i>.../room/free/3</i>
		</td>
	</tr>
	<tr>
  		<th>PARÁMETRO DE SALIDA</th>
		<td>
			<i>[ {<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"id": 3,<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"name": "Room 3",<br/>
			    &nbsp;&nbsp;&nbsp;&nbsp;"user": null<br/>
			} ]</i>
		</td>
	</tr>
</table>

<br/>

<br/><br/>

## 3. Desarrollo

<br/>

### 3.1 PASO 1: Modelo de datos

Se parte de un modelo de datos propuesto, es posible visualizar la definición completa de las tablas existentes sobre los siguientes cuadros:

<table>
	<tr>
  <th><b>ROOM</b></th>
		<th colspan="2"><i>Esta entidad representa una sala de reunión.</i></th>
	</tr>
	<tr><th>NOMBRE</th><th>TIPO</th></tr>
	<tr><td>ID (PK)</td><td>BIGINT(16)</td></tr>
	<tr><td>NAME</td><td>VARCHAR(255)</td></tr>
	<tr><td>USER (FK)</td><td>BIGINT(16)</td></tr>
</table>
<br/>
<table>
	<tr>
  <th><b>USER</b></th>
		<th colspan="2"><i>Esta entidad representa un usuario.</i></th>
	</tr>
	<tr><th>NOMBRE</th><th>TIPO</th></tr>
	<tr><td>ID (PK)</td><td>BIGINT(16)</td></tr>
	<tr><td>NAME</td><td>VARCHAR(255)</td></tr>
  	<tr><td>SURNAME</td><td>VARCHAR(255)</td></tr>
</table>

<br/>

### 3.2 PASO 2: Creación del proyecto

Se crea una aplicacción mediante "Spring Starter Project" cambiando unicamente los siguentes parámetros:
* Name : rooms
* Group : com.uv
* Artifact : rooms
* Package : com.uv.rooms

Creado el proyecto, se comprueba que funciona correctamente seleccionando el fichero "bootable" RoomsApplication.java y lanzándolo mediante "Run as Spring Boot App".

<br/>

#### 3.2.1 Dependencias

Comprobado que el proyecto se ha creado correctamente, se procede añadir las dependencias Maven necesarias para el funcionamiento (pom.xml):
* Se incluye la implementación de JPA de Spring, por defecto está basada en la implementación de JPA de Hibernate:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
* Añadir la dependencia para poder publicar servicios REST:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
```
* Se añade la dependencia de la BBDD embebida para almacenar los datos del aplicativo:
```
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```
* Se debe de incluir la configuracion necesaria de la BBDD en el fichero de propiedades de la aplicación (application.properties):
```
spring.h2.console.enabled=true
```
* Para validar que se ha inicializado correctamente, se puede acceder a la BBDD mediante: http://localhost:8080/h2-console/ cambiando el siguiente parámetro:
```
URL: jdbc:h2:mem:testdb
```
<br/>

### 3.3 PASO 3: Construcción del backend

#### 3.3.1 Funcionalidad básica

##### 3.3.1.1 Salas

###### 3.3.1.1.1 Capa de acceso a datos
* Creación de la entidad:
```
package com.uv.rooms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {
	
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    //getter y setters

}
```
* En este punto ya se puede crear el script de carga incial de datos en el directorio de recursos del proyecto (source.main.resources), denominado "data.sql":
```
insert into room values(1, 'Room 1');
insert into room values(2, 'Room 2');
insert into room values(3, 'Room 3');
```
* Arrancando de nuevo el proyecto se puede comprobar que los datos aparecen en la consola de H2.
* Creación del JpaRepsotory:
```
package com.uv.rooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uv.rooms.model.Room;

@Repository
public interface RoomJpaRepository extends JpaRepository<Room, Long> {
}
```

<br/>

###### 3.3.1.1.2 Capa lógica de negocio
* Creación de la interface service:
```
package com.uv.rooms.service;

import java.util.List;

import com.uv.rooms.model.Room;

public interface RoomService {
	
	List<Room> findAll();
}
```
* Creación de su implementación:
```
package com.uv.rooms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uv.rooms.model.Room;
import com.uv.rooms.repository.RoomJpaRepository;
import com.uv.rooms.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomJpaRepository repository;

	@Override
	public List<Room> findAll() {
		return repository.findAll();
	}

}
```
* Creación de test para comprobar el funcionamiento:
```
package com.uv.rooms;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uv.rooms.model.Room;
import com.uv.rooms.service.RoomService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceUnitTest {
	
	@Autowired
	RoomService service;
	
	@Test
	public void findAll() {
		List<Room> rooms = service.findAll();
 
		Assert.assertEquals(rooms.size(), 3);
	}

}
```
* Ejecutar el test para comprobar que el servicio funciona correctamente:
```
Run as "JUnit Test" (JUnit 4)
```

<br/>

###### 3.3.1.1.3 Capa de API
* Crear el controller correspondiente:
```
package com.uv.rooms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
	
	@GetMapping("/health")
	String health() {
		return "OK";
	}

}
```
* Comprobar funcionamiento mediante el navegador:
```
localhost:8080/health
```
* Creamos el DTO y el Mapper necesarios:
```
package com.uv.rooms.dto;

public class RoomDto {
	
    private Long id;
    
    private String name;

    //getter y setters

}
```
```
package com.uv.rooms.mapper;

import java.util.ArrayList;
import java.util.List;

import com.uv.rooms.dto.RoomDto;
import com.uv.rooms.model.Room;

public class RoomMapper {
	
	public static RoomDto fromEntity(Room entity) {
		
		if ( entity == null) {
			return null;
		}
		
		RoomDto dto = new RoomDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		
		return dto;
	}
	
	public static List<RoomDto> fromEntityList(List<Room> entities) {
		
		if ( entities == null) {
			return null;
		}
		
		List<RoomDto> list = new ArrayList<RoomDto>(entities.size());
		for(Room entity :entities) {
			list.add(fromEntity(entity));
		}
		
		return list;
	}

}
```
* Añadimos la llamada en el controller:
```
package com.uv.rooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uv.rooms.dto.RoomDto;
import com.uv.rooms.mapper.RoomMapper;
import com.uv.rooms.service.RoomService;

@RestController
@RequestMapping(value = "room")
public class RoomController {
	
	@Autowired
	RoomService service;
	
	@GetMapping("/findAll")
	List<RoomDto> findAll() {
		return RoomMapper.fromEntityList(service.findAll());
	}

}
```
* Comprobamos el funcionamiento mediante Postman:
```
GET: localhost:8080/room/findAll
```
<br/>

##### 3.3.1.2 Usuarios
* Creación de la misma estructura que en el caso de salas para la entidad User:
```
package com.uv.rooms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private String surname;

    //getters y setters
}
```
<br/>

#### 3.3.2 Funcionalidad avanzada
##### 3.3.2.1 Relacionar entidades
* Relacionar una Sala con un Usuario a nivel de entidad, añadiendo a la entidad "Room" la relación:
```
...
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;
...
    //getter y setter
...
```
* Actualizar el script de carga de datos con la relación:
```
insert into user values(1, 'John', 'Doe');
insert into user values(2, 'Jane', 'Doe');

insert into room values(1, 'Room 1', 1);
insert into room values(2, 'Room 2', 2);
insert into room values(3, 'Room 3', null);
```
* Actualizar el DTO y el Mapper de la entidad "Room" para añadir la relación y su mapeo:
```
...
    private UserDto user;
...
    //getter y setter
...
```
```
...
    dto.setUser(UserMapper.fromEntity(entity.getUser()));
...
```
* Comprobar con Postman que al obtener las salas, estas tienen la relación con el usuario que las ha reservado:
```
GET: localhost:8080/room/findAll
```
<br/>

##### 3.3.2.2 Reservar sala
* Crear el método de obtención de usuario en el servicio correspondiente (interfaz e implementación):
```
...
	User findById(Long idUser);
...
```
```
...
    	@Override
	public User findById(Long idUser) {
		Optional<User> optional = repository.findById(idUser);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
...
```
* Crear el método de reserva de sala en el servicio correspondiente (interfaz e implementación):
```
...
	Room book(Long idRoom, Long idUser);
...
```
```
...
	@Autowired
	UserService userService;
...
	@Override
	public Room book(Long idRoom, Long idUser) {
		Optional<Room> optional = repository.findById(idRoom);
		
		if(optional.isPresent()) {
			Room room = optional.get();
			User user = userService.findById(idUser);
			if(room.getUser() == null && user != null) {
				room.setUser(user);
				repository.save(room);
				return room;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
...
```
* Crear el DTO que hara de objeto de petición:
```
package com.uv.rooms.dto;

public class BookDto {
	
	private RoomDto room;
	
	private UserDto user;

	public RoomDto getRoom() {
		return room;
	}

	public void setRoom(RoomDto room) {
		this.room = room;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
}
```
* Publicar el API para acceder al servicio:
```
...
	@PostMapping("/book")
	RoomDto book(@RequestBody BookDto dto) {
		return RoomMapper.fromEntity(service.book(dto.getRoom().getId(), dto.getUser().getId()));
	}
...
```
* Realizar petición mediante Postman al nuevo servicio de reservas:
```
POST: localhost:8080/room/book/
```
```
{
	"room":{
		"id":3	
	},
	"user":{
		"id":1
	}
}
```
<br/>

##### 3.3.2.3 Liberar sala
* Crear el método de liberación de sala en el servicio correspondiente (interfaz e implementación):
```
...
	Room free(Long idRoom);
...
```
```
...
	@Override
	public Room free(Long idRoom) {
		Optional<Room> optional = repository.findById(idRoom);
		
		if(optional.isPresent()) {
			Room room = optional.get();
			room.setUser(null);
			repository.save(room);
			return room;
		} else {
			return null;
		}
	}
...
```
* Publicar el API para acceder al servicio:
```
...
	@GetMapping("/free/{id}")
	RoomDto free(@PathVariable Long id) {
		return RoomMapper.fromEntity(service.free(id));
	}
...
```
* Realizar petición mediante Postman al nuevo servicio de liberación:
```
GET: localhost:8080/room/free/3
```
<br/>

## 4. Documentación adicional

* Spring Boot: https://spring.io/projects/spring-boot

* Spring Data: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
