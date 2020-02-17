package com.connectmanaged.webbasedprogramlauncher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.connectmanaged.webbasedprogramlauncher.configuration.CriticalTicketPropertConfig;
import com.connectmanaged.webbasedprogramlauncher.configuration.HighTicketPropertyConfig;
import com.connectmanaged.webbasedprogramlauncher.configuration.LowTicketPropertyConfig;
import com.connectmanaged.webbasedprogramlauncher.configuration.MediumTicketPropertyConfig;

@SpringBootApplication
@EnableConfigurationProperties({ CriticalTicketPropertConfig.class, HighTicketPropertyConfig.class,
	LowTicketPropertyConfig.class, MediumTicketPropertyConfig.class})
public class WebbasedprogramlauncherApplication  extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(WebbasedprogramlauncherApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebbasedprogramlauncherApplication.class, args);
	}

}
