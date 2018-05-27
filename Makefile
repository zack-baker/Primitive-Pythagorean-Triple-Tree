all:
	javac -d bin/ src/*.java

run:	all
	java -cp bin/ PPT 
clean:
	rm bin/*

