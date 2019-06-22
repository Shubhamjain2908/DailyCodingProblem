/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.Entry.comparingByValue;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import java.util.stream.Stream;

/**
 * Uber
 * @author SHUBHAM
 * On election day, a voting machine writes data in the form (voter_id, candidate_id) to a text file. 
 * Write a program that reads this file as a stream and returns the top 3 candidates at any given time.
 * If you find a voter voting more than once, report this as fraud.
 */
public class P300_VotingMachine {
    public static void main(String[] args) {
        Vote v = new Vote();
        v.addVote(1, 2);
        v.addVote(2, 3);
        v.addVote(3, 4);
        v.addVote(4, 5);
        v.addVote(5, 2);
        v.addVote(6, 4);
        v.addVote(7, 4);
        v.addVote(8, 4);
        v.addVote(9, 6);
        v.addVote(10, 3);
        v.addVote(11, 5);
        System.out.println(v.getTopCandidates());
    }
    static class Vote {
        
        private static List<Integer> candidates;
        private static Map<Integer, Integer> voteMap;
        private static Map<Integer, Integer> voteCount;
        
        public Vote() {
            Vote.candidates = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).collect(toList());
            Vote.voteCount = candidates.stream().collect(Collectors.toMap(p -> p, p -> 0));
            Vote.voteMap = new HashMap<>();
        }
        
        public List<Integer> getTopCandidates() {
            List<Integer> list = new ArrayList<>();
            voteCount = voteCount.entrySet().stream().sorted(comparingByValue())
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
            int i = candidates.size();
            for (Map.Entry<Integer, Integer> e : voteCount.entrySet()) {
                if (i <= 3) {
                    list.add(e.getKey());
                }
                i--;
            }
            return list;
        }
        
        public boolean addVote(int voterId, int candidateId) {
            if (!voteCount.containsKey(candidateId)) {
                throw new Error("No candidate found with this Id");
            }
            if (voteMap.containsKey(voterId)) {
                throw new Error("This candidate has already given voted");
            }
            voteMap.put(voterId, candidateId);
            voteCount.put(candidateId, voteCount.get(candidateId) + 1);
            return true;
        }
        
        public void printCount() {
            voteCount.entrySet().forEach((e) -> {
                System.out.println(e.getKey() + " => " + e.getValue());
            });
        }
        
    }
}
