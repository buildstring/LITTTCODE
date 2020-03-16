class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        dfs(s, 0, new StringBuilder(), res, 0);
        return res;
    }
    private void dfs(String s, int idx, StringBuilder sol, List<String> res, int num){
        if(num == 4){
            if(idx == s.length()){
                sol.setLength(sol.length() - 1);  //delete the extra '.'
                res.add(sol.toString());
            }
            return;
        }
        int len = sol.length();
        for(int l = 1; l <= 3; l++){
            if(idx + l > s.length()) break; 
            int val = Integer.valueOf(s.substring(idx, idx + l)); //cache the value
            if(val <= 255){
                sol.append(val + ".");
                dfs(s, idx + l, sol, res, num + 1);  //since substring's range is [idx, idx + l) so next position that needed to be checked is idx + l
                sol.setLength(len);
            }
            if(val == 0) break;
        }
    }
}
