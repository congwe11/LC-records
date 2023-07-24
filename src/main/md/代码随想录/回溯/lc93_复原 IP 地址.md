## 93. 复原 IP 地址

```Java
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

python
```Python
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:

        res = []

        self.backTracking(s, 0, 0, res)

        return res

    def backTracking(self, s, startIndex, pointNum, res):
        if pointNum == 3:
            if self.isValid(s, startIndex, len(s) - 1):
                res.append(s)
            return
        
        for i in range(startIndex, len(s)):
            if self.isValid(s, startIndex, i):
                s = s[:i + 1] + "." + s[i + 1:]
                pointNum += 1
                self.backTracking(s, i + 2, pointNum, res)
                pointNum -= 1
                s = s[:i + 1] + s[i + 2:]
            else:
                break

    def isValid(self, s, start, end):
        if start > end:
            return False
        if s[start] == '0' and start != end:
            return False
        
        num = 0
        # for i in range(start, end + 1):
        #     if not s[i].isdigit():
        #         return False
        #     num = num * 10 + int(s[i])
            
        #     if num > 255:
        #         return False
        
        # return True

        num = int(s[start:end+1])
        return 0 <= num <= 255

```