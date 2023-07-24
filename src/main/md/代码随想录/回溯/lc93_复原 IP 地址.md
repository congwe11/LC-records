## 93. 复原 IP 地址


```java
class Solution {
    List<String> res = new ArrayList<>();
    // StringBuilder strB = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        backTracking(s, 0, 0);
        return res; 
    }

    public void backTracking(String s, int startIndex, int pointNum) {
        if (pointNum==3) {
            if (isValid(s, startIndex, s.length()-1)) {
                res.add(s);
            }
            return;
        }

        for (int i = startIndex; i<s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i+1) + "." + s.substring(i+1);
                pointNum++;
                backTracking(s, i+2, pointNum);
                pointNum--;
                s = s.substring(0, i+1) + s.substring(i+2);
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i=start; i<=end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {// 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num>255) {
                return false;
            }
        }
        return true;
    }
}
```