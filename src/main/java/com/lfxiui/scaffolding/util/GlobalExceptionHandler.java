package com.lfxiui.scaffolding.util;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 全局异常捕捉处理
 *
 * @author lfxiui
 * @date 2018/2/28 0028 16:58
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 密码错误
     *
     * @param e 用户密码错误异常
     * @return 返回密码或账号错误信息
     */
    @ExceptionHandler(IncorrectCredentialsException.class)
    @ResponseBody
    public JsonFormat incorrectCredentialsExceptionHandler(IncorrectCredentialsException e) {
        return ReturnUtil.getResult(1012, null);
    }

    /**
     * 账号异常
     *
     * @param e 用户不存在
     * @return 返回密码或账号错误信息
     */
    @ExceptionHandler(UnknownAccountException.class)
    @ResponseBody
    public JsonFormat unknownAccountExceptionHandler(UnknownAccountException e) {
        return ReturnUtil.getResult(1012, null);
    }

    /**
     * 用户验证异常
     *
     * @param e 登陆验证失败
     * @return 返回登陆失败信息
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public JsonFormat authenticationExceptionHandler(AuthenticationException e) {
        return ReturnUtil.getResult(1015, null);
    }

    /**
     * 运行时异常
     *
     * @param runtimeException 运行时异常，控制台抛出
     * @return 1000
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonFormat runtimeExceptionHandler(RuntimeException runtimeException) {
        runtimeException.printStackTrace();
        return ReturnUtil.getResult(1000, null);
    }

    /**
     * 空指针异常
     *
     * @param ex 空指针
     * @return 1001
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public JsonFormat nullPointerExceptionHandler(NullPointerException ex) {
        ex.printStackTrace();
        return ReturnUtil.getResult(1001, null);
    }

    /**
     * 类型转换异常
     *
     * @param ex
     * @return 1002
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public JsonFormat classCastExceptionHandler(ClassCastException ex) {
        ex.printStackTrace();
        return ReturnUtil.getResult(1002, null);
    }

    /**
     * IO异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public JsonFormat iOExceptionHandler(IOException ex) {
        ex.printStackTrace();
        return ReturnUtil.getResult(1003, null);
    }

    /**
     * 未知方法异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public JsonFormat noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        ex.printStackTrace();
        return ReturnUtil.getResult(1004, null);
    }

    /**
     * 数组越界异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public JsonFormat indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        ex.printStackTrace();
        return ReturnUtil.getResult(1005, null);
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public JsonFormat requestNotReadable(HttpMessageNotReadableException ex) {
        System.out.println("400..requestNotReadable");
        ex.printStackTrace();
        return ReturnUtil.getResult(400, null);
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public JsonFormat requestTypeMismatch(TypeMismatchException ex) {
        System.out.println("400..TypeMismatchException");
        ex.printStackTrace();
        return ReturnUtil.getResult(400, null);
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public JsonFormat requestMissingServletRequest(MissingServletRequestParameterException ex) {
        System.out.println("400..MissingServletRequest");
        ex.printStackTrace();
        return ReturnUtil.getResult(400, null);
    }

    /**
     * 405错误
     *
     * @return
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public JsonFormat request405() {
        System.out.println("405...");
        return ReturnUtil.getResult(405, null);
    }

    /**
     * 406错误
     *
     * @return
     */
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public JsonFormat request406() {
        System.out.println("406...");
        return ReturnUtil.getResult(406, null);
    }

    /**
     * 500错误
     *
     * @param runtimeException
     * @return
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseBody
    public JsonFormat server500(RuntimeException runtimeException) {
        System.out.println("500...");
        return ReturnUtil.getResult(500, null);
    }

    /**
     * 所有异常报错
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonFormat allExceptionHandler(HttpServletRequest request,
                                          Exception exception) throws Exception {
        exception.printStackTrace();
        return ReturnUtil.getResult(0, null);
    }
}
