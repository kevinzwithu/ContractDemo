package cn.kevinz.provider;
import org.junit.Before;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

public class ProviderBase {
    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new BeerIndentController(),
                new ProviderStatsController(stubbedStatsProvider()));
    }

    private StatsProvider stubbedStatsProvider() {
        return indentType -> {
            switch (indentType) {
                case LEGAL:
                    return 100;
                case ALL:
                    return 200;
            }
            return 0;
        };
    }

    public void assertThatRejectionReasonIsNull(Object rejectionReason) {
        assert rejectionReason == null;
    }
}
