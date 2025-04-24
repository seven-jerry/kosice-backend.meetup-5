echo "$UNPACK_JAR"
if [[ "$UNPACK_JAR" == "true" ]]; then
  echo "unpacking jar"
  mkdir /tmp/app
  cd /tmp/app && unzip -o /contents/*.jar
  java $JAVA_OPTIONS -cp "/tmp/app/BOOT-INF/lib/*:/tmp/app/BOOT-INF/classes" "org.some.example.ExampleApplication"
else
echo "starting"
cd /contents && java -jar microservice-example-1.0-SNAPSHOT.jar
fi