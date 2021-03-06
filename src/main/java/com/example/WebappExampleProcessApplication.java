/*
 * Copyright � 2017 - 2018 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import java.io.File;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.event.EventListener;

import com.example.controller.FileUploadController;

 
//@SpringBootApplication
//@EnableProcessApplication
//@EnableDiscoveryClient
@EnableDiscoveryClient
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class WebappExampleProcessApplication {

	@Autowired
	private RuntimeService runtimeService;

	public static void main(String... args) {
		new File(FileUploadController.uploadDirectory).mkdir();

		SpringApplication.run(WebappExampleProcessApplication.class, args);
	}

	@EventListener
	private void processPostDeploy(PostDeployEvent event) {
		runtimeService.startProcessInstanceByKey("Process_1");
	}
}