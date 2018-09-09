package com.xyl.personalincometax.response;

public class Results {
    /**
     * 成功
     * @param data
     * @return
     */
    public static Result success(Object data){
        Result result=new Result();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(data);
        return result;
    }

    /**
     * 成功
     * @return
     */
    public static Result success(){
        Result result=new Result();
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    /**
     * 失败
     * @param message
     * @return
     */
    public static Result fail(String message){
        Result result=new Result();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }

}
