#!/bin/sh
target=$1
artefactLocation="rs/target"
artefactName="ll7ma-rs.war"

case $target in
    dev)
    mvn clean package site -P dev -e
    ;;
esac

echo "Deploy..."

cp $artefactLocation/$artefactName $CATALINA_BASE/webapps

echo "Done."
