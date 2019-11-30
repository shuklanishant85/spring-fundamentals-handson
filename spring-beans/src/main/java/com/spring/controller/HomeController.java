package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.beans.MyAnnotatedBean;
import com.spring.beans.MyBean;

/**
 * Handles requests for the application home page.
 */
@Controller
@Scope("request")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private MyBean myBean;
	
	private MyAnnotatedBean myAnnotatedBean;

	/**
	 * @param myBean the myBean to set
	 */
	@Autowired
	public void setMyBean(MyBean myBean) {
		this.myBean = myBean;
	}

	/**
	 * @param myAnnotatedBean the myAnnotatedBean to set
	 */
	@Autowired
	public void setMyAnnotatedBean(MyAnnotatedBean myAnnotatedBean) {
		this.myAnnotatedBean = myAnnotatedBean;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		System.out.println("My Bean Hashcode = "+myBean.hashCode());
		System.out.println("My Annotated Bean Hashcode = "+myAnnotatedBean.hashCode());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

}
