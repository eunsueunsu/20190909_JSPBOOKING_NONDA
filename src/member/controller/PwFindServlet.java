package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class PwFindServlet
 */
@WebServlet("/PwFindServlet")
public class PwFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PwFindServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String mId = request.getParameter("mId");
		String mName = request.getParameter("mName");
		String mPhone = request.getParameter("mPhone");

		MemberService ms = new MemberService();
		PrintWriter out = response.getWriter();

		int result = ms.pwFind(mId, mName, mPhone);
		
		if(result == 0)
		{
			out.println("<script>alert('가입한 정보가 없습니다.'); history.back();</script>");
			out.close();
		}
		else
		{
			String host = "smtp.naver.com";
			String user = "myalvina@naver.com";
			String password = "nonda123*";

			String to_email = mId;

			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");

			StringBuffer temp =new StringBuffer();
			Random rnd = new Random();
			for(int i=0;i<10;i++)
			{
				int rIndex = rnd.nextInt(3);
				switch (rIndex) {
				case 0:
					temp.append((char) ((int) (rnd.nextInt(26)) + 97));
					break;
				case 1:
					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
					break;
				case 2:
					temp.append((rnd.nextInt(10)));
					break;
				}
			}

			String AuthenticationKey = temp.toString();
			System.out.println(AuthenticationKey);

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});

			try
			{
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(user, "NONDA"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

				msg.setSubject("안녕하세요. NONDA 임시비밀번호 발송 메일입니다.");
				msg.setText("임시비밀번호 : "+ AuthenticationKey);

				Transport.send(msg);

				System.out.println("이메일 전송 완료");
				
				result = ms.pwChange(mId, AuthenticationKey);
				
				if(result > 0)
				{
					out.println("<script>alert('해당 이메일로 임시비밀번호가 발송되었습니다.'); history.back();</script>");
					out.close();
				}

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}