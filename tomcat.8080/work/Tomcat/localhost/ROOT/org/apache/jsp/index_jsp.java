/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.15
 * Generated at: 2016-03-20 12:00:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/Users/leedhcf92/jwp-workspace/spring-workspace/2016-01-HUDIWEB-3M/webapp/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1458452614000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Indian Game</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/index.css\">\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<script src=\"lib/jquery-1.12.0.js\"></script>\n");
      out.write("\t<script src=\"lib/handlebars-v4.0.5.js\"></script>\n");
      out.write("\t<div class=\"header\">\n");
      out.write("\t\t<img src=\"/image/indianpoker_logo.png\">\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t");

		Object errorMessage = request.getAttribute("errorMessage");
	
      out.write('\n');
      out.write('\n');
      out.write('	');
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /index.jsp(28,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty errorMessage}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t<div class=\"control-group\">\n");
          out.write("\t\t\t<label class=\"error\"> ");

 	out.println(errorMessage);
 
          out.write("</label>\n");
          out.write("\t\t</div>\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t");

		Object userId = session.getAttribute("userId");
	
      out.write('\n');
      out.write('	');
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\t<div class=\"SignUp-box animated fadeInUp\">\n");
      out.write("\t\t<div class=\"box-header\">\n");
      out.write("\t\t\t<h2>Sign Up</h2>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- <form class=\"form\" action=\"/form_action.jsp\" method=\"post\"> -->\n");
      out.write("\t\t<form class=\"form\" action=\"/users/create\" method=\"post\">\n");
      out.write("\t\t\t<div id=\"signup-container\">\n");
      out.write("\t\t\t\t<div class=\"userId\">\n");
      out.write("\t\t\t\t\t<label for=\"userId\" class=\"required\">UserId</label> </br> <input\n");
      out.write("\t\t\t\t\t\ttype=\"text\" placeholder=\"Input Id\" name=\"userId\" id=\"userId\"></input>\n");
      out.write("\t\t\t\t\t</br>\n");
      out.write("\t\t\t\t\t<button class=\"idConfirm\">아이디 확인</button>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"userPassword\">\n");
      out.write("\t\t\t\t\t<label for=\"userPassword\" class=\"required\">Password</label></br> <input\n");
      out.write("\t\t\t\t\t\ttype=\"password\" placeholder=\"Input Password\" name=\"userPassword\"\n");
      out.write("\t\t\t\t\t\tid=\"userPassword\"></input>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"passwordConfirm\">\n");
      out.write("\t\t\t\t\t<label for=\"passwordConfirm\" class=\"required\">Confirm</label> </br> <input\n");
      out.write("\t\t\t\t\t\ttype=\"password\" placeholder=\"Confirm Password\"\n");
      out.write("\t\t\t\t\t\tname=\"passwordConfirm\" id=\"passwordConfirm\"></input>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"userEmail\">\n");
      out.write("\t\t\t\t\t<label for=\"userEmail\" class=\"required\">email</label> </br> <input\n");
      out.write("\t\t\t\t\t\ttype=\"email\" placeholder=\"Input Email\" name=\"userEmail\"\n");
      out.write("\t\t\t\t\t\tid=\"userEmail\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"signUpSubmit\">\n");
      out.write("\t\t\t\t\t<button type=\"submit\">Sign up</button>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<br />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div class=\"login-box animated fadeInUp\">\n");
      out.write("\t\t<div class=\"box-header\">\n");
      out.write("\t\t\t<h2>LogIn</h2>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<form class=\"form\" action=\"/waitingroom.jsp\" method=\"post\">\n");
      out.write("\t\t\t<div id=\"login-container\">\n");
      out.write("\t\t\t\t<div id=\"id-container\">\n");
      out.write("\t\t\t\t\t<label for=\"userId\">UserId</label> <br /> <input type=\"text\"\n");
      out.write("\t\t\t\t\t\tplaceholder=\"Input Id\" name=\"userId\" id=\"userId\"> <br />\n");
      out.write("\t\t\t\t\t<span class=\"warn\">Please input id</span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t<div id=\"userPassword-container\">\n");
      out.write("\t\t\t\t\t<label for=\"userPassword\">Password</label> <br /> <input\n");
      out.write("\t\t\t\t\t\ttype=\"password\" placeholder=\"Input Password\" name=\"userPassword\"\n");
      out.write("\t\t\t\t\t\tid=\"userPassword\"> <br /> <span class=\"warn\">Please\n");
      out.write("\t\t\t\t\t\tinput password</span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div id=\"loginSubmit\">\n");
      out.write("\t\t\t\t\t<button type=\"submit\">Login</button>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<br />\n");
      out.write("\t\t</form>\n");
      out.write("\t\t<a href=\"#\"><p class=\"small\">Forgot your password?</p></a>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- <script type=\"text/javascript\" src=\"/js/index.js\"></script> -->\n");
      out.write("\t<script>\n");
      out.write("\t\t$(document).ready(function() {\n");
      out.write("\t\t\t$(\"#signUp\").on(\"click\", function() {\n");
      out.write("\t\t\t\t$('.SignUp-box').fadeIn(1000).css('display', 'block');\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t$(\"#login\").on(\"click\", function() {\n");
      out.write("\t\t\t\t$('.login-box').fadeIn(1000).css('display', 'block');\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t/* $(\"#logout\").on(\"click\", function() {\n");
      out.write("\t\t\t\t$('.login-box').fadeIn(1000).css('display', 'block');\n");
      out.write("\t\t\t}); */\n");
      out.write("\t\t\t$('#logo').addClass('animated fadeInDown');\n");
      out.write("\t\t\t$(\"input:text:visible:first\").focus();\n");
      out.write("\t\t});\n");
      out.write("\t\t$('#username').focus(function() {\n");
      out.write("\t\t\t$('label[for=\"username\"]').addClass('selected');\n");
      out.write("\t\t});\n");
      out.write("\t\t$('#username').blur(function() {\n");
      out.write("\t\t\t$('label[for=\"username\"]').removeClass('selected');\n");
      out.write("\t\t});\n");
      out.write("\t\t$('#password').focus(function() {\n");
      out.write("\t\t\t$('label[for=\"password\"]').addClass('selected');\n");
      out.write("\t\t});\n");
      out.write("\t\t$('#password').blur(function() {\n");
      out.write("\t\t\t$('label[for=\"password\"]').removeClass('selected');\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("\t<script src=\"/js/signup.js\"></script>\n");
      out.write("\t<script src=\"/js/login.js\"></script>\n");
      out.write("\t<script src=\"/js/init.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write('\n');
        out.write('	');
        out.write('	');
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write('\n');
        out.write('	');
        out.write('	');
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write('\n');
        out.write('	');
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /index.jsp(41,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty userId}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t<div id=\"logout\">\n");
        out.write("\t\t\t\t<a href=\"/users/logout\">logout</a>\n");
        out.write("\t\t\t</div>\n");
        out.write("\t\t\t<div id=\"make\">\n");
        out.write("\t\t\t\t<a href=\"/play.jsp\">play \n");
        out.write("\t\t\t</div>\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t<div id=\"signUp\">Sign Up</div>\n");
        out.write("\t\t\t<div id=\"login\">Login</div>\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }
}
