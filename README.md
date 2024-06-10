# JSON verifier
To run this project you must have a basic configurated IDE for programming in java (my java version is "OpenJDK 11.0.22") with addition Log4j package. 
To deploy Log4j library you have to download an appriopriate .zip from "https://logging.apache.org/log4j/2.x/download.html", 
then unpack it and add two extra files to "project structure libraries" from downloaded, unpacked file obviously.: 
1) "log4j-api-2.22.1.jar"
2) "log4j-core-2.22.1.jar"
    
If you don't have enough time for configurate your ide, you can also run a file, which does not require any extra stuffs.
I took into the action each possible situation and errors, so there cannot be any difficulties with performing a code, if only IDE is properly configured.

<h5>Solution with Log4j -> src/main/java/com/example/test_projekt/JsonPolicyVerifierLogs.java</h5>

<h5>Solution without Log4j -> src/main/java/com/example/test_projekt/JsonPolicyVerifierLogs.java</h5>

<h5>File with exemplary JSON data (in console executed program asks user about the path to the JSON file) -> src/exemplaryData.json</h5>

<h5>File with Log4j configuration -> src/main/resources/log4j2.xml</h5>

<h6>Hope everything fine :)</h6>
