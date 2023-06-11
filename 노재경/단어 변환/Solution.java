import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Set<String> set = new HashSet<>(Arrays.asList(words));

        if (!set.contains(target)) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();

        dfs(begin, set, target, answer, list);

        return list.stream().mapToInt(num -> num).min().getAsInt();
    }

    private void dfs(String begin, Set<String> set, String target, int answer, List<Integer> list) {
        if(begin.equals(target)){
            list.add(answer);
            return;
        }
        if(set.isEmpty()){
            return;
        }

        String [] arr = begin.split("");
        for(String word : set){
            String [] compare = word.split("");
            int count =0;
            for(int i=0;i<compare.length;i++){
                if(!arr[i].equals(compare[i])){
                    count++;
                }
            }
            if(count == 1){
                Set<String> nextSet = new HashSet<>(set);
                nextSet.remove(word);
                dfs(word, nextSet, target, answer+1, list);
            }
        }
    }
}
