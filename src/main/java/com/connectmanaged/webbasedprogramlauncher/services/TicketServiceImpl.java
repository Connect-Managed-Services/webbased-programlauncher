package com.connectmanaged.webbasedprogramlauncher.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectmanaged.webbasedprogramlauncher.configuration.PropertyReader;

/**
 * @author gaurav
 *
 */
@Service
public class TicketServiceImpl implements TicketService {

	private static final Logger logger = LogManager.getLogger(TicketServiceImpl.class);

	public static final String FAILURE = "failure";
	public static final String SUCCESS = "success";

	@Autowired
	private PropertyReader propertyReader;

	/*
	 * method to execute the sell scripting file with parameter Using Runtime
	 * process to execute the bat file or sh
	 */
	@Override
	public String processBatOrShFile(String ticketPriorityName) {
		Process process = null;
		try {
			System.out.println("file location :" + propertyReader.getLocation());
			switch (propertyReader.getOs()) {
			case "linux":
				String[] cmd = { "bash", "-c", "~" + propertyReader.getLocation() + " " + ticketPriorityName };
				process = Runtime.getRuntime().exec(cmd);
				break;
			case "window":
				process = Runtime.getRuntime()
						.exec("cmd.exe /c " + propertyReader.getLocation() + " " + ticketPriorityName);
				break;
			default:
				process = Runtime.getRuntime().exec(propertyReader.getLocation() + " " + ticketPriorityName);
				break;
			}
			process.waitFor(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.isEmpty())
					logger.info("here :" + line);
			}
			int exitvalue = process.exitValue();
			logger.debug("exitValue: " + exitvalue);
			if (exitvalue != 0) {
				logger.info("Not Executed Command via scripting");
				return FAILURE;
			}

		} catch (IOException e) {
			logger.info(e.getMessage());
			return FAILURE;
		} catch (Exception e) {
			logger.info(e.getMessage());
			return FAILURE;
		}

		return SUCCESS;
		// return FAILURE;
	}

}
