## Introduction

String hashing specifically tries to solve the string comparison problem. Normally if we want to compare two strings we go letter by letter of both the strings, which take $O(min(n1, n2))$ where $n_1$ and $n_2$ are the sizes of the two string. By using the string hashing we convert both the string into an integer and compare those instead of strings. Comparing two integer takes **O(1)** operation.

## Hash function
For converting string to an integer we need a hash function. And this hash function should satisfy one condition, that is, if two strings $s_1$ and $s_2$ are same, then their hashes should also be equal, that is $hash(s_1)$ = $hash(s_2)$. The viceversa doesn't have to be true. That is, if hashes are equal, then the string do not necessarily have to be same or equal.

The most popular function is **polynomial rolling hash function**:
$$
hash(s) =  s[0] + s[1] \cdot p + s[2] \cdot p^2 + s[3] \cdot p^3 \mod m
$$
where $p$ and $m$ are positive numbers.