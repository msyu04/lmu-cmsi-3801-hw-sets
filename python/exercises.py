from dataclasses import dataclass
from collections.abc import Callable
from typing import Callable, Optional


def change(amount: int) -> dict[int, int]:
    if not isinstance(amount, int):
        raise TypeError('Amount must be an integer')
    if amount < 0:
        raise ValueError('Amount cannot be negative')
    counts, remaining = {}, amount
    for denomination in (25, 10, 5, 1):
        counts[denomination], remaining = divmod(remaining, denomination)
    return counts


# Write your first then lower case function here
def first_then_lower_case(a: list[str], p: Callable[[str], bool], /) -> Optional[str]:
    for string in a:
        if p(string):
            return string.lower()
    return None


# Write your powers generator here
def powers_generator(*, base, limit):
    exponent = 0
    while True:
        limit_test = base**exponent
        if limit_test > limit:
            break
        yield limit_test
        exponent += 1


# Write your say function here
def say(word=None):
    created_string = []

    def next_word(new_word=None):
        if new_word == "": # empty string 
            created_string.append(("")) # add space "" to end of list
            return next_word # chain
        
        if new_word: # non empty string
            created_string.append(new_word) # add new_word to end of created string
            return next_word  # chain
        
        else: # not given anything --> say()
            return " ".join(created_string)  # Return the final string
    
    return next_word(word)


# Write your line count function here


# Write your Quaternion class here
