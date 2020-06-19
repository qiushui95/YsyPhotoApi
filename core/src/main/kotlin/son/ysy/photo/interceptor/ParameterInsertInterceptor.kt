package son.ysy.photo.interceptor

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import son.ysy.photo.model.request.UserId
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ParameterInsertInterceptor : HandlerInterceptorAdapter() {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (handler is HandlerMethod) {
            val parameterArray = handler.method.parameters
            parameterArray.forEach {
                if (it.type==Page::class.java){
                    handler
                    println()
                }else if (it.type==UserId::class.java){
                    println()
                }
            }
        }
        return super.preHandle(request, response, handler)
    }
}