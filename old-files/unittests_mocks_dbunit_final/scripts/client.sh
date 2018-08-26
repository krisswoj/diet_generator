#!/bin/sh

cd $(dirname $0)



cd ..

java -cp scripts/hsqldb.jar org.hsqldb.util.DatabaseManagerSwing --url jdbc:hsqldb:hsql://localhost/workdb
