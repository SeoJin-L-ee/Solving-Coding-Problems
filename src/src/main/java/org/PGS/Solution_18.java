package org.PGS;

import java.util.*;

// 베스트앨범
class Solution_18 {
    public List<Integer> solution(String[] genres, int[] plays) {
        Map<String, Integer> gSum = new HashMap<>();

        for (int i = 0; i < genres.length; i++) gSum.put(genres[i], gSum.getOrDefault(genres[i], 0) + plays[i]);
        // 재생수 많은 순으로 정렬
        List<String> sorted = new ArrayList<>(gSum.keySet());
        sorted.sort((a, b) -> gSum.get(b) - gSum.get(a));

        List<Integer> answer = new ArrayList<>();
        // 각 장르별로 노래 재생 수 판단해서 songIds에 넣음
        for (String g : sorted) {
            List<Integer> songIds = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(g)) songIds.add(i);
            }
            songIds.sort((a, b) -> plays[a]!=plays[b] ? plays[b]-plays[a] : a-b);
            answer.add(songIds.get(0));
            if (songIds.size() >= 2) answer.add(songIds.get(1));
        }
        return answer;
    }
}
