package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestHomework0126
 */
@WebServlet("/TestHomework0126")
public class TestHomework0126 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String account;
	private String password;
	String inputAccount;
	String inputPassword;
    String message;
    String jumpPage;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestHomework0126() {
        super();
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Always call super.init
	    super.init(config);
	    password = config.getInitParameter("password");
	    account = config.getInitParameter("account");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter webOut = response.getWriter();
		
		inputAccount = request.getParameter("account");
		inputPassword = request.getParameter("password");
		
		boolean rightCondition = true;
		
		if(inputAccount == null || inputAccount.equals("")) {
			message = "   <h1>帳號不可為空白！5秒後回到登入畫面...</h1>";
			rightCondition = false;
		}
		else if(inputPassword == null || inputPassword.equals("")) {
			message = "   <h1>密碼不可為空白！5秒後回到登入畫面...</h1>";
			rightCondition = false;
		}
		else {
			if(inputAccount.equals(account) && inputPassword.equals(password)) {
				message = "   <h1>驗證成功！</h1>  <h1>您的帳號為：" + account + "，密碼為：" + password + "</h1>";
			}
			else if(inputAccount.equals(account) && !inputPassword.equals(password)) {
				message = "   <h1>您的密碼輸入錯誤！5秒後回到登入畫面...</h1>";
				rightCondition = false;
			}
			else if(!inputAccount.equals(account) && inputPassword.equals(password)) {
				message = "   <h1>您的帳號輸入錯誤！5秒後回到登入畫面...</h1>";
				rightCondition = false;
			}
			else {
				message = "   <h1>您的帳號及密碼輸入錯誤！5秒後回到登入畫面...</h1>";
				rightCondition = false;
			}
		}
		
		jumpPage = (!rightCondition) ? "  <meta http-equiv=\"Refresh\" content=\"5;url=testForm.html\" />" : "";
		
		webOut.println(
				"<!--DOCTYPE宣告-->" + System.lineSeparator() + 
				"<!DOCTYPE html>" + System.lineSeparator() +
				"<!--語言宣告、HTML開始-->" + System.lineSeparator() +
				"<html lang=\"zh-Hant-TW\">" + System.lineSeparator() + 
				"<!--head開始-->" + System.lineSeparator() +
				"" +
				"<head>" + System.lineSeparator() +
				"    <meta charset=\"UTF-8\">" + System.lineSeparator() +
				"    <!--網頁寬度等寬於裝置寬度-->" + System.lineSeparator() +
				"   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" + System.lineSeparator() +
			    "   <title>HTML TEST</title>" + System.lineSeparator() +
				"   <meta name=\"author\" content=\"George\" />" + System.lineSeparator() + 
				"   <meta name=\"date\" content=\"2020-10-30\" />" + System.lineSeparator() +
				"   <meta name=\"generator\" content=\"Microsoft Visual Studio Code&Eclipse\">" + System.lineSeparator() +
				jumpPage + System.lineSeparator() + 
				"   <style>" + System.lineSeparator() +
				"   .container {" + System.lineSeparator() +
				"       margin-top: 20px;" + System.lineSeparator() +
				"       margin-left: auto;" + System.lineSeparator() +
				"       margin-right: auto;" + System.lineSeparator() +
				"       width: 800px;" + System.lineSeparator() +
				"       display: block;" + System.lineSeparator() +
				"   }" + System.lineSeparator() + 
				"  </style>" + System.lineSeparator() + 
				"</head>" + System.lineSeparator() +
				"" + System.lineSeparator() + 
				"<!--body開始-->" + System.lineSeparator() +
				"" + System.lineSeparator() + 
				"<body>" + System.lineSeparator() +
				"  <div class = \"container\">" +System.lineSeparator() +
				"    "+message + System.lineSeparator() +  
				"  </div>" + System.lineSeparator() +
				"</body>" + System.lineSeparator() +
				"<!--body結束-->" + System.lineSeparator() + 
				"</html>" + System.lineSeparator() +
				"<!--HTML結束-->");
		
		webOut.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
