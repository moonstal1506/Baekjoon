class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String tree : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tree.length(); i++) {
                if (skill.contains(String.valueOf(tree.charAt(i)))) {
                    sb.append(tree.charAt(i));
                }
            }
            System.out.println(sb.toString());
            if (skill.indexOf(sb.toString())==0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int cbd = solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println(cbd);
    }
}