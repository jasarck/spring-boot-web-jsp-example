package hello;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class RequestHandelrInterceptor implements HandlerInterceptor {

   
    //@Autowired
    private RequestBinder reqBinder;

    //private EmRequest emRequest;

    @Autowired
    RequestHandelrInterceptor(RequestBinder reqBinder) {
        this.reqBinder = reqBinder;
    }

    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
         System.out.println("Pre Handle method is Calling");
        if(request.getHeader("X-authKey") == null){
    		 System.out.println("Inside BAD Request");
            //response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
             return false;
         }
    	 else{
             String authKey=request.getHeader("X-authKey");
             System.out.println("authKey  :"+authKey);
             if(authKey.equals("123")){
                 return true;
             }else{
                 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                 return false;
             }
         }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        /*response.getStatus()
        response.getHeaders()
        response.getContentType()

        response.getOutputStream()

        ServletLoggingFilter.HttpServletResponseCopier copier = (ServletLoggingFilter.HttpServletResponseCopier) response;
        String responseBody = new String(copier.getCopy());*/

        System.out.println("Post Handle method is Calling");
    }
    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response, Object
                    handler, Exception exception) throws Exception {

        System.out.println("Request and Response is completed");
    }
}
