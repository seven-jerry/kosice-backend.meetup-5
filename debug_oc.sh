set -e

eval $(crc oc-env)

# kill any sub shells on interrupt
trap "kill 0" SIGINT

banner(){
  echo "\n\n---------------------------\n"
  echo $1
  echo "---------------------------\n"
}

banner "maven compile"
mvn compile


banner "copy classes to ecp container"
oc project myproject
POD="$(oc get pods --selector="app=microservice-example" -o custom-columns=POD:.metadata.name --no-headers)"
oc rsync --delete=false target/classes pods/$POD:/tmp/app/BOOT-INF
oc logs --since=1s -f $POD &
oc port-forward $POD 30506




