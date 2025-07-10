class Solution {
    static boolean isValid(String segment){
        if(segment.length() == 0 || (segment.length() >1 && segment.charAt(0) == '0')){
            return false;
        }

        int value =Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }
    static void restoreIP(int idx,int dots,String s,String path,List<String> result){
        if(dots == 4 && idx == s.length()){
            result.add(path.substring(0, path.length() - 1));
            return;
        }

        if (dots > 4) return;

        for(int i= 1;i <=3 && idx+i<= s.length(); i++){
            String segment = s.substring(idx,idx+i);
            if(isValid(segment)){
                restoreIP(idx+i,dots+1,s,path + segment + ".",result);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        restoreIP(0,0,s,"",result);
        return result;
    }
}