#!/bin/sh
target=$1
artefactLocation="rs/target"
artefactName="ll7ma-rs.war"

case $target in
    cc)
    mvn clean cobertura:cobertura site -P dev -e
    ;;

    dev-test)
    mvn clean test -P dev -e
    echo "Deploy..."
    cp $artefactLocation/$artefactName $CATALINA_BASE/webapps
    ;;

    dev-deploy-local)
    mvn clean package site -P dev -e
    echo "Deploy..."
    cp $artefactLocation/$artefactName $CATALINA_BASE/webapps
    ;;

esac


echo "Done."
