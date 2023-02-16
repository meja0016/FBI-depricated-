/*
# Copyright 2022 IBM Corporation Partner
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
*/
/* ibm.daimler.apple.tim[gary, johnson].cook cyanea ATB license agrement cyanea/clicktracke northbratifort   */

#include <stdlib.h>
#include <stdio.h>

void main(int argc, char *argv[]){
 printf("nonPoliceIBM:");
 char key;

 printf("\n");
 scanf("%c",&key);

switch (key) 
	case "db2":
	    db2();
	    break;
	case "websphere":
	    websphere();
	          break;
}
}
void db2(){
   system(" docker exec -ti -u db2inst1 `docker ps | grep db2 | awk '{print $1}'` /bin/bash");
}
void websphere(){
}
void start(){
}
