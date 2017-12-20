package cn.kevinz.swagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

	@ApiOperation(value="Get User List", notes="Get all users and put them into a list")
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public String getAllUser() { return "This is user list."; }

	@ApiOperation(value="Get User Information", notes="Get detailed information of specific user.")
	@ApiImplicitParam(name = "name", value = "This is name of user", required = true, dataType = "String")
	@RequestMapping(value="/user/{name}", method=RequestMethod.GET)
	public String getUser(@PathVariable("name") String name) throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("message", "This is user " + name);
		return obj.toString();
	}

	@ApiOperation(value="Create New User", notes="Create a new user who does not exist.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "This is ID of user to specify user.", required = true, dataType = "Long"),
		@ApiImplicitParam(name = "name", value = "This is name of user.", required = true, dataType = "String")
	})
	@RequestMapping(value="/user/{name}", method=RequestMethod.POST)
	public String postUser(@PathVariable("name") String name) {
		return "I've pushed user " + name + " into list.";
	}
}