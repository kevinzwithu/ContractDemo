package cn.kevinz.provider;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import spock.lang.Specification;
import org.junit.Before;

public class ProviderBase extends Specification {

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new BeerIndentController());
    }

}
