#!/bin/bash
# cmps012a-pt.w17 grading
# usage: pa6.sh
# (run within your pa6 directory to test your code)

SRCDIR=https://raw.githubusercontent.com/legendddhgf/CMPS012A-pt.w17-grading-scripts/master/pa6
# Get all necessary extras

curl $SRCDIR/ComplexExceptionTest.java > ComplexExceptionTest.java

for num in 1 2 3 4
do
  curl $SRCDIR/in$num.txt > in$num.txt
  curl $SRCDIR/model-out$num.txt > model-out$num.txt
done

if [ ! -d .backup ]; then
   mkdir .backup
fi

cp *.java Makefile .backup

make

echo ""

# Run tests
echo "If nothing between '=' signs, then test is passed::"
for num in 1 2 3 4
do
   echo "Test $num:"
   echo "=========="
   timeout 0.5 ComplexTest in$num.txt out$num.txt
   diff -bBwu out$num.txt model-out$num.txt > diff$num.txt
   cat diff$num.txt
   echo "=========="
done

echo ""

make spotless

echo ""

if [ -e ComplexTest ] || [ -e *.class ]; then
   echo "WARNING: Makefile didn't successfully clean all files"
fi

echo ""

# Compile unit tests
javac Complex.java > junkfile
javac ComplexExceptionTest.java > junkfile
echo "Main-class: ComplexExceptionTest" > Manifest
jar cvfm ComplexExceptionTest Manifest *.class > junkfile
rm Manifest > junkfile
chmod +x ComplexExceptionTest > junkfile
rm junkfile

echo "Unit Tests:"
timeout 0.5 ComplexExceptionTest
echo ""

rm -f *.class ComplexTest ComplexExceptionTest
