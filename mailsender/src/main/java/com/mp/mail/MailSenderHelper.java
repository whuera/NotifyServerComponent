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
		String tipo = null;
		if (args[0] != null){		
			company= !args[0].equalsIgnoreCase(null)?args[0].trim():"default";		
			tipo = !args[1].equals(null)?args[1]:"N/A";
		boolean val = ControllerEmailTemplate.mailSenderHelper(company, tipo);
		System.out.println(val);
		}else{
			System.out.println("MailSender no execute review params!");
			return;
		}

	}

}
