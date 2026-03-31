package org.example.configuration;

import org.kohsuke.github.GitHub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GitHubConnection {
	
	private String token = System.getenv("GITHUB_TOKEN");
	
	@Bean
	public GitHub gitHub() throws java.io.IOException {
		
		return GitHub.connectUsingOAuth(token);
	}
}
