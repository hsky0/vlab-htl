"""Mutual Recursion"""


def split(n):
    return n // 10, n % 10


def sum_digit(n):
    if n < 10:
        return n
    else:
        all_but_last, last = split(n)
        return sum_digit(all_but_last) + last
    

def luhn_sum(n):
    if n < 10:
        return n
    else:
        all_but_last, last = split(n)
        return luhn_double_sum(all_but_last) + last
    

def luhn_double_sum(n):
    all_but_last, last = split(n)
    double_digit = sum_digit(2 * last)
    if n < 10:
        return double_digit
    else:
        return luhn_sum(all_but_last) + double_digit
    

