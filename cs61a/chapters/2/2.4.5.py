
"""Test the address of the functions about high-order-function"""

def make_withdraw(balance):
    def withdraw(amount):
        nonlocal balance
        if amount < balance:
            return 'Insufficient funds'
        balance = balance - amount
        return balance
    
    return withdraw