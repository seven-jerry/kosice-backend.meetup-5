set -e
eval $(minikube docker-env)
#eval $(crc oc-env)
# kill any sub shells on interrupt
trap "kill 0" SIGINT


# oc new-project my-namespace

cd docker && docker build -t microservice .

