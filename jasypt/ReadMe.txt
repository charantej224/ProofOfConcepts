Command to Encrypt password : - Point to note, its attempted after dependencies are present in the local repo.
java -cp ~/.m2/repository/org/jasypt/jasypt/1.9.2/jasypt-1.9.2.jar  org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="contactspassword" password=supersecretz algorithm=PBEWithMD5AndDES


Output:==================== Password encrypted. 

----ENVIRONMENT-----------------

Runtime: Oracle Corporation Java HotSpot(TM) 64-Bit Server VM 25.181-b13 



----ARGUMENTS-------------------

algorithm: PBEWithMD5AndDES
input: contactspassword
password: supersecretz



----OUTPUT----------------------

o30W90Qq5uQeHCOqLXM6HbwsJwdeKivj6g433ZwC4ZM=