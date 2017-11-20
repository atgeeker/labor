package com.busi.util;

/**
 * Created by zzy on 2017/9/4.
 */
public class BankNoValidUtil {
    /**
     * 校验银行卡是否有效  合法：true 不合法：false
     * @param bankNo
     * @return
     */
    public static boolean bankNoIsValid(String bankNo) {

        String nonCheckCodeCardId = bankNo.substring(0, bankNo.length() - 1);
        if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+") || nonCheckCodeCardId.trim().length() < 15
                || nonCheckCodeCardId.trim().length() > 18) {
            //如果传的数据不合法返回N
            System.out.println("银行卡号不合法！");
            return false;
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        // 执行luh算法
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {  //偶数位处理
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        char res = (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
        String charJX = bankNo.substring(bankNo.length() - 1);
        if (charJX.equals(String.valueOf(res))) {
            System.out.println("银行卡合法！");
            return true;
        } else {
            System.out.println("银行卡不合法！");
            return false;
        }
    }
}
