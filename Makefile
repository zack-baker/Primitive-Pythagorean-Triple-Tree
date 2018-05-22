all:
	javac -d bin/ src/*.java

run:	all
	java -cp bin/ PPT 1
clean:
	rm bin/*

