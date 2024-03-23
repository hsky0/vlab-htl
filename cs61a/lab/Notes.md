# Labs Problems
## Lab05
Q3: Finding Barries
```python
def berry_finder(t):
    """Returns True if t contains a node with the value 'berry' and 
    False otherwise.

    >>> scrat = tree('berry')
    >>> berry_finder(scrat)
    True
    >>> sproul = tree('roots', [tree('branch1', [tree('leaf'), tree('berry')]), tree('branch2')])
    >>> berry_finder(sproul)
    True
    >>> numbers = tree(1, [tree(2), tree(3, [tree(4), tree(5)]), tree(6, [tree(7)])])
    >>> berry_finder(numbers)
    False
    >>> t = tree(1, [tree('berry',[tree('not berry')])])
    >>> berry_finder(t)
    True
    """
    "*** YOUR CODE HERE ***"
    if label(t) == 'berry:
        return True
    else:
        for b in branches(t):
            if berry_finder(b):
                return True
    return False

```

Q4: Sprout leaves
```python
def sprout_leaves(t, leaves):
    """Sprout new leaves containing the data in leaves at each leaf in
    the original tree t and return the resulting tree.

    >>> t1 = tree(1, [tree(2), tree(3)])
    >>> print_tree(t1)
    1
      2
      3
    >>> new1 = sprout_leaves(t1, [4, 5])
    >>> print_tree(new1)
    1
      2
        4
        5
      3
        4
        5

    >>> t2 = tree(1, [tree(2, [tree(3)])])
    >>> print_tree(t2)
    1
      2
        3
    >>> new2 = sprout_leaves(t2, [6, 1, 2])
    >>> print_tree(new2)
    1
      2
        3
          6
          1
          2
    """
    "*** YOUR CODE HERE ***"
    if is_leaf(t):
        return tree(label(t), [tree(x) for x in leaves])
    else:
        return tree(label(t), [sprout_leaves(b, leaves) for b in branches(b)])

```

Q6: Add trees
```python
def add_trees(t1, t2):
    """
    >>> numbers = tree(1,
    ...                [tree(2,
    ...                      [tree(3),
    ...                       tree(4)]),
    ...                 tree(5,
    ...                      [tree(6,
    ...                            [tree(7)]),
    ...                       tree(8)])])
    >>> print_tree(add_trees(numbers, numbers))
    2
      4
        6
        8
      10
        12
          14
        16
    >>> print_tree(add_trees(tree(2), tree(3, [tree(4), tree(5)])))
    5
      4
      5
    >>> print_tree(add_trees(tree(2, [tree(3)]), tree(2, [tree(3), tree(4)])))
    4
      6
      4
    >>> print_tree(add_trees(tree(2, [tree(3, [tree(4), tree(5)])]), \
    tree(2, [tree(3, [tree(4)]), tree(5)])))
    4
      6
        8
        5
      5
    """
    "*** YOUR CODE HERE ***"
    if is_leaf(t1):
        return tree(label(t1) + label(t2), branches(t2))
    elif is_lead(t2):
        return tree(label(t1) + label(t2), branches(t1))
    else:
        lower_branch, more_branch = sorted([branches(t1), branches(t2)], key=len)
        temp1 = lower_branch + [tree(0) for _ in range(len(more_branch) - len(lower_branch))]
        temp2 = more_branch
        return tree(label(t1) + label(t2), [add_tree(b1, b2) for b1, b2 in zip(temp1, temp2)])

```

## Lab06
Q4: Insert Items  
Think about the length changing when insert a elelment into the list
```python
def insert_items(lst, entry, elem):
    """
    >>> test_lst = [1, 5, 8, 5, 2, 3]
    >>> new_lst = insert_items(test_lst, 5, 7)
    >>> new_lst
    [1, 5, 7, 8, 5, 7, 2, 3]
    >>> large_lst = [1, 4, 8]
    >>> large_lst2 = insert_items(large_lst, 4, 4)
    >>> large_lst2
    [1, 4, 4, 8]
    >>> large_lst3 = insert_items(large_lst2, 4, 6)
    >>> large_lst3
    [1, 4, 6, 4, 6, 8]
    >>> large_lst3 is large_lst
    True
    """
    "*** YOUR CODE HERE ***"
  
```

## Lab07
Q2: Increasing Subsequences  
This question is difficult, we need to think about two comparation, the all of remaind elements compare with the previous elements, and we can achieve it by comparing the previous element with the last element.
```python
def inc_subseqs(s):
    """Assuming that S is a list, return a nested list of all subsequences
    of S (a list of lists) for which the elements of the subsequence
    are strictly nondecreasing. The subsequences can appear in any order.

    >>> seqs = inc_subseqs([1, 3, 2])
    >>> sorted(seqs)
    [[], [1], [1, 2], [1, 3], [2], [3]]
    >>> inc_subseqs([])
    [[]]
    >>> seqs2 = inc_subseqs([1, 1, 2])
    >>> sorted(seqs2)
    [[], [1], [1], [1, 1], [1, 1, 2], [1, 2], [1, 2], [2]]
    """

```

## 61a-su20-practice
Q1: same_digits
```python
def same_digits(a, b):
    """
    Implement same_digits, which takes two positive integers. It returns whether they both become
    the same number after replacing each sequence of a digit repeated consecutively with only one of that
    digit. For example, in 12222321, the sequence 2222 would be replaced by only 2, leaving 12321.
    Restriction: You may only write combinations of the following in the blanks:
    a, b, end, 10, %, if, while, and, or, ==, !=, True, False, and return. (No division allowed!)

    >>> same_digits(2002200, 2202000) # Ignoring repeats, both are 2020
    True
    >>> same_digits(21, 12) # Digits must appear in the same order
    False
    >>> same_digits(12, 2212) # 12 and 212 are not the same
    False
    >>> same_digits(2020, 20) # 2020 and 20 are not the same
    False
    """
    assert a > 0 and b > 0
```

Q2:make_guess
```python
def make_guess(n):
    """
    Let's play a guessing game! In order to do this, we'll use higher order functions.
    Write a function, make_guess, which takes in a number that we want someone to try to guess, and returns a guessing
    function.
    A guessing function is a one-argument function which takes in a number. If the number passed in is the number we
    wanted to guess, it will return the number of incorrect guesses made prior to the correct guess. Otherwise, it returns
    another guessing function, which keeps track of the fact that we've made an incorrect guess.
    Solutions which use lists, object mutation, nonlocal, or global will receive no credit.

    >>> guesser = make_guess(10)
    >>> guess1 = guesser(6)
    >>> guess2 = guess1(7)
    >>> guess3 = guess2(8)
    >>> guess3(10)
    3
    >>> guess2(10)
    2
    >>> a = make_guess(5)(1)(2)(3)(4)(5)
    >>> a
    4
    """
```

## Lab08
Q2: Generators   
I think this question is very difficuilt, mabey I don't understand the Topic : **Generator**\




## Lab10
Q3: Filter Lst
```scheme
(define (filter-lst fn lst)
  'YOUR-CODE-HERE
)

;;; Tests
(define (even? x)
  (= (modulo x 2) 0))
(filter-lst even? '(0 1 1 2 3 5 8))
; expect (0 2 8)

```

Q7 8 9 10 : These questions are about the **lst** in scheme
address:  https://inst.eecs.berkeley.edu/~cs61a/su20/lab/lab10/#q7