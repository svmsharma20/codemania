## Introduction

String hashing specifically tries to solve the string comparison problem. Normally if we want to compare two strings we go letter by letter of both the strings, which take **O(min(n1, n2)** where **n1** and **n2** are the sizes of the two string. By using the string hashing we convert both the string into an integer and compare those instead of strings. Comparing two integer takes **O(1)** operation.

## Hash function
For converting string to an integer we need a hash function. And this hash function should satisfy one condition, that is, if two strings **s1** and **s2** are same, then their hashes should also be equal, that is **hash(s1)** = **hash(s2)**. The viceversa doesn't have to be true. That is, if hashes are equal, then the string do not necessarily have to be same or equal.

The most popular has funtion is **polynomial rolling hash function**:
    ![](https://latex.codecogs.com/gif.latex?hash%28s%29%20%3D%20s%5B0%5D%20&plus;%20s%5B1%5D%20%5Ccdot%20p%20&plus;%20s%5B2%5D%20%5Ccdot%20p%5E2%20&plus;%20s%5B3%5D%20%5Ccdot%20p%5E3%20&plus;%20%5Ccdots%20&plus;%20s%5Bn-1%5D%20%5Ccdot%20p%5E%7Bn-1%7D%20%5Cmod%20m)

where _p_ and _m_ are some chosen, positive numbers. It is reasonable to make _p_ a prime number roughly equal to the number of characters in the input alphabet and, _m_  should be a large number since the probability of two random strings colliding is about ![](https://latex.codecogs.com/gif.latex?%5Cdpi%7B80%7D%20%5Capprox%20%5Cfrac%7B1%7D%7Bm%7D)