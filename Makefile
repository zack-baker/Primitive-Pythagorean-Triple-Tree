all:
	javac -d bin/ src/*.java

run:	all
	java -cp bin/ PPT 5
clean:
	rm bin/*

