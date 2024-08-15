package integertoroman12;

class Solution {
    public String intToRoman(int num) {
        var i = 0;
        var r = new StringBuilder();
        while(num > 0){
            var digit = num % 10;
            num = num / 10;
            var factor = (int)(Math.pow(10,i++));
            var processedNum = digit * factor;
            if(processedNum == 4){
                r.insert(0,"IV");
            }
            else if(processedNum == 40){
                r.insert(0,"XL");
            }
            else if(processedNum == 400){
                r.insert(0,"CD");
            }
            else if(processedNum == 9){
                r.insert(0,"IX");
            }
            else if(processedNum == 90){
                r.insert(0,"XC");
            }
            else if(processedNum == 900){
                r.insert(0,"CM");
            }
            else if(processedNum == 1){
                r.insert(0,"I");
            }
            else if(processedNum == 5){
                r.insert(0,"V");
            }
            else if(processedNum == 10){
                r.insert(0,"X");
            }
            else if(processedNum == 50){
                r.insert(0,"L");
            }
            else if(processedNum == 100){
                r.insert(0,"C");
            }
            else if(processedNum == 500){
                r.insert(0,"D");
            }
            else if(processedNum == 900){
                r.insert(0,"CM");
            }
            else{
                char c='A';
                if(digit > 1 && digit < 5){
                    if(factor == 1 ){
                        c = 'I';
                    }
                    else if(factor == 10 ){
                        c = 'X';
                    }
                    else if(factor == 100 ){
                        c = 'C';
                    }
                    else if(factor == 1000 ){
                        c = 'M';
                    }
                }
                else{
                    if(factor == 1 ){
                        c = 'V';
                    }
                    else if(factor == 10 ){
                        c = 'L';
                    }
                    else if(factor == 100 ){
                        c = 'D';
                    }
                    digit = digit - 5;
                }
                while(digit-- > 0){
                    r.insert(0,c);
                }
            }
        }
        return r.toString();
    }

    public static void main(String[] args) {
        int num = 3749;
        System.out.println(new Solution().intToRoman(num));
    }
}