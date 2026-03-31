package org.example.service;

import java.io.IOException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitHubService {
	
	@Autowired
	private GitHub gitHub;
	
	@McpTool(description = "get GitHub Repository Information for a given repository name")
	public String getRepoInfo(String repoName) {
		
		String repoInfo = "";
		// Placeholder for actual GitHub API call
		try {
			GHRepository repo = gitHub.getRepository(repoName);
			repoInfo = "Repository Name: " + repo.getName() + "\n" +
					   "Description: " + repo.getDescription() + "\n" +
					   "Stars: " + repo.getStargazersCount() + "\n" +
					   "Forks: " + repo.getForksCount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // This would fetch the repository information
		return "Information about repository: " + repoInfo;
	}

}
