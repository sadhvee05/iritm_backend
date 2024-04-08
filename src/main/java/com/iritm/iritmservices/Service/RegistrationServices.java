package com.iritm.iritmservices.Service;

import java.io.UnsupportedEncodingException;

import com.iritm.iritmservices.Entity.Registration;

import jakarta.mail.MessagingException;

public interface RegistrationServices {
	String addregistration(Registration registration);
	
	void register(Registration registration, String siteURL) throws UnsupportedEncodingException, MessagingException;
}
