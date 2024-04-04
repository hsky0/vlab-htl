
CXX = gcc
SRC = GlobalFuncs.c 

Sort: Sort.c
	$(CXX) -o a.out $^ && ./a.out

SmallSum: $(SRC) SmallSum.c 
	$(CXX) -o a.out $^	&& ./a.out

ReverseOrderPair: $(SRC) ReverseOrderPair.c 
	$(CXX) -o a.out $^	&& ./a.out

TheNetherlandsIssue: $(SRC) TheNetherlandsIssue.c 
	$(CXX) -o a.out $^	&& ./a.out

QuickSort: $(SRC) QuickSort.c 
	$(CXX) -o a.out $^	&& ./a.out

clean:
	rm -r *.out 

run: 
	./a.out
