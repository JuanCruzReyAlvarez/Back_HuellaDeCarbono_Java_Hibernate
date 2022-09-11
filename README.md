## Instalar JRE

- Descargarse el JRE desde el drive (pedir acceso)

https://drive.google.com/file/d/19n6kdPV6DA4IYDUfMBO2H5gJuSnwWOJu/view?usp=sharing

- Extraer con WinRAR en C:\Program Files\Java
- Inicio > Settings
- Buscar "editar variables de entorno"
- Se tiene que abrir una ventanita "System Properties" > click en boton "Environment Variables..."

- Agregar Variable de entorno llamada JAVA_HOME en SYSTEM (abajo)

![Alt text](https://i.gyazo.com/2f21c66bb352547ab6f8bbf125c0c96c.png "Agregar JAVA_HOME")

- Agregar row en la variable de entorno Path cuyo valor sea %JAVA_HOME%\bin


![Alt text](https://i.gyazo.com/bf11f067a4ca25b3d046561aaa91c60b.png "Editar Path")


### Maven

- Descargar y extraer en C:\Program Files\Java

https://drive.google.com/file/d/1WISFuwqOivZ37lYdTgXs3MgXDTo37JtK/view?usp=sharing

- Agregar Variable de entorno llamada MAVEN_HOME en SYSTEM (abajo)

![Alt text](https://i.gyazo.com/ec762d5789045011c7bcedd82cfdf304.png "Agregar MAVEN_HOME")

- Agregar row en la variable de entorno Path cuyo valor sea %MAVEN_HOME%\bin

![Alt text](https://i.gyazo.com/23592b2d39801120125e38fa4f42f9a8.png "Editar Path")


## Variables de Entorno para nuestro proyecto

- Agregar Variable de entorno llamada DATABASE_HOST con el valor localhost en variables de usuario (arriba)

![Alt text](https://i.gyazo.com/ce69ab7fd44277ff75c29faad99a632d.png "Database env var")

- Agregar Variable de entorno llamada CARBONO_PATH cuyo valor es la direccion del repositorio clonado

![Alt text](https://i.gyazo.com/f518cf7193368ac2c4c650aaa884f66a.png "Carbono Path")


## Instalacion de MySQL

- Descargar instalador del drive (pedir acceso)

https://drive.google.com/file/d/1k2HXtRa9g9cvbp8qioxMQ0ESeAGs9kS2/view?usp=sharing

- Extraer con WinRAR en donde prefiera
- Ejecutar instalador
- Al preguntar por root password ingresar 123456

## Compilar y levantar entorno

abrir terminal y posicionarse donde se encuentra este README.md (base del repo) y ejecutar:

 ```
-$ sh ./build.sh
 ```
### Argumentos

- -p  ----- Build Passwords Module  
- -e  ----- Build Excel Importer Module  
- -a  ----- Build Carbono Backend  
- -t  ----- Run unit tests when building  
- -h  ----- Help guide  

#### ejemplo

 ```
-$ sh ./environment/build.sh -pa
 ```

- esto primero hace build del modulo de passwords
- luego compila el codigo java de la carpeta carbono
