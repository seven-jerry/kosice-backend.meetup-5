set -e
eval $(crc oc-env)
# kill any sub shells on interrupt
trap "kill 0" SIGINT


# oc new-project my-namespace

(cd docker && oc project my-namespace \
&& oc new-build --name=my-microservice-example-build --binary --strategy=docker \
&& oc start-build my-microservice-example-build --from-dir=. --follow)

oc new-app my-microservice-example-build
oc expose my-microservice-example-build

