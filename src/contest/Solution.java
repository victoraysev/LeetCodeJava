package contest;

import java.util.Arrays;

class Solution {
    public String getSmallestString(String s, int k) {
        String t = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c < 'l'){
                int diff = c - 'a';
                if(k - diff >= 0){
                    t += 'a';
                    k -= diff;
                }else{
                    t += (char)(c - k);
                    k = 0;
                }
            }
            else{
                char c1 = (char)(c - k);
                char c2 = (char)(c + k);
                if(c2 > 122){
                    k -= 123 - c;
                    t += 'a';
                }
                else{
                    if(c1 < 'a'){
                        t+= 'a';
                        k -= c - 'a';
                    }
                    else if (c1 == 'a'){
                        t+= 'a';
                        k = 0;
                    }
                    else{
                        t += c1;
                        k = 0;
                    }
                }
            }
        }

        return t;
    }

    public long minNumberForMedian(int[] nums, int k) {
        Arrays.sort(nums);
        int medianIndex =  nums.length / 2;
        int median = nums[medianIndex];
        long ops = 0;
        if(median == k){
            return ops;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < medianIndex){
                if (nums[i] > k){
                    ops += (nums[i] - k);
                    nums[i] = k;
                }
            }
            else if ( i == medianIndex){
                if (nums[i] != k){
                    if(nums[i] > k){
                        ops += (nums[i] - k);
                        nums[i] = k;
                    }
                    else{
                        ops += (k - nums[i]);
                        nums[i] = k;
                    }
                }
            }
            else{
                if(nums[i] < k){
                    ops += (k - nums[i]);
                    nums[i] = k;
                }
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        //new Solution().getSmallestString("mxr", 17);
        //[2,5,6,8,5]
        var res = new Solution().minNumberForMedian(new int[]{229333782,442606853,138416643,614593645,58725648,561655843,638220939,495417506,820448215,228641140,674018368,255585666,440494863,770296718,402252216,986956522,837094359,229974290,217282495,999466380,297458727,490298157,368379796,999497402,924288070,197178224,848520212,18411344,993928967,611203709,284289359,353844203,260986435,991762109,507772951,293781751,691215793,759629339,579775859,486935301,207667234,321753724,397369411,610686636,750645317,41625513,848878133,637502056,345652404,356156636,186699025,417703568,178886157,654176985,730245283,927093140,300122738,342665201,793209476,749628,597691820,580625883,499384656,314978829,522584461,357672512,667351801,459370020,982275138,757158174,693052285,538733084,723083505,64910281,763884427,286988441,238411090,171111839,462364068,251130207,150812784,554800999,951275335,961791380,453204109,47816648,107105182,416417844,171790098,997717319,897231327,179995846,343051974,488193699}, 982275138);
        System.out.println(res);
    }
}




/*
Input: nums = [2,5,6,8,5], k = 4

Output: 2

Explanation:

We can subtract one from nums[1] and nums[4] to obtain [2, 4, 6, 8, 4]. The median of the resulting array is equal to k.

Example 2:

Input: nums = [2,5,6,8,5], k = 7

Output: 3

Explanation:

We can add one to nums[1] twice and add one to nums[2] once to obtain [2, 7, 7, 8, 5].

Example 3:

Input: nums = [1,2,3,4,5,6], k = 4

Output: 0

Explanation:

The median of the array is already equal to k.
 */