package cn.bininc;
import org.junit.Assert;
import org.junit.Test;

public class MutiResultTest {

    enum ResType {
        SUM,
        DIFF
    }

    public static MutiResult<ResType, Integer> compute(int a, int b) {
        return MutiResult.<ResType, Integer>build(ResType.class, Integer.class)
                .add(ResType.SUM, a + b)
                .add(ResType.DIFF, a - b)
                .build();
    }

    @Test
    public void TestMutiResult(){
        int a = 10, b = 7;
        MutiResult<ResType, Integer> resMap = compute(a, b);
        System.out.println("两数之和：" + resMap.get(ResType.SUM));
        System.out.println("两数之差：" + resMap.get(ResType.DIFF));
        Assert.assertEquals(resMap.get(ResType.SUM),Integer.valueOf(17));
        Assert.assertEquals(resMap.get(ResType.DIFF),Integer.valueOf(3));

    }
}
