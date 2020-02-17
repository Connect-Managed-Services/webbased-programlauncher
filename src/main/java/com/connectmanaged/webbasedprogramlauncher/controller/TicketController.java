package com.connectmanaged.webbasedprogramlauncher.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.connectmanaged.webbasedprogramlauncher.configuration.CriticalTicketPropertConfig;
import com.connectmanaged.webbasedprogramlauncher.configuration.HighTicketPropertyConfig;
import com.connectmanaged.webbasedprogramlauncher.configuration.LowTicketPropertyConfig;
import com.connectmanaged.webbasedprogramlauncher.configuration.MediumTicketPropertyConfig;
import com.connectmanaged.webbasedprogramlauncher.services.TicketService;

/**
 * @author gaurav
 *
 */
@Controller
public class TicketController {
	private static final Logger logger = LogManager.getLogger(TicketController.class);

	@Autowired
	private CriticalTicketPropertConfig criticalTicketPropertConfig;

	@Autowired
	private HighTicketPropertyConfig highTicketPropertyConfig;

	@Autowired
	private MediumTicketPropertyConfig mediumTicketPropertyConfig;

	@Autowired
	private LowTicketPropertyConfig lowTicketPropertyConfig;

	@Autowired
	private TicketService ticketService;

	@Value("${app.version}")
	private String appVersion;

	/**
	 * @param model
	 * @return first jsp page load in UI with task name
	 */
	 @GetMapping("/")
	public String welcome(Model model) {
		
		System.out.println("Check value in controller :"+criticalTicketPropertConfig.getTaskname());

		model.addAttribute("p1taskname", criticalTicketPropertConfig.getTaskname().replaceAll("[^a-zA-Z0-9]", ""));
		model.addAttribute("p1tagname", criticalTicketPropertConfig.getTagname());
		model.addAttribute("p1description", criticalTicketPropertConfig.getDescription());
		model.addAttribute("p1header", criticalTicketPropertConfig.getHeader());

		model.addAttribute("p2taskname", highTicketPropertyConfig.getTaskname().replaceAll("[^a-zA-Z0-9]", ""));
		model.addAttribute("p2tagname", highTicketPropertyConfig.getTagname());
		model.addAttribute("p2description", highTicketPropertyConfig.getDescription());
		model.addAttribute("p2header", highTicketPropertyConfig.getHeader());

		model.addAttribute("p3taskname", mediumTicketPropertyConfig.getTaskname().replaceAll("[^a-zA-Z0-9]", ""));
		model.addAttribute("p3tagname", mediumTicketPropertyConfig.getTagname());
		model.addAttribute("p3description", mediumTicketPropertyConfig.getDescription());
		model.addAttribute("p3header", mediumTicketPropertyConfig.getHeader());

		model.addAttribute("p4taskname", lowTicketPropertyConfig.getTaskname().replaceAll("[^a-zA-Z0-9]", ""));
		model.addAttribute("p4tagname", lowTicketPropertyConfig.getTagname());
		model.addAttribute("p4description", lowTicketPropertyConfig.getDescription());
		model.addAttribute("p4header", lowTicketPropertyConfig.getHeader());
		
		model.addAttribute("currentversion",appVersion);

		return "welcome";
	}

	/**
	 * @param ticketPriorityName
	 * @return Request Success or error
	 */
	@RequestMapping(value = "/sendTicketParam", method = RequestMethod.GET)
	@ResponseBody
	public String processParamforTicket(@RequestParam("ticketPriorityName") String ticketPriorityName) {
		if (!StringUtils.isEmpty(ticketPriorityName))
			logger.info("Request Param value : " + ticketPriorityName);
		else
			throw new NullPointerException("Request Parama is Empty from UI Request");
		return ticketService.processBatOrShFile(ticketPriorityName);
	}

}
