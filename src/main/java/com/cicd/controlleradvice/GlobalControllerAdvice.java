package com.cicd.controlleradvice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局控制器增强示例
 * 展示@ControllerAdvice的主要用法
 */
@ControllerAdvice(
        // 指定只对特定包下的控制器生效
        basePackages = "com.cicd.controller",
        // 也可以指定特定注解的控制器生效
        annotations = RestController.class
)
public class GlobalControllerAdvice {

    /**
     * 用法1：全局异常处理
     * 处理特定异常（如空指针异常）
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Map<String, Object> handleNullPointerException(NullPointerException e) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 500);
        result.put("message", "发生空指针异常：" + e.getMessage());
        result.put("success", false);
        return result;
    }

    /**
     * 用法1扩展：处理多个异常
     * 可以同时处理多种异常类型
     */
    @ExceptionHandler({IllegalArgumentException.class, IndexOutOfBoundsException.class})
    @ResponseBody
    public Map<String, Object> handleIllegalArgumentExceptions(Exception e) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("message", "参数异常：" + e.getMessage());
        result.put("success", false);
        return result;
    }

    /**
     * 用法1扩展：处理所有未捕获的异常
     * 作为全局异常的最终处理器
     */
    @ExceptionHandler(Exception.class)
    public String handleAllException(Exception e, Model model) {
        // 可以返回错误页面（适用于非REST场景）
        model.addAttribute("errorMsg", "系统异常：" + e.getMessage());
        return "error"; // 跳转到error.html视图
    }
//
//    /**
//     * 用法2：全局数据绑定
//     * 所有控制器方法都能获取到这个全局数据
//     */
//    @ModelAttribute
//    public void addGlobalAttributes(Model model) {
//        model.addAttribute("systemName", "示例系统");
//        model.addAttribute("currentVersion", "v1.0.0");
//    }
//
//    /**
//     * 用法2扩展：带返回值的全局数据绑定
//     * 返回的对象会自动添加到模型中，key为返回类型的首字母小写
//     */
//    @ModelAttribute("globalConfig")
//    public Map<String, String> getGlobalConfig() {
//        Map<String, String> config = new HashMap<>();
//        config.put("author", "编程助手");
//        config.put("copyright", "2025");
//        return config;
//    }
//
//    /**
//     * 用法3：全局请求参数预处理
//     * 对请求参数进行统一处理（如日期格式化、属性绑定等）
//     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        // 可以注册自定义编辑器，比如日期格式化
//        // binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//
//        // 设置不允许绑定的字段（防止表单提交恶意字段）
//        binder.setDisallowedFields("password", "secret");
//    }
//
//    /**
//     * 用法3扩展：针对特定控制器的参数处理
//     * 通过value指定控制器类，只对该类生效
//     */
//    @InitBinder("userController")
//    public void initUserBinder(WebDataBinder binder) {
//        // 只对UserController的参数生效的绑定规则
//        binder.setAllowedFields("username", "email", "age");
//    }
//
//
//    /**
//     * 用法5：全局请求前处理（结合@ModelAttribute的高级用法）
//     * 可以获取当前请求的处理器方法信息
//     */
//    @ModelAttribute
//    public void logRequestInfo(HandlerMethod handlerMethod, Model model) {
//        // 记录当前请求的控制器和方法名
//        String controllerName = handlerMethod.getBeanType().getSimpleName();
//        String methodName = handlerMethod.getMethod().getName();
//        model.addAttribute("currentRequest", controllerName + "." + methodName);
//    }
}
