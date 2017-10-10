package com.secondhandcar.core.controller;

import com.secondhandcar.core.utils.HttpUtils;
import com.secondhandcar.core.utils.ReturnResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by xiet on 2017/10/10.
 */
public class BaseController {
    protected static String SUCCESS = "SUCCESS";
    protected static String ERROR = "ERROR";

    protected static String REDIRECT = "redirect:";
    protected static String FORWARD = "forward:";

    protected static ReturnResult SUCCESS_TIP = new ReturnResult();

    protected HttpServletRequest getHttpServletRequest() {
        return HttpUtils.getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return HttpUtils.getResponse();
    }

    protected HttpSession getSession() {
        return HttpUtils.getRequest().getSession();
    }

    protected HttpSession getSession(Boolean flag) {
        return HttpUtils.getRequest().getSession(flag);
    }

    protected String getPara(String name) {
        return HttpUtils.getRequest().getParameter(name);
    }

    protected void setAttr(String name, Object value) {
        HttpUtils.getRequest().setAttribute(name, value);
    }

    protected Integer getSystemInvokCount() {
        return (Integer) this.getHttpServletRequest().getServletContext().getAttribute("systemCount");
    }

//    /**
//     * 把service层的分页信息，封装为bootstrap table通用的分页封装
//     */
//    protected <T> PageInfoBT<T> packForBT(Page<T> page) {
//        return new PageInfoBT<T>(page);
//    }
//
//    /**
//     * 包装一个list，让list增加额外属性
//     */
//    protected Object warpObject(BaseControllerWarpper warpper) {
//        return warpper.warp();
//    }

    /**
     * 删除cookie
     */
    protected void deleteCookieByName(String cookieName) {
        Cookie[] cookies = this.getHttpServletRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                Cookie temp = new Cookie(cookie.getName(), "");
                temp.setMaxAge(0);
                this.getHttpServletResponse().addCookie(temp);
            }
        }
    }

//    /**
//     * 返回前台文件流
//     *
//     * @author SecondHandCarAdminshuonan
//     * @date 2017年2月28日 下午2:53:19
//     */
//    protected ResponseEntity<byte[]> renderFile(String fileName, String filePath) {
//        byte[] bytes = FileUtil.toByteArray(filePath);
//        return renderFile(fileName, bytes);
//    }

    /**
     * 返回前台文件流
     *
     * @author SecondHandCarAdminshuonan
     * @date 2017年2月28日 下午2:53:19
     */
    protected ResponseEntity<byte[]> renderFile(String fileName, byte[] fileBytes) {
        String dfileName = null;
        try {
            dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(fileBytes, headers, HttpStatus.CREATED);
    }
}
