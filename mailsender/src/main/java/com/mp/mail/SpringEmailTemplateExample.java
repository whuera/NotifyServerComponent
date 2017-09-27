package com.mp.mail;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	@Autowired
	//private static conexionOracle conn;
	// @Autowired
	// private static Contacto contacto;
	
	public static void mailSenderHelper(String mailReceptor, String company)
	{
		String flgTemplate = "emailtemplate.vm";
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		Mailer mailer = (Mailer) context.getBean("mailer");

		// conn = new conexionOracle();
		// conn.getConnection();
		Contacto contacto = new Contacto();
		ArrayList<Contacto> listContacto = new ArrayList<Contacto>();

		contacto.setPrimerNombre("William");
		contacto.setPrimerApellido("Huera");
		contacto.setMailContacto("whuera@gmail.com");

		listContacto.add(contacto);

		Contacto contacto2 = new Contacto();
		contacto2.setPrimerNombre("Usuario");
		contacto2.setPrimerApellido("del Sistema SmartBid.ec");
		
		if(mailReceptor!=null){
		contacto2.setMailContacto(mailReceptor);
		}else{
			contacto2.setMailContacto("eduardohuera@gmail.com");
		}
			
		listContacto.add(contacto2);
		
		

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
		}
		
		for (Contacto contactoFinal : listContacto) {
			mail.setMailFrom("monitoreoinfraestructura.levelap@gmail.com");
			mail.setMailTo(contactoFinal.getMailContacto());
			mail.setMailSubject("Monitoreo "+company);
			mail.setTemplateName(flgTemplate);
			try {
				mailer.sendMail(mail, contactoFinal.getPrimerNombre(), contactoFinal.getPrimerApellido());
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
