#!/bin/sh

rm *.cc
rm *.h

for i in `cat list`; 
    do echo "#include \"nonPolice$i.h\" \n int add(int x, int y)\n{return x + y;}\n " >  nonPolice$i.cc; echo "int add(int x, int y);" > nonPolice$i.h; 
done

cc *.cc

echo  "\n int main()\n{ return 0;\n}" > nonPoliceMain.cc
cc -o nonPoliceMain nonPoliceMain.cc 