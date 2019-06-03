/**
 * 公司 58
 * 文件名 GetFicoBankScorejinpeipei}
 * 作者jinpeipei
 * 日期 2019/5/31 11:42
 */
package testcase.credit.scf.testCreditScoreService;

import com.alibaba.fastjson.JSONObject;
import com.bj58.fbu.ark.credit.api.ICreditScoreService;
import com.bj58.fbu.ark.credit.dto.CreditResponsePkg;
import com.bj58.fbu.ark.credit.dto.in.fico.FicoBankScoreIn;
import com.bj58.fbu.ark.credit.dto.in.fico.FicoXiaoJinScoreIn;
import com.bj58.fbu.ark.credit.dto.out.fico.FicoBankScoreOut;
import com.bj58.fbu.ark.credit.dto.out.fico.FicoXiaoJinScoreOut;
import com.bj58.spat.scf.client.proxy.builder.ProxyFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.scf_init.InitScf;

import java.util.UUID;
/*
 * 接口名称：fico银行分
 * 接口代码：C0281
 * 接口地址：ICreditScoreService.getFicoXiaoJinScore
 * 服务名称：tcp://creditserver/CreditScoreService
 * 测试人员：jpp
 */
public class GetFicoBankScore {
    @BeforeClass
    private void init() {
        InitScf.init();
    }

    private ICreditScoreService iCreditScoreService = ProxyFactory.create(ICreditScoreService.class, "tcp://creditserver/CreditScoreService");
    private String customerCode = "test0001";

    @Test(description = "测试scf正常调用,pboc=0")
    public void test1() throws Exception {
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        String mobile = "15866655511";
        String idCardNo = "110101199001012969";
        String pboc = "0";
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setMobile(mobile);
        ficoBankScoreIn.setIdCardNo(idCardNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);

        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));
        Assert.assertEquals("0000", creditResponsePkg.getCode());
        Assert.assertEquals("请求成功", creditResponsePkg.getMessage(), "scf接口流水号：" + customerSerialNo);
    }

    @Test(description = "测试scf正常调用,pboc=1")
    public void test2() throws Exception {
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        String mobile = "15866655500";
        String idCardNo = "110101199001012963";
        String pboc = "1";
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setMobile(mobile);
        ficoBankScoreIn.setIdCardNo(idCardNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);

        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));
        Assert.assertEquals("0000", creditResponsePkg.getCode());
        Assert.assertEquals("请求成功", creditResponsePkg.getMessage(), "scf接口流水号：" + customerSerialNo);
    }

    @Test(description = "测试scf正常调用,pboc=2")
    public void test3() throws Exception {
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        String mobile = "15866655544";
        String idCardNo = "110101199001012969";
        String pboc = "2";
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setMobile(mobile);
        ficoBankScoreIn.setIdCardNo(idCardNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);

        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));
        Assert.assertEquals("0000", creditResponsePkg.getCode());
        Assert.assertEquals("请求成功", creditResponsePkg.getMessage(), "scf接口流水号：" + customerSerialNo);
    }

    @Test(description = "测试scf入参mobile为空串")
    public void test4 () throws Exception{
        String mobile = "";
        String idCardNo = "110101199001012969";
        String pboc = "0";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为null串")
    public void test5 () throws Exception{
        String mobile = "null";
        String idCardNo = "110101199001012969";
        String pboc = "0";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为 \"     \"串")
    public void test6 () throws Exception{
        String mobile = "   ";
        String idCardNo = "110101199001012969";
        String pboc = "0";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为 158888888 2串")
    public void test7 () throws Exception{
        String mobile = "158888888 2";
        String idCardNo = "110101199001012969";
        String pboc = "0";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为1586666888811,长度大于11")
    public void test8 () throws Exception{
        String mobile = "";
        String idCardNo = "110101199001012969";
        String pboc = "0";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为15866668,长度小于11")
    public void test9 () throws Exception{
        String mobile = "15866668";
        String idCardNo = "110101199001012969";
        String pboc = "0";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为05888888882,0开头")
    public void test10 () throws Exception{
        String mobile = "05888888882";
        String idCardNo = "110101199001012969";
        String pboc = "0";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为158x888x882,带字母")
    public void test11 () throws Exception{
        String mobile = "05888888882";
        String idCardNo = "110101199001012969";
        String pboc = "0";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为158?8882882,带特殊字符")
    public void test12 () throws Exception{
        String mobile = "05888888882";
        String idCardNo = "110101199001012969";
        String pboc = "0";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为null")
    public void test13 () throws Exception{
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        String idCardNo = "110101199001012969";
        String pboc = "0";
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setMobile(null);
        ficoBankScoreIn.setIdCardNo(idCardNo);
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);

        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));
        Assert.assertEquals("9003",creditResponsePkg.getCode(),"scf接口流水号：" + customerSerialNo);
    }

    @Test(description = "测试scf入参mobile不设置")
    public void test14 () throws Exception{
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        String idCardNo = "110101199001012969";
        String pboc = "0";
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setIdCardNo(idCardNo);
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);

        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));
        Assert.assertEquals("9003",creditResponsePkg.getCode(),"scf接口流水号：" + customerSerialNo);
    }

    @Test(description = "测试scf入参idCardNo为空串")
    public void test15 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "";
        String pboc = "1";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参idCardNo为null串")
    public void test16 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "null";
        String pboc = "1";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为 \"     \"串")
    public void test17 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "    ";
        String pboc = "1";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参idCardNo为1101011990010129691111长度大于18")
    public void test18 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "1101011990010129691111";
        String pboc = "1";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参mobile为110101199,长度小于18")
    public void test19 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "110101199";
        String pboc = "1";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参idCardNo为11010119900101274x,最后一个字母小写,正确")
    public void test20 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "11010119900101274x";
        String pboc = "1";
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setMobile(mobile);
        ficoBankScoreIn.setIdCardNo(idCardNo);
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);


        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));
        Assert.assertEquals("0000",creditResponsePkg.getCode());
        Assert.assertEquals("请求成功",creditResponsePkg.getMessage(),"scf接口流水号：" + customerSerialNo);
    }

    @Test(description = "测试scf入参idCardNo为1101011??00%101274X,带特殊字符")
    public void test21 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "1101011??00%101274X";
        String pboc = "1";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参idCardNo为null")
    public void test22 () throws Exception{
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        String mobile = "16822225555";
        String pboc = "1";
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setMobile(mobile);
        ficoBankScoreIn.setIdCardNo(null);
        ficoBankScoreIn.setPboc(pboc);
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);

        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));
        Assert.assertEquals("9003",creditResponsePkg.getCode(),"scf接口流水号：" + customerSerialNo);
    }

    @Test(description = "测试scf入参idCardNo不设置")
    public void test23 () throws Exception{
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        String mobile = "16822225555";
        String pboc = "1";
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setMobile(mobile);
        ficoBankScoreIn.setPboc(pboc);
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);

        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));
        Assert.assertEquals("9003",creditResponsePkg.getCode(),"scf接口流水号：" + customerSerialNo);
    }

    @Test(description = "测试scf入参pboc不设置")
    public void test24 () throws Exception{
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        String mobile = "16822225555";
        String pboc = "1";
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setMobile(mobile);
        ficoBankScoreIn.setIdCardNo(customerSerialNo);
        ficoBankScoreIn.setPboc(null);
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);

        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));
        Assert.assertEquals("9003",creditResponsePkg.getCode(),"scf接口流水号：" + customerSerialNo);
    }

    @Test(description = "测试scf入参pboc设置为null")
    public void test25 () throws Exception{
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        String mobile = "16822225555";
        String pboc = "1";
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setMobile(mobile);
        ficoBankScoreIn.setIdCardNo(customerSerialNo);
        ficoBankScoreIn.setPboc(null);
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);

        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));
        Assert.assertEquals("9003",creditResponsePkg.getCode(),"scf接口流水号：" + customerSerialNo);
    }

    @Test(description = "测试scf入参pboc为null串")
    public void test26 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "1101011??00%101274X";
        String pboc = "null";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参pboc为-1串")
    public void test27 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "1101011??00%101274X";
        String pboc = "-1";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参pboc为5")
    public void test28 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "1101011??00%101274X";
        String pboc = "5";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参pboc大于1位")
    public void test29 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "1101011??00%101274X";
        String pboc = "45";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参pboc带字符")
    public void test30 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "1101011??00%101274X";
        String pboc = "w";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }

    @Test(description = "测试scf入参pboc带特殊字符")
    public void test31 () throws Exception{
        String mobile = "16822225555";
        String idCardNo = "1101011??00%101274X";
        String pboc = "?";
        getFicoBankJinScore(mobile,idCardNo,pboc);
    }


    public void  getFicoBankJinScore(String mobile, String idCardNo,String pboc) throws Exception{
        String customerSerialNo = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
        FicoBankScoreIn ficoBankScoreIn = new FicoBankScoreIn();
        ficoBankScoreIn.setMobile(mobile);
        ficoBankScoreIn.setIdCardNo(idCardNo);
        ficoBankScoreIn.setCustomerCode(customerCode);
        ficoBankScoreIn.setCustomerSerialNo(customerSerialNo);
        ficoBankScoreIn.setPboc(pboc);
        CreditResponsePkg<FicoBankScoreOut> creditResponsePkg = iCreditScoreService.getFicoBankScore(ficoBankScoreIn);
        System.out.println("scf接口返回：" + JSONObject.toJSONString(creditResponsePkg));

        Assert.assertEquals("9003",creditResponsePkg.getCode(),"scf接口流水号：" + customerSerialNo);
    }
}
