package com.iritm.iritmservices.ServiceImpl;



import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.iritm.iritmservices.Entity.Registration;
import com.iritm.iritmservices.Repo.RegistrationRepo;
import com.iritm.iritmservices.Service.RegistrationServices;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class RegistrationImpl implements RegistrationServices {
	@Autowired
	RegistrationRepo registrationRepo;
	@Autowired
	private EmailSender emailService;
	 @Autowired
	    private JavaMailSender mailSender;
	@Override
	public String addregistration(Registration registration)   
	{
		String message="";
	try {
		 Set<Integer> digits = new HashSet<>();
	        Random random = new Random();
            while (digits.size() < 4) {
	            int digit = random.nextInt(10); 
	            digits.add(digit);
	        }
           StringBuilder result = new StringBuilder();
	       
	        for (int digit : digits) {
	            result.append(digit);
	        }
	        int i=0;
	        String userid = (String)registration.getName(); 
	        String userid1 =  userid.substring(Math.max(0, userid.length() - 2));
	        registration.setUserid(userid1.concat(result.toString()).trim());   
	        registration.setPassword(result.toString());
	        registration.setRolename("user");
		     registrationRepo.save(registration);
		    
		    message="Your registration has been successful! Your user ID is "+registration.getUserid()+" and your password is "+registration.getPassword()+" ";
	        emailService.sendEmail("hpewebdev@gmail.com", "Your registration has been successful!!",message );
	
	}
	catch(Exception ex)
	{
		ex.getMessage();
		message="Please contact to Administration ";
	}
		    return message;
	}

	public void register(Registration registration, String siteURL)
	        throws UnsupportedEncodingException, MessagingException {
		 Set<Integer> digits = new HashSet<>();
	        Random random = new Random();
         while (digits.size() < 4) {
	            int digit = random.nextInt(10); 
	            digits.add(digit);
	        }
        StringBuilder result = new StringBuilder();
	       
	        for (int digit : digits) {
	            result.append(digit);
	        }
		String userid = (String)registration.getName(); 
        String userid1 =  userid.substring(Math.max(0, userid.length() - 2));
        registration.setUserid(userid1.concat(result.toString()).trim());   
        registration.setPassword(result.toString());
        
        
        int leftLimit = 48; 
        int rightLimit = 122; 
        int targetStringLength = 10;
        Random random1 = new Random();

        String generatedString = random1.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
        registration.setVerificationcode(generatedString);;
        registration.setEnabled(false);
        registrationRepo.save(registration);
	    sendVerificationEmail(registration, siteURL);
	}
	
	private void sendVerificationEmail(Registration registration, String siteURL)
	        throws MessagingException, UnsupportedEncodingException {
		    String content = "Dear [[name]],<br>"
	            + "Please click the link below to verify your registration:<br>"
	            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
	            + "Thank you,<br>"
	            + "Your company name.";
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    content = content.replace("[[name]]", registration.getName());
	    String verifyURL = siteURL + "/verify?code=" + registration.getVerificationcode();
	    content = content.replace("[[URL]]", verifyURL);
	    helper.setText(content, true);
	    emailService.sendEmail("hpewebdev@gmail.com", "Please verify your registration",content );
	  }
	       
	
	
	
}
