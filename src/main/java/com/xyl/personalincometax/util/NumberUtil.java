package com.xyl.personalincometax.util;

import com.google.common.base.Optional;

import java.math.BigDecimal;

public class NumberUtil {


    /**
     * BigDecimal的加法运算封装
     *
     * @param b1
     * @param bn
     * @return
     * @author : shijing
     * <p>
     * 2017年3月23日下午4:53:21
     */

    public static BigDecimal safeAdd(BigDecimal b1, BigDecimal... bn) {

        if (null == b1) {

            b1 = BigDecimal.ZERO;

        }

        if (null != bn) {

            for (BigDecimal b : bn) {

                b1 = b1.add(null == b ? BigDecimal.ZERO : b);

            }

        }

        return b1;

    }


    /**
     * Integer加法运算的封装
     *
     * @param b1 第一个数
     * @param bn 需要加的加法数组
     * @return
     * @author : shijing
     * <p>
     * 2017年3月23日下午4:54:08
     * @注 ： Optional  是属于com.google.common.base.Optional<T> 下面的class
     */

    public static Integer safeAdd(Integer b1, Integer... bn) {

        if (null == b1) {

            b1 = 0;

        }

        Integer r = b1;

        if (null != bn) {

            for (Integer b : bn) {

                r += Optional.fromNullable(b).or(0);

            }

        }

        return r > 0 ? r : 0;

    }


    /**
     * 计算金额方法
     *
     * @param b1
     * @param bn
     * @return
     * @author : shijing
     * <p>
     * 2017年3月23日下午4:53:00
     */

    public static BigDecimal safeSubtract(BigDecimal b1, BigDecimal... bn) {

        return safeSubtract(true, b1, bn);

    }


    /**
     * BigDecimal的安全减法运算
     *
     * @param isZero 减法结果为负数时是否返回0，true是返回0（金额计算时使用），false是返回负数结果
     * @param b1     被减数
     * @param bn     需要减的减数数组
     * @return
     * @author : shijing
     * <p>
     * 2017年3月23日下午4:50:45
     */

    public static BigDecimal safeSubtract(Boolean isZero, BigDecimal b1, BigDecimal... bn) {

        if (null == b1) {

            b1 = BigDecimal.ZERO;

        }

        BigDecimal r = b1;

        if (null != bn) {

            for (BigDecimal b : bn) {

                r = r.subtract((null == b ? BigDecimal.ZERO : b));

            }

        }

        return isZero ? (r.compareTo(BigDecimal.ZERO) == -1 ? BigDecimal.ZERO : r) : r;

    }


    /**
     * 整型的减法运算，小于0时返回0
     *
     * @param b1
     * @param bn
     * @return
     * @author : shijing
     * <p>
     * 2017年3月23日下午4:58:16
     */

    /*public static Integer safeSubtract(Integer b1, Integer... bn) {

        if (null == b1) {

            b1 = 0;

        }

        Integer r = b1;

        if (null != bn) {

            for (Integer b : bn) {

                r -= Optional.fromNullable(b).or(0);

            }

        }

        return  !=r && r > 0 ? r : 0;

    }*/


    /**
     * 金额除法计算，返回2位小数（具体的返回多少位大家自己看着改吧）
     *
     * @param b1
     * @param b2
     * @return
     * @author : shijing
     * <p>
     * 2017年3月23日下午5:02:17
     */

    public static <T extends Number> BigDecimal safeDivide(T b1, T b2) {

        return safeDivide(b1, b2, BigDecimal.ZERO);

    }


    /**
     * BigDecimal的除法运算封装，如果除数或者被除数为0，返回默认值
     * <p>
     * 默认返回小数位后2位，用于金额计算
     *
     * @param b1
     * @param b2
     * @param defaultValue
     * @return
     * @author : shijing
     * <p>
     * 2017年3月23日下午4:59:29
     */

    public static <T extends Number> BigDecimal safeDivide(T b1, T b2, BigDecimal defaultValue) {

        if (null == b1 || null == b2) {

            return defaultValue;

        }

        try {

            return BigDecimal.valueOf(b1.doubleValue()).divide(BigDecimal.valueOf(b2.doubleValue()), 2, BigDecimal.ROUND_HALF_UP);

        } catch (Exception e) {

            return defaultValue;

        }

    }


    /**
     * BigDecimal的乘法运算封装
     *
     * @param b1
     * @param b2
     * @return
     * @author : shijing
     * <p>
     * 2017年3月23日下午5:01:57
     */

    public static <T extends Number> BigDecimal safeMultiply(T b1, T b2) {

        if (null == b1 || null == b2) {

            return BigDecimal.ZERO;

        }

        return BigDecimal.valueOf(b1.doubleValue()).multiply(BigDecimal.valueOf(b2.doubleValue())).setScale(2, BigDecimal.ROUND_HALF_UP);

    }


}
