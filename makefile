all:	lottery

lottery:	com/hqnest/*.java
	javac -cp lib/jsoup-1.8.3.jar com/hqnest/*.java -d .
	java -cp .:lib/mysql-connector-java.jar:lib/jsoup-1.8.3.jar lottery.com.hqnest.Lottery

# init lottery database
db:
	mysql -u root -p lottery < db/kj160330.sql

clean:
	rm -rf lottery

.PHONY: all lottery db clean
