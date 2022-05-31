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
    echo "-c  ----- Contracts Module  " &&
    echo "-e  ----- Excel Importer Module  " &&
    echo "-a  ----- Carbono Backend  " &&
    echo "-t  ----- Run unit testing to complete build  " &&
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

function runMavenBuild {
    if [[ $1 == *"t"* ]]; then
        mvn clean install 
    else
        mvn clean install -DskipTests
    fi
}

function buildAndDeployContractsModule {
    cd $CARBONO_PATH/modules/contracts &&
    runMavenBuild $1 &&

    if [[ ! -d $CARBONO_PATH/carbono/lib ]]; then
        mkdir $CARBONO_PATH/carbono/lib
    fi
    
    cp -f ./target/contracts-1.0-jar-with-dependencies.jar $CARBONO_PATH/carbono/lib/contracts-1.0.jar && 

    if [[ ! -d $CARBONO_PATH/modules/passwords/lib ]]; then
        mkdir $CARBONO_PATH/modules/passwords/lib
    fi
    
    cp -f ./target/contracts-1.0-jar-with-dependencies.jar $CARBONO_PATH/modules/passwords/lib/contracts-1.0.jar && 

    if [[ ! -d $CARBONO_PATH/modules/excelreader2/lib ]]; then
        mkdir $CARBONO_PATH/modules/excelreader2/lib
    fi

    cp -f ./target/contracts-1.0-jar-with-dependencies.jar $CARBONO_PATH/modules/excelreader2/lib/contracts-1.0.jar && 

    printmessage "Passwords Module Built and Deployed"
}

function buildAndDeployExcelReaderModule {
    cd $CARBONO_PATH/modules/excelreader2 &&
    runMavenBuild $1 &&

    if [[ ! -d $CARBONO_PATH/carbono/lib ]]; then
        mkdir $CARBONO_PATH/carbono/lib
    fi
    cp -f ./target/excelreader2-1.0-jar-with-dependencies.jar $CARBONO_PATH/carbono/lib/excelReader-1.0.jar && 
    printmessage "ExcelReader Module Built and Deployed"
}

function buildAndDeployPasswordsModule {
    cd $CARBONO_PATH/modules/passwords &&
    runMavenBuild $1 &&

    if [[ ! -d $CARBONO_PATH/carbono/lib ]]; then
        mkdir $CARBONO_PATH/carbono/lib
    fi
    cp -f ./target/passwords-1.0-jar-with-dependencies.jar $CARBONO_PATH/carbono/lib/passwords-1.0.jar && 
    printmessage "Passwords Module Built and Deployed"
}

function buildAndDeployCarbono {
    cd $CARBONO_PATH/carbono &&
    runMavenBuild $1 &&
    printmessage "Carbono Built and Deployed"
}


if [[ $1 == *"c"* ]]; then
    buildAndDeployContractsModule $1
fi

if [[ $1 == *"e"* ]]; then
    buildAndDeployExcelReaderModule $1
fi

if [[ $1 == *"p"* ]]; then
    buildAndDeployPasswordsModule $1
fi

if [[ $1 == *"a"* ]]; then
    buildAndDeployCarbono $1
fi

if [[ $1 == *"h"* ]]; then
    printHelp
fi

if [[ $# == 0 ]]; then
    buildAndDeployContractsModule &&
    buildAndDeployExcelReaderModule &&
    buildAndDeployPasswordsModule &&
    buildAndDeployCarbono
fi

