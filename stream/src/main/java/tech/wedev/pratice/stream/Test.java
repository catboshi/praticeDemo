package tech.wedev.pratice.stream;

import org.springframework.util.StringUtils;

public class Test{

    private static final String UNIT = "万千百";
    private static final String NUMBER = "零一二三四五六七八九十";
    public static int strToInt(String val) {
        if (StringUtils.isEmpty(val)) {
            return 0;
        }
        boolean isZero = true;
        String rs = "";
        int i = 0;
        int j = UNIT.length() - val.length();
        for (;i<val.length();i++,j++){
            char ch = val.charAt(i);
            if (ch == '0') {
                isZero = true;
                if (UNIT.charAt(j) == '万' || UNIT.charAt(j) == '千' || UNIT.charAt(j) == '百') {
                    rs = rs + UNIT.charAt(j);
                    isZero = false;
                }
            } else {
                if (isZero) {
                    rs = rs + "零";
                    isZero = false;
                }
                rs = rs + NUMBER.charAt(ch - '0') + NUMBER.charAt(j);
            }
        }
        return Integer.parseInt(rs);
    }
    public static void main(String[] args) {
        //六千零三 --> 6003
        System.out.println(Test.strToInt("六千零三"));
    }
}
