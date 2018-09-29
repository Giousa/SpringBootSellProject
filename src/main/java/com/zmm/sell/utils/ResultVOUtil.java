package com.zmm.sell.utils;

import com.zmm.sell.vo.ResultVO;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/29
 * Email:65489469@qq.com
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();

        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setData(object);

        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();

        resultVO.setCode(code);
        resultVO.setMsg(msg);

        return resultVO;
    }
}
