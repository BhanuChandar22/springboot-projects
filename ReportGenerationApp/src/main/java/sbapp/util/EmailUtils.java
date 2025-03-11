package sbapp.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender sender;
	
	boolean flag = false;
 	public boolean sendMail(File file) throws Exception
	{
 		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo("bharatman2002@gmail.com");
		helper.setSubject("Citizens Plan Data");
 		helper.setText("Please download your report");
 		
 		helper.addAttachment(file.getName(), file);
		sender.send(msg);
 		flag = true;
		return flag;
	}
	
}
