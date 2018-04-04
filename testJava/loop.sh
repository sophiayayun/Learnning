#!/bin/bash  
# function: mutli call  
  
for i in `seq 1 1000`; do  
    java src/main/java/com/lock/HashMapLoop  
done  
  
exit 0
