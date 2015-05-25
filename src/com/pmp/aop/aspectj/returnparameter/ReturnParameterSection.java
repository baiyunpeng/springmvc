package com.pmp.aop.aspectj.returnparameter;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.pmp.common.RText;
import com.pmp.common.WebUtils;
import com.pmp.constant.GlobalConstant;

/**
 * 返回值aop 对返回值进行切面
 * 
 * @author Administrator
 * 
 */
@Aspect
@Component
public class ReturnParameterSection {

	@AfterReturning(value = "execution(* com.pmp.controller..*.*(..))", returning = "rtv")
	public void returnParameter(JoinPoint jp, Object rtv) {
		if(rtv instanceof ModelAndView){
			ModelAndView mov = (ModelAndView) rtv;
			if(RText.isEmpty(mov.getViewName())){
				String nameSpace = getWebNameSpase(jp);
				if(!RText.isEmpty(nameSpace)){
					mov.setViewName(nameSpace);
				}else{
					
				}
			}
		}
		

	}

	/**
	 * 得到Web jsp路径
	 *  url寻址模式 url路径和jsp位置一致
	 * @param jp
	 * @return
	 */
	public String getWebNameSpase(JoinPoint jp) {
		Object[] objectArray = jp.getArgs();
		// 命名空间 得到jsp路径
		String nameSpace = "";
		if (GlobalConstant.Global_Return_Parameter_Type_Url
				.equals(GlobalConstant.Global_Return_Parameter_Type)) {
			HttpServletRequest request = (HttpServletRequest) objectArray[0];
			nameSpace = WebUtils.getWebNameSpace(request);
			// class 寻址模式 包名的命名空间+方法名和jsp位置一致
		} else if (GlobalConstant.Global_Return_Parameter_Type_Class
				.equals(GlobalConstant.Global_Return_Parameter_Type)) {
			String className = jp.getSignature().getDeclaringTypeName();
			String methodName = jp.getSignature().getName();
			nameSpace = RText.getControllerNameSpace(className, methodName);
			// 注解寻址模式 注解的路径和jsp对应的路径一致
		} else if (GlobalConstant.Global_Return_Parameter_Type_Annotation
				.equals(GlobalConstant.Global_Return_Parameter_Type)) {

		}
		return nameSpace;
	}
}
