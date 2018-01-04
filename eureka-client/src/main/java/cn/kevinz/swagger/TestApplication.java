package cn.kevinz.swagger;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableEurekaClient
@RestController
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String getAllUser() { return "This is user list."; }

	@RequestMapping(value="/user/{name}", method=RequestMethod.GET)
	public String getUser(@PathVariable("name") String name) throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("message", "This is user " + name);
		return obj.toString();
	}

	@RequestMapping(value="/user/{name}", method=RequestMethod.POST)
	public String postUser(@PathVariable("name") String name) {
		return "I've pushed user " + name + " into list.";
	}
}