/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Quora
 * @author SHUBHAM
 * Word sense disambiguation is the problem of determining which sense a word takes on in a particular setting, if that word has multiple meanings. For example, in the sentence "I went to get money from the bank", bank probably means the place where people deposit money, not the land beside a river or lake.
Suppose you are given a list of meanings for several words, formatted like so:
{
    "word_1": ["meaning one", "meaning two", ...],
    ...
    "word_n": ["meaning one", "meaning two", ...]
}
Given a sentence, most of whose words are contained in the meaning list above, create an algorithm that determines the likely sense of each possibly ambiguous word.
 */
public class P351_WordSenseDisambiguation {
    // Incomplete Problem
    // 1. Problem definition is incomplete
    // 2. We also need a source for which word appears in which context, to be able to infer this in the actual sentences.
    // 3. Once we have a set of strongly correlated words with each word-sense, we can search the context of a word in the target sentence.
    // 4. If there is a high overlap of those words with the already correlated words for a particular word sense, we can guess that that is the answer
}
