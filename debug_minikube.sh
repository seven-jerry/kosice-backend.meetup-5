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
POD="$(kubectl get pods --selector="app=microservice" -o custom-columns=POD:.metadata.name --no-headers)"

 kubectl cp -c microservice ./target/classes  $POD:/tmp/app/BOOT-INF
kubectl logs --since=1s -f $POD &
kubectl port-forward $POD 5005




