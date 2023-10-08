## Task
Nucleotides that make up genes in DNA molecules are designated with one of four values: A, C, G or T. If a gene
the description will be stored in the variable type String, then two bytes will be needed to encode each nucleotide, i.e. 16
bits because strings of type String in Java consist of Unicode symbols. But for encoding four possible values
two bits can be used, for example, A is coded with bits 00, C with bits 01, G with 10, and T with 11. Then the memories
the amount needed to store the gene description can be reduced 8 times (from 16 bits to 2 bits
for coding each nucleotide).

Develop a program that does the following:
- Converts a string of symbols A, C, G, and T to an array of bytes, encoding each of the symbols with two bits   
- Converts an array of bytes to a string of symbols A, C, G, and T, replacing each pair of bits with
    corresponding symbol

### Program requirements:


- the program must be developed as a console app (without graphical windows), the user interface requirements are described below;
- the program should include handling of wrong actions of the user;
- Place the source code of the program in one file called Main.java;
- Convert the entered symbol string into an array of elements of type byte by encoding
symbol A with bits 00, C with bits 01, G with 10, and T with 11. In the first element of the array
write the number of letters, fill unused bits in the last element with zeros

### Examples

For example, if the user entered:

comp CGATAAG

Then the program should output:

7 63 8

Where 7 is the number of symbols.

But if the user entered:

decomp 4 10 30 -127 32

Then the program should output:

A 1E 81 20

ACTGGAACAG
