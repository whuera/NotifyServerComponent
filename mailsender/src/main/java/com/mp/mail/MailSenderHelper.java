package com.mp.mail;


/**
 * The Class MailSenderHelper.
 */
public class MailSenderHelper {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String company = null;
		
		if (args[0] != null){		
			company= !args[0].equalsIgnoreCase(null)?args[0].trim():"default";		
		SpringEmailTemplateExample.mailSenderHelper(company);
		}else{
			System.out.println("MailSender no execute review params!");
			return;
		}

	}

}
