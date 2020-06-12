#!/usr/bin/env bash

problemNumber=$1

mkdir Problem${problemNumber}

cd Problem${problemNumber}

touch README.md
touch Solution.java

cd ..
git add Problem${problemNumber}