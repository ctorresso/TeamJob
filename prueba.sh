#!/bin/bash
echo "*************************"
echo "La tabla del" $n1" hasta el " $n2
sleep 2
#Seleccionamos los valores a seleccionar y comenzamos el bucle
for ((i=1; i<n2+1; i++))
do
	  mult=$(($n1*$i))
    echo "$n1 x $i = $mult"    
done
if [ "$invertir" = "true" ]
then
	sleep 2
    	echo "************************"
    
    	echo "Invertiremos los valores"
    	echo "La tabla del" $n2 " hasta el " $n1
    	for ((i=1; i<n1+1;i++))
    	do
    	  	mult=$(($n2*$i))
        	echo "$n2 x $i = $mult"
    	done
    
fi
sleep 2
echo "Terminamos"
