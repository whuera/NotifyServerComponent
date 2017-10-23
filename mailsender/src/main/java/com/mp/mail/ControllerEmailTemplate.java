package com.mp.mail;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.modelo.ContactMail;
import com.app.modelo.InfoEnterprice;
import com.app.service.impl.ServiceContactSendMail;
import com.app.service.impl.ServiceInfoEnterprice;

/**
 * The Class SpringEmailTemplateExample.
 */
public class ControllerEmailTemplate {

	/**
	 * Mail sender helper.
	 *
	 * @param mailReceptor
	 *            the mail receptor
	 * @param company
	 *            the company
	 */

	public static void mailSenderHelper(String company) {
		String flgTemplate = "emailtemplate.vm";
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		System.setProperty("host", "smtpout.secureserver.net");
		System.setProperty("port", "465");
		System.setProperty("username", "it-services@mobilpymes.cloud");
		System.setProperty("password", "*weho7755*");
		((AbstractRefreshableConfigApplicationContext) context).setConfigLocation("spring-beans.xml");
		((AbstractApplicationContext) context).refresh();

		Mailer mailer = (Mailer) context.getBean("mailer");

		ServiceContactSendMail serviceContactSendMail = new ServiceContactSendMail();
		ServiceInfoEnterprice serviceInfoEmp = new ServiceInfoEnterprice();
		InfoEnterprice infoEnterprice = serviceInfoEmp.getInfoEnterprice(company);
		ArrayList<ContactMail> listContacto = new ArrayList<ContactMail>();

		boolean valCompany = true;
		if (!company.equalsIgnoreCase("DUMMY")) {
			listContacto = serviceContactSendMail.getContacts(infoEnterprice.getOccurrences());
		} else if (company.equalsIgnoreCase("DUMMY")) {
			ContactMail dummyMail = new ContactMail();
			dummyMail.setId(10213);
			dummyMail.setEmailcontact("whuera@gmail.com");
			dummyMail.setNames("William Huera");
			listContacto.add(dummyMail);
			valCompany = false;
		}

		Mail mail = new Mail();

		flgTemplate = infoEnterprice.getNameTemplate();

		for (ContactMail contactoFinal : listContacto) {
			mail.setMailFrom(infoEnterprice.getEmpemail());
			mail.setMailTo(contactoFinal.getEmailcontact());

			mail.setMailSubject(infoEnterprice.getEmailSubject());
			mail.setTemplateName(flgTemplate);
			try {
				mailer.sendMail(mail, contactoFinal.getNames(), "");
				if (valCompany) {
					serviceContactSendMail.updateStatusMail(contactoFinal.getId());
				}
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

}
