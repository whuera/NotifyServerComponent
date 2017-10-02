package com.mp.mail;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.conn.conexionOracle;
import com.app.modelo.ContactMail;
import com.app.service.impl.ServiceContactSendMail;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringEmailTemplateExample.
 */
public class SpringEmailTemplateExample {
	
	/**
	 * Mail sender helper.
	 *
	 * @param mailReceptor the mail receptor
	 * @param company the company
	 */
	//@Autowired
	//private static conexionOracle conn;
	//@Autowired
	//private static ServiceContactSendMail serviceContactSendMail;
	
	public static void mailSenderHelper(String mailReceptor, String company)
	{
		String flgTemplate = "emailtemplate.vm";
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		Mailer mailer = (Mailer) context.getBean("mailer");

		ServiceContactSendMail serviceContactSendMail = new ServiceContactSendMail();
		
		//Contacto contacto = new Contacto();
		ArrayList<ContactMail> listContacto = new ArrayList<ContactMail>();
		listContacto = serviceContactSendMail.getContacts();
/*
		contacto.setPrimerNombre("William");
		contacto.setPrimerApellido("Huera");
		contacto.setMailContacto("whuera@gmail.com");

		listContacto.add(contacto);

		Contacto contacto2 = new Contacto();
		contacto2.setPrimerNombre("Usuario");
		contacto2.setPrimerApellido("del Sistema Mobilpymes");
		
		if(mailReceptor!=null){
		contacto2.setMailContacto(mailReceptor);
		}else{
			contacto2.setMailContacto("eduardohuera@gmail.com");
		}
			
		//listContacto.add(contacto2);
		
		*/

		Mail mail = new Mail();
		/*
		mail.setMailFrom("publicidadmobilpymes@gmail.com");
		mail.setMailBcc("whuera@gmail.com");
		mail.setMailTo("freddy.lojan@etafashion.com");
		mail.setMailSubject("Promociones Mobilpymes.com");
		mail.setTemplateName("emailtemplate.vm");
		*/
		//flgTemplate = company.equalsIgnoreCase("aireec")?"emailtemplateaire.vm":"emailtemplate.vm";
		if (company.equalsIgnoreCase("aireec"))
		{
			flgTemplate = "emailtemplateaire.vm";
		}else if(company.equalsIgnoreCase("smartbid"))
		{
			flgTemplate = "emailtemplatesmartbid.vm";
		}else if (company.equalsIgnoreCase("mobilpymescloud")){
			flgTemplate = "emailtemplateservicemanager.vm";
		}else if (company.equalsIgnoreCase("mobilpymes")){
			flgTemplate = "emailtemplate.vm";
		}
		
		for (ContactMail contactoFinal : listContacto) {
			mail.setMailFrom("info@mobilpymes.com");
			mail.setMailTo(contactoFinal.getEmailcontact());
			//mail.setMailTo("whuera@gmail.com");
			mail.setMailSubject("Sistema Data+ (Micro Buro de Información y relación comercial) "+company);
			mail.setTemplateName(flgTemplate);
			try {
				mailer.sendMail(mail, contactoFinal.getNames(), "");
				serviceContactSendMail.updateStatusMail(contactoFinal.getId());
			} catch (ResourceNotFoundException e) {

				e.printStackTrace();
			} catch (ParseErrorException e) {

				e.printStackTrace();
			} catch (MethodInvocationException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
			contactoFinal = null;
		}

		
	}
	/*

	public static void main(String[] args) {
		// conn = new conexionOracle();
		if (args[0].equalsIgnoreCase("-receptor") && !args[1].equalsIgnoreCase(null)){
			String mailRecord = !args[1].equalsIgnoreCase(null)?args[1].trim():"eduardohuera@gmail.com";
		SpringEmailTemplateExample.mailSenderHelper(mailRecord);
		}
	}
*/
}
