package com.yinhai.hyman.weixin.api.response;

import com.yinhai.hyman.weixin.api.entity.BaseModel;
import com.yinhai.hyman.weixin.api.enums.ResultType;
import com.yinhai.hyman.weixin.util.BeanUtil;
import com.yinhai.hyman.weixin.util.StrUtil;

/**
 * 微信API响应报文对象基类
 *
 * @author peiyu
 */
public class BaseResponse extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errcode;
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        String result = this.errmsg;
        //将接口返回的错误信息转换成中文，方便提示用户出错原因
        if (StrUtil.isNotBlank(this.errcode) && !ResultType.SUCCESS.getCode().toString().equals(this.errcode)) {
            ResultType resultType = ResultType.get(this.errcode);
            if(BeanUtil.nonNull(resultType)) {
                result = resultType.getDescription();
            }
        }
        return result;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
