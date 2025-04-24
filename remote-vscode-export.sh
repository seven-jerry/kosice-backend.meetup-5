# exports java sources into a directory
mkdir -p target/jarsources/lib
mkdir -p target/jarsources/src
mkdir -p target/jarsources/.vscode
mvn dependency:copy-dependencies -DoutputDirectory=target/jarsources/lib
mvn dependency:copy-dependencies -Dclassifier=sources -DoutputDirectory=target/jarsources/lib
cp -R src/main/java/* target/jarsources/src
cat > target/jarsources/.vscode/launch.json << EOL
{
          "version": "0.2.0",
          "configurations": [
              {
                  "type": "java",
                  "name": "Attach",
                  "request": "attach",
                  "hostName": "localhost",
                  "port": "5005"
              }

          ]
      }
EOL