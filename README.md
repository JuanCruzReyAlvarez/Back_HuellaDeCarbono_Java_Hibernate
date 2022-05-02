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

## Instalar NodeJS, NPM y Angular cli (para la UI)

- Descargar, extraer y ejecutar el instalador

https://drive.google.com/file/d/1esN0vh7jon_OE6l6G4R65nQHSXf7aBI8/view?usp=sharing

- abrir una nueva terminal y verificar que se haya instalado 

 ```
-$ npm -v
 ```
 - El comando de arriba debe devolver el numero de version de npm

#### instalar Angular cli con npm

 ```
-$ npm install -g @angular/cli
 ```

## Configurar dominio ddstp.carbono.com

- Abrir un editor de texto en modo Adminitrador (click derecho -> ejecutar como administrador)
- Abrir el archivo hosts (ubicado en C:\Windows\System32\drivers\etc)
- Agregar el siguiente texto debajo de todo

 ```
127.0.0.1 ddstp.carbono.com
 ```
 
- guardar hosts file


## Instalar docker desktop en Windows 10 (Opcional para no instalar base de datos)

https://www.youtube.com/watch?v=_et7H0EQ8fY


## Instalacion de MySQL

- Descargar instalador del drive (pedir acceso)

https://drive.google.com/file/d/1k2HXtRa9g9cvbp8qioxMQ0ESeAGs9kS2/view?usp=sharing

- Extraer con WinRAR en donde prefiera
- Ejecutar instalador
- Al preguntar por root password ingresar 123456

## Compilar y levantar entorno

abrir terminal y posicionarse donde se encuentra este README.md (base del repo) y ejecutar:

 ```
-$ sh ./environment/build-carbono.sh
 ```
### Argumentos

- -p  ----- Build Passwords Module  
- -u  ----- Build UI Module  
- -c  ----- Build Carbono Backend  
- -t  ----- Run unit tests when building  
- -s  ----- Run Local Server Docker (default) 
- -sa ----- Run Local Server on local Apache Tomcat  
- -h  ----- Help guide  

#### ejemplo

 ```
-$ sh ./environment/build-carbono.sh -ucsa
 ```

- esto primero hace build de la UI creando todos los archivos estaticos (html, css, js)
- luego compila el codigo java de la carpeta carbono y genera el .war
- levanta el .war en el Apache Tomcat que se encuentra en la carpeta environment

### Debugging

#### vsCode

- Para debuggear en el Visual Studio Code es necesario instalar la extension de Apache Tomcat:
https://marketplace.visualstudio.com/items?itemName=adashen.vscode-tomcat

- luego dentro del widget de tomcat agregar un nuevo tomcat apuntando al directorio llamado tomcat que esta en la carpeta environment
- para debuggear hacer click derecho en el ROOT.war (creado al buildear con el build-carbono.sh -c) y poner Debbug with Tomcat

#### intelliJ

- //TODO: completar
