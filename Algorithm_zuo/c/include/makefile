
CXX = gcc
SRC = SortFuncs.c GlobalFuncs.c Validator.c 

test: $(SRC) test.c 
	$(CXX) -o a.out $^ && ./a.out 

.PHONY: clean

clean:
	rm -r *.out 

