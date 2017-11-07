package com.mp.mail;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Mail.
 */
public class Mail {
	
	/** The mail from. */
	private String mailFrom;

	 /** The mail to. */
 	private String mailTo;

	 /** The mail cc. */
 	private String mailCc;

	 /** The mail bcc. */
 	private String mailBcc;

	 /** The mail subject. */
 	private String mailSubject;

	 /** The mail content. */
 	private String mailContent;

	 /** The template name. */
 	private String templateName;

	 /** The content type. */
 	private String contentType;
 	
 	private String pathFileAttach;
 	

	 public String getPathFileAttach() {
		return pathFileAttach;
	}

	public void setPathFileAttach(String pathFileAttach) {
		this.pathFileAttach = pathFileAttach;
	}

	/**
 	 * Instantiates a new mail.
 	 */
 	public Mail() {
	  contentType = "text/html";
	 }

	 /**
 	 * Gets the content type.
 	 *
 	 * @return the content type
 	 */
 	public String getContentType() {
	  return contentType;
	 }

	 /**
 	 * Sets the content type.
 	 *
 	 * @param contentType the new content type
 	 */
 	public void setContentType(String contentType) {
	  this.contentType = contentType;
	 }

	 /**
 	 * Gets the mail bcc.
 	 *
 	 * @return the mail bcc
 	 */
 	public String getMailBcc() {
	  return mailBcc;
	 }

	 /**
 	 * Gets the template name.
 	 *
 	 * @return the template name
 	 */
 	public String getTemplateName() {
	  return templateName;
	 }

	 /**
 	 * Sets the template name.
 	 *
 	 * @param templateName the new template name
 	 */
 	public void setTemplateName(String templateName) {
	  this.templateName = templateName;
	 }

	 /**
 	 * Sets the mail bcc.
 	 *
 	 * @param mailBcc the new mail bcc
 	 */
 	public void setMailBcc(String mailBcc) {
	  this.mailBcc = mailBcc;
	 }

	 /**
 	 * Gets the mail cc.
 	 *
 	 * @return the mail cc
 	 */
 	public String getMailCc() {
	  return mailCc;
	 }

	 /**
 	 * Sets the mail cc.
 	 *
 	 * @param mailCc the new mail cc
 	 */
 	public void setMailCc(String mailCc) {
	  this.mailCc = mailCc;
	 }

	 /**
 	 * Gets the mail from.
 	 *
 	 * @return the mail from
 	 */
 	public String getMailFrom() {
	  return mailFrom;
	 }

	 /**
 	 * Sets the mail from.
 	 *
 	 * @param mailFrom the new mail from
 	 */
 	public void setMailFrom(String mailFrom) {
	  this.mailFrom = mailFrom;
	 }

	 /**
 	 * Gets the mail subject.
 	 *
 	 * @return the mail subject
 	 */
 	public String getMailSubject() {
	  return mailSubject;
	 }

	 /**
 	 * Sets the mail subject.
 	 *
 	 * @param mailSubject the new mail subject
 	 */
 	public void setMailSubject(String mailSubject) {
	  this.mailSubject = mailSubject;
	 }

	 /**
 	 * Gets the mail to.
 	 *
 	 * @return the mail to
 	 */
 	public String getMailTo() {
	  return mailTo;
	 }

	 /**
 	 * Sets the mail to.
 	 *
 	 * @param mailTo the new mail to
 	 */
 	public void setMailTo(String mailTo) {
	  this.mailTo = mailTo;
	 }

	 /**
 	 * Gets the mail send date.
 	 *
 	 * @return the mail send date
 	 */
 	public Date getMailSendDate() {
	  return new Date();
	 }

	 /**
 	 * Gets the mail content.
 	 *
 	 * @return the mail content
 	 */
 	public String getMailContent() {
	  return mailContent;
	 }

	 /**
 	 * Sets the mail content.
 	 *
 	 * @param mailContent the new mail content
 	 */
 	public void setMailContent(String mailContent) {
	  this.mailContent = mailContent;
	 }

	 /* (non-Javadoc)
 	 * @see java.lang.Object#toString()
 	 */
 	@Override
	 public String toString() {
	  StringBuilder lBuilder = new StringBuilder();
	  lBuilder.append("Mail From:- ").append(getMailFrom());
	  lBuilder.append("Mail To:- ").append(getMailTo());
	  lBuilder.append("Mail Cc:- ").append(getMailCc());
	  lBuilder.append("Mail Bcc:- ").append(getMailBcc());
	  lBuilder.append("Mail Subject:- ").append(getMailSubject());
	  lBuilder.append("Mail Send Date:- ").append(getMailSendDate());
	  lBuilder.append("Mail Content:- ").append(getMailContent());
	  return lBuilder.toString();
	 }

}
