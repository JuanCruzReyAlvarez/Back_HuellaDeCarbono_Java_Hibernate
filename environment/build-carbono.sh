#!bin/bash

function printerror {
    echo " " &&
    echo " " &&
    echo "-------------------------------------------" &&
    echo "[ERROR] $1" &&
    echo "-------------------------------------------" &&
    echo " " &&
    echo " "
}

function printHelp {
    echo "This is the DDS Carbono TP 2022 Group 7 Build, Deploy and Run In development mode Helper!" &&
    echo " " &&
    echo "-p  ----- Passwords Module  " &&
    echo "-u  ----- UI Module  " &&
    echo "-c  ----- Carbono Backend  " &&
    echo "-t  ----- Run unit testing to complete build  " &&
    echo "-s  ----- Run Local Server Docker by default " &&
    echo "-sa ----- Run Local Server on local Apache Tomcat  " &&
    echo "-h  ----- This help guide  " &&
    echo "-------------------------------------------" &&
    echo "if no parameters are passed the helper will run it all" &&
    echo "-------------------------------------------" &&
    echo "[EXAMPLE] sh build-carbono -pct" &&
    echo "-------------------------------------------"
}

function printmessage {
    echo " " &&
    echo " " &&
    echo "-------------------------------------------" &&
    echo "[BUILD] $1" &&
    echo "-------------------------------------------" &&
    echo " " &&
    echo " "
}

function startServerProcess {
    cd $CARBONO_PATH/environment &&
   
    if [[ $1 == *"a"* ]]; then
      if [[ -f $(pwd)"/tomcat/webapps/ROOT.war" ]]; then
        export CATALINA_HOME=$(pwd)"/tomcat" &&
        echo ${CATALINA_HOME} &&
        export DATABASE_HOST="localhost" &&
        ./tomcat/bin/startup.bat
      else
        printerror "there is no WAR file. Please run the build helper with -c flag at least one time"
      fi
    else
      docker-compose down && docker-compose up
    fi
}

function runMavenBuild {
    if [[ $1 == *"t"* ]]; then
        mvn clean install 
    else
        mvn clean install -DskipTests
    fi
}

function buildAndDeployUI {
    cd $CARBONO_PATH && 
    cd modules/ui && 
    if [[ -d $(pwd)"/node_modules" ]]; then
      echo "node moldules exists"
    else
      npm install &&
      echo "node modules installed"
    fi
    npm run build &&
    cp -Rf ./dist $CARBONO_PATH/carbono/src/main/resources/static &&
    printmessage "Built and Deployed"
}

function buildAndDeployPasswordsModule {
    cd $CARBONO_PATH/modules/passwords &&
    runMavenBuild $1 &&
    cp -f ./target/passwords-0.1-jar-with-dependencies.jar $CARBONO_PATH/carbono/lib/passwords-0.1.jar && 
    printmessage "Passwords Module Built and Deployed"
}

function buildAndDeployCarbono {
    cd $CARBONO_PATH/carbono &&
    runMavenBuild $1 &&
    cp -f ./target/carbono-0.1.war $CARBONO_PATH/environment/stable.war && 
    cp -f ./target/carbono-0.1.war $CARBONO_PATH/environment/tomcat/webapps/ROOT.war && 
    cp -f ./target/carbono-0.1.war ./target/ROOT.war && 
    printmessage "Carbono Built and Deployed"
}

if [[ $1 == *"p"* ]]; then
  buildAndDeployPasswordsModule $1
fi

if [[ $1 == *"u"* ]]; then
  buildAndDeployUI $1
fi

if [[ $1 == *"c"* ]]; then
  buildAndDeployCarbono $1
fi

if [[ $1 == *"s"* ]]; then
  startServerProcess $1
fi

if [[ $1 == *"h"* ]]; then
  printHelp
fi

if [[ $# == 0 ]]; then
    buildAndDeployPasswordsModule &&
    buildAndDeployUI &&
    buildAndDeployCarbono &&
    startServerProcess
fi

