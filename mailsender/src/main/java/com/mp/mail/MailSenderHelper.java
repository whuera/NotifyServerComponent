package com.mp.mail;

// TODO: Auto-generated Javadoc
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
		if (args[0].equalsIgnoreCase("-receptor") && !args[1].equalsIgnoreCase(null) && !args[2].equalsIgnoreCase(null)){
			String mailRecord = !args[1].equalsIgnoreCase(null)?args[1].trim():"eduardohuera@gmail.com";
			company=!args[2].equalsIgnoreCase(null)?args[2].trim():"default";
		SpringEmailTemplateExample.mailSenderHelper(mailRecord,company );
		}else{
			System.out.println("MailSender no execute review params!");
			return;
		}

	}

}
