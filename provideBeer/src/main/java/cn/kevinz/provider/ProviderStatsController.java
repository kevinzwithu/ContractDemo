package cn.kevinz.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderStatsController {
    private final StatsProvider statsProvider;

    public ProviderStatsController(StatsProvider statsProvider) {
        this.statsProvider = statsProvider;
    }

    @GetMapping(value = "/customers")
    public Response countAllCustomers() {
        return new Response(this.statsProvider.count(IndentType.ALL));
    }

    @GetMapping(value = "/legal")
    public Response countAllLegalCustomers() {
        return new Response(this.statsProvider.count(IndentType.LEGAL));
    }
}

enum IndentType {
    LEGAL, ALL
}

interface StatsProvider {
    int count(IndentType indentType);
}

class Response {
    private int count;

    public Response() {
    }

    public Response(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
