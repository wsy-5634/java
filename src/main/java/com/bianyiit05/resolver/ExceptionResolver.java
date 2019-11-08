package com.bianyiit05.resolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*异常处理组件
* 需要拿到异常自己处理时，用try/catch。
* 无需处理时，就从DAO层往上抛，抛到web层，同意跳转到和谐页面
*/
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg",e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
