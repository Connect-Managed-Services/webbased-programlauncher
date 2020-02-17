package com.connectmanaged.webbasedprogramlauncher.configuration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "p2")
public class HighTicketPropertyConfig {
	@NotBlank
	@Size(max=20, min= 4)
	private String taskname;
	
	@NotBlank
	@Size(max=20, min= 4)
	private String tagname;
	
	@NotBlank
	@Size(max=500, min= 4)
	private String description;
	
	@NotBlank
	@Size(max=20, min= 4)
	private String header;

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

}
