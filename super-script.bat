
call mvn clean install
echo [-----Info-----] Clean install successfully terminated

xcopy D:\Internship\jsfexample\target\jsfexample.war D:\tomcat9\webapps\
echo [-----Info-----] Copy successfully done

start cmd /k D:\tomcat9\bin\shutdown.bat
start cmd /k D:\tomcat9\bin\startup.bat
