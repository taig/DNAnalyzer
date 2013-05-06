DNAnalyzer
==========

A Java application for evaluation of DNA sequences.

This application is my contribution to the [Coding Contest 2013].

Assignment
----------

Design a program that can analyze a DNA sequence for patterns.
 
DNA consists of long strands of nucleotides. Each nucleotide has a nucleobase. There are only fourprimary nucleobases in all DNA: cytosine, guanine, adenine and thymine, abbreviated s C, G, A and Trespectively. DNA for an organism can be represented as a long sequence of just these four letters.
 
You have to write a program that analyzes a given DNA sequence for the occurrence of specific patterns.
 
This is a 1000-nucleobase long segment of the DNA sequence of a 35-year-old female of unspecified race:
 
    ggaatttagggagttcccacattgcccagacgactcgtatagaattggtagttggccatg
    cgtccatatcacaaagacacagtccctggccgaccacactgtaaccacgaatatgcccta
    tcgtacgggttgggatgcacttttgagttatacgcgctcgaatctatgcccagtacacat
    ggtgccgacacctaactaggcagtgaggggcactcagacctgacatgagcggaagaaaga
    acccgcgggggccccacgacgtagcggcgacggctcaaccaatgccccgcccctttcata
    aggccaagcggactgggctttcgcccgagtctaaacccactgtatttaccattcatagtc
    aacagagggactttcaaaattcctaaactggttactgactaagaggaatcctcgcgctaa
    tgaagacaacctccatagaggtcaaatggcgcgcagttgacttcagtattgaccttcttc
    agggtcccccatctttgatacttcacttatggacccggccaccgtgagttgaatcccggc
    gtccctcgcgtccccaacacagacaatatttttacgtgtccaagggcggaaagtgacgag
    gtgagaactggcgccgcgagaccggcccgatttctaataggcgggatagagatctgcccg
    acgcatttcacttgtagtcactcacggtatgactgtgcatgcactgaccgtcgctggcgt
    gtctttaatttaagctaggcttgacgtggagtgcagaatgaccatgttcaaggtgcttcg
    gggctatatacttgggataaacgcgatcctgcggagtagcgtcgagaacaccgactgccg
    aatgtacaatccgcgtgacaatgccgaggctcgagatatcacttgaactgcgggcgaatc
    gattcgagagcccgatcgttaacaagtcgtcggctgtagccaataatatcttggttttag
    atcttgagtgtgggggcgtttacttaaccatccgaacgcg
 
Answer the following questions:
 
1. Three distinct sequences of ```GGG``` within any 1000-nucleobases signify an elevated riskto acquiring Tyberius syndrome. Based on the given DNA segment, is this female at suchrisk?
2. The sequence ```CAG``` followed by exactly one ```C``` or one ```G``` and then not followed by Tin the next 2 slots signifies brown eyes. Does this female have brown eyes?
3. How many of each nucleobase does this segment have?
4. What's the location of the first occurrence of the sequence ```CTAG``` in the given segment (assume nucleobases are numbered from 1 to 1000).
 
In-Office Extension:
 
Here's some additional information about DNA:
 
Each nucleobase has a complementary nucleobase. A and T are complementary; C and G arecomplementary. A sequence is complementary to another sequence if it has the complementarynucleobases in the reverse order. For example, the complementary sequence to TTAC is GTAA.
 
Adenine and guanine belong to the double-ringed class of molecules called purines (abbreviated as R).Cytosine and thymine are pyrimidines (abbreviated as Y).
 
Answer the following:
 
1. Does this segment have more purines than pyrimidines?
2. Four purines followed by four pyrimidines have been shown to have a strong correlationwith the early onset of Frømingen's dischrypsia. Does this DNA strand show evidence forthis correlation?
3. What's the complementary sequence for the entire 1000-nucleobase segment?

Usage
-----

TODO

License
-------

TODO

  [Coding Contest 2013]: http://www.coding-contest.de/
