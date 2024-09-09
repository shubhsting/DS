// https://leetcode.com/problems/smallest-sufficient-team/description/

class Solution {
    List<Integer> ans = new ArrayList<>();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int index = 0; index < req_skills.length; index++)
            map.put(req_skills[index], index);
        int[] bitPeople = new int[people.size()];
        for (int index = 0; index < people.size(); index++) {
            List<String> person = people.get(index);
            int mask = 0;
            for (String skill : person)
                mask = mask | 1 << map.get(skill);
            bitPeople[index] = mask;
        }
        int[][] dp = new int[people.size() + 1][(int) Math.pow(2, req_skills.length)];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        test(bitPeople, 0, 0, new ArrayList<>(), req_skills.length, dp);
        int[] a = new int[ans.size()];
        for (int index = 0; index < a.length; index++)
            a[index] = ans.get(index);
        return a;
    }

    public void test(int[] bitPeople, int idx, int temp, List<Integer> team, int totalSkills, int[][] dp) {
        if (temp == ((1 << totalSkills) - 1)) {
            if (ans.size() == 0 || ans.size() > team.size())
                ans = new ArrayList<>(team);
            return;
        }

        if (idx >= bitPeople.length)
            return;
        if (dp[idx][temp] != -1 && team.size() >= dp[idx][temp])
            return;
        test(bitPeople, idx + 1, temp, team, totalSkills, dp);
        team.add(idx);
        test(bitPeople, idx + 1, temp | bitPeople[idx], team, totalSkills, dp);
        team.remove(team.size() - 1);
        dp[idx][temp] = team.size();
    }
}